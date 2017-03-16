'use strict';

// angular.js main app initialization
var app = angular.module('RealEstateTrends', ['ngRoute', 'chart.js']).config(
        ['$routeProvider', function($routeProvider) {
          $routeProvider.when('/', {
            templateUrl: 'pages/index.html',
            activetab: 'projects',
            controller: HomeCtrl
          }).when('/project/:projectId', {
            templateUrl: function(params) {
              return 'pages/' + params.projectId + '.html';
            },
            controller: ProjectCtrl,
            activetab: 'projects'
          }).when('/privacy', {
            templateUrl: 'pages/privacy.html',
            controller: PrivacyCtrl,
            activetab: 'privacy'
          }).when('/about', {
            templateUrl: 'pages/about.html',
            controller: AboutCtrl,
            activetab: 'about'
          }).otherwise({
            redirectTo: '/'
          });
        }]);

app.config(['$locationProvider', function($location) {
  $location.hashPrefix('!');
}]);

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
