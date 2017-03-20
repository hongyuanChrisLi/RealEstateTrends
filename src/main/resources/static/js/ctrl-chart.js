'use strict';

var app = angular.module("app");

app.controller("allAreaTrendLineCtr", function($scope, overallData){
  // $scope.labels = overallData.getLabels();
  $scope.series = ['Series A'];
  $scope.data = overallData.getData();
  $scope.datasetOverride = [{yAxisID: 'y-axis-1'}];
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
    }
  };
  
})


// Controller for chart
app.controller("LineCtrl", function($scope) {

  $scope.labels = ["January", "February", "March", "April", "May", "June",
      "July"];
  $scope.series = ['Series A', 'Series B'];
  $scope.data = [[65, 59, 80, 81, 56, 55, 40], [28, 48, 40, 19, 86, 27, 90]];
  $scope.onClick = function(points, evt) {
    console.log(points, evt);
  };
  $scope.datasetOverride = [{
    yAxisID: 'y-axis-1'
  }, {
    yAxisID: 'y-axis-2'
  }];
  $scope.options = {
    scales: {
      yAxes: [{
        id: 'y-axis-1',
        type: 'linear',
        display: true,
        position: 'left'
      }, {
        id: 'y-axis-2',
        type: 'linear',
        display: true,
        position: 'right'
      }]
    }
  };
});
