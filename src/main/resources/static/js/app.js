'use strict';

// angular.js main app initialization
var app = angular.module('app', ['ngRoute', 'tc.chartjs']).config(
        ['$routeProvider', function($routeProvider) {
          $routeProvider.when('/', {
            templateUrl: 'pages/index.html',
            activetab: 'projects'
          }).when('/project/:projectId', {
            templateUrl: function(params) {
              return 'pages/' + params.projectId + '.html';
            },
            activetab: 'projects'
          }).when('/about', {
            templateUrl: 'pages/about.html',
            activetab: 'about'
          }).otherwise({
            redirectTo: '/'
          });
        }]);

app.config(['$locationProvider', function($location) {
  $location.hashPrefix('!');
}]);

app.config(function($logProvider) {
  $logProvider.debugEnabled(false);
});



