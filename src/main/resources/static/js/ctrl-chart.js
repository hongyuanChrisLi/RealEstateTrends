'use strict';


Chart.defaults.global.tooltips.enabled = false;
//Chart.defaults.global.responsive = false;
Chart.defaults.global.showTooltips = false;

var app = angular.module("app");

app.controller("allAreaLineCtrl", function($rootScope, $scope, $log, chartService, allAreaData) {
  
  var cleanupFunc = $rootScope.$on('allAreaDrawlistener', function(){
    var data = allAreaData.getData()
    $log.info(data[0]['x'])
    chartService.draw($scope, allAreaData);
  });
 
  $rootScope.$on('$destroy', function() {
    cleanupFunc();
  });
  
})

app.controller("selAreaLineCtrl", function($rootScope, $scope, chartService, selAreaData) {
  var cleanupFunc = $rootScope.$on('selAreaDrawlistener', function(){
    chartService.draw($scope, selAreaData);
  });
 
  $rootScope.$on('$destroy', function() {
    cleanupFunc();
  });
  
})

// 
app.service('chartService', function(){
  
  return {
    draw($scope, data){
      $scope.labels = data.getLabels();
      $scope.series = ['Series A'];
      $scope.data = data.getData();
      $scope.datasetOverride = [{
        yAxisID: 'y-axis-1'
      }];
      $scope.onHover = function (points, evt) {
        console.log(points, evt);
      };
      $scope.options = {
        scales: {
          xAxes: [{
            type: "time",
            display: true,
            scaleLabel: {
              display: true,
              labelString: 'Date'
            },
            time: {
              tooltipFormat: "MM-DD-YYYY"
            }
          }],
          yAxes: [{
            display: true,
            type: 'linear',
            scaleLabel: {
              display: true,
              labelString: 'value'
            }
          }]
        },
        elements: {
          line: {
            fill: false
          }
        }
      };
    }
  }
});



app.controller("LineCtrl", function ($rootScope, $scope) {
  
  var dateFunc = function newDate(days) {
    return moment().add(days, 'd').toDate();
  }
  
  var cleanupFunc = $rootScope.$on('allAreaDrawlistener', function(){
    $scope.series = ['Series A'];
    $scope.data = [{
      x: 11,
      y: 65
    },{
      x: 22,
      y: 59
    },{
      x: 40,
      y: 80
    },{
      x: 77,
      y: 81
    }];
    $scope.onClick = function (points, evt) {
      console.log(points, evt);
    };
    $scope.datasetOverride = [{ yAxisID: 'y-axis-1' }];
    $scope.options = {
      scales: {
        xAxes: [{
          type: 'linear',
          position: 'bottom'
      }],
        yAxes: [{
            id: 'y-axis-1',
            type: 'linear',
            display: true,
            position: 'left'
          }]
        },
      elements: {
        line: {
          fill: false
        }
      }
    };
  });
});



app.controller("LineCtrlPrices", function ($rootScope, $scope, allAreaData) {
  
  var cleanupFunc = $rootScope.$on('allAreaDrawlistener', function(){
    $scope.labels = allAreaData.getLabels();
    $scope.series = ['Series A'];
    var data = allAreaData.getPrices();
    $scope.data = [data];
    $scope.onClick = function (points, evt) {
      console.log(points, evt);
    };
    $scope.datasetOverride = [{ yAxisID: 'y-axis-1' }];
    $scope.options = {
      scales: {
        yAxes: [
          {
            id: 'y-axis-1',
            type: 'linear',
            display: true,
            position: 'left'
          } 
        ]
      }
    };
  });
});



