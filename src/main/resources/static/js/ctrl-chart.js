'use strict';

var app = angular.module("app");

app.controller("allAreaLineCtrl", function($rootScope, $scope, $log, chartService, allAreaData) {
  
  var cleanupFunc = $rootScope.$on('allAreaDrawlistener', function(){
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
      $scope.series = ['Series A'];
      $scope.data = data.getData();
      $scope.datasetOverride = [{
        yAxisID: 'y-axis-1'
      }];
      $scope.options = {
        scales: {
          xAxes: [{
            type: "time",
            display: true,
            scaleLabel: {
              display: true,
              labelString: 'Date'
            }
          }],
          yAxes: [{
            display: true,
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
