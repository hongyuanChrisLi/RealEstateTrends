

var app = angular.module("app");


app.controller("allAreaLineTcCtrl", function($rootScope, $scope, $log, chartService, allAreaData) {
  
  $scope.myData = {
        datasets: [{
            label: 'Scatter Dataset',
            data: [{
                x: -10,
                y: 0
            }, {
                x: 0,
                y: 10
            }, {
                x: 10,
                y: 5
            }]
        }]
    };

        $scope.myOptions = {
                scales: {
                  xAxes: [{
                      type: 'linear',
                      position: 'bottom'
                  }]
              }
          };

        $scope.onChartClick = function (event) {
          console.log(event);
        };
  
});

