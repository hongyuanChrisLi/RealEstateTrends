'use strict';

var app = angular.module("app");

app.controller("allAreaLineCtrl", function($rootScope, $scope, $log, chartService, allAreaData) {
  var cleanupFunc = $rootScope.$on('allAreaDrawlistener', function() {
    chartService.draw($scope, allAreaData);
  });

  $rootScope.$on('$destroy', function() {
    cleanupFunc();
  });

});


app.controller("selAreaLineCtrl", function($rootScope, $scope, chartService, selAreaData) {
  var cleanupFunc = $rootScope.$on('selAreaDrawlistener', function(){
    chartService.draw($scope, selAreaData);
  });
 
  $rootScope.$on('$destroy', function() {
    cleanupFunc();
  });
  
})


app.service('chartService', function(){
  return {
    draw($scope, data){
    $scope.myData = {
            datasets: [{
              label: 'Scatter Dataset',
              fill: false,
              lineTension: 0.1,
              backgroundColor: "rgba(75,192,192,0.4)",
              borderColor: "rgba(75,192,192,1)",
              borderCapStyle: 'butt',
              borderDash: [],
              borderDashOffset: 0.0,
              borderJoinStyle: 'miter',
              pointBorderColor: "rgba(75,192,192,1)",
              pointBackgroundColor: "#fff",
              pointBorderWidth: 1,
              pointHoverRadius: 5,
              pointHoverBackgroundColor: "rgba(75,192,192,1)",
              pointHoverBorderColor: "rgba(220,220,220,1)",
              pointHoverBorderWidth: 2,
              pointRadius: 1,
              pointHitRadius: 10,
              data: data.getData()
            }]
          };

          $scope.myOptions = {
            scales: {
              xAxes: [{
                type: 'time',
                position: 'bottom'
              }]
            }
          }
      }
  }
})
