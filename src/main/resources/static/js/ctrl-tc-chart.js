'use strict';

var app = angular.module("app");

app.controller("allAreaLineCtrl", function($rootScope, $scope, $log, chartService, allAreaData) {
  var cleanupFunc = $rootScope.$on('allAreaDrawlistener', function() {
    chartService.draw($scope, allAreaData, "Real Estate Trends");
  });

  $rootScope.$on('$destroy', function() {
    cleanupFunc();
  });

});


app.controller("selAreaStructSqftLineCtrl", function($rootScope, $scope, selChartService, selAreaStructSqftData) {
  var cleanupFunc = $rootScope.$on('selAreaDrawlistener', function(){
    selChartService.draw($scope, selAreaStructSqftData, "Trends: Price / Structure Sqft");
  });
 
  $rootScope.$on('$destroy', function() {
    cleanupFunc();
  });
  
})

app.controller("selAreaTotSqftLineCtrl", function($rootScope, $scope, selChartService, selAreaTotSqftData) {
  var cleanupFunc = $rootScope.$on('selAreaDrawlistener', function(){
    selChartService.draw($scope, selAreaTotSqftData, "Trends: Price / Total Sqft");
  });
 
  $rootScope.$on('$destroy', function() {
    cleanupFunc();
  });
  
});


app.controller("selAreaLineCtrl", function($rootScope, $scope, selChartService, selAreaData) {
  var cleanupFunc = $rootScope.$on('selAreaDrawlistener', function(){
    selChartService.draw($scope, selAreaData, "Trends: Price");
  });
 
  $rootScope.$on('$destroy', function() {
    cleanupFunc();
  });
  
});


app.controller("mlsDailyRptPieCtrl", function($rootScope, $scope, pieService, mlsDailyRptData){
  
  var cleanupFunc = $rootScope.$on('mlsDailyRptDrawlistener', function(){
    pieService.draw($scope, mlsDailyRptData.getPieLabels(), mlsDailyRptData.getPieData());
  });
 
  $rootScope.$on('$destroy', function() {
    cleanupFunc();
  });
  
});

app.service('selChartService', ['chartService', function(chartService){
  return {
    draw($scope, data, label){
      chartService.draw($scope, data);
      // $scope.myData.datasets[0].pointBorderColor = "rgba(215, 173, 66, 1)";
      $scope.myData.datasets[0].borderColor = "rgba(215, 173, 66, 1)";
      $scope.myData.datasets[0].backgroundColor = "rgba(75,192,192,1)";
      $scope.myData.datasets[0].label = label
    }
  }
}]);

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
              pointRadius: 2,
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
});

app.service('pieService', function(){
  return {
    draw($scope, pieLabels, pieData){
      $scope.myData = {
              labels: pieLabels,
            datasets: [
                {
                    data: pieData,
                    backgroundColor: [
                        "#FF6384",
                        "#36A2EB",
                        "#FFCE56",
                        "#33cc33",
                        "#e600ac"
                    ],
                    hoverBackgroundColor: [
                        "#FF6384",
                        "#36A2EB",
                        "#FFCE56",
                        "#33cc33",
                        "#e600ac"
                    ]
                }]
        };
    }
  }
})
