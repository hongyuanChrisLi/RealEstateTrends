'use strict';

// angular.js main app initialization
var app = angular.module('RealEstateTrends', []).config(
		[ '$routeProvider', function($routeProvider) {
			$routeProvider.when('/', {
				templateUrl : 'pages/index.html',
				activetab : 'projects',
				controller : HomeCtrl
			}).when('/project/:projectId', {
				templateUrl : function(params) {
					return 'pages/' + params.projectId + '.html';
				},
				controller : ProjectCtrl,
				activetab : 'projects'
			}).when('/privacy', {
				templateUrl : 'pages/privacy.html',
				controller : PrivacyCtrl,
				activetab : 'privacy'
			}).when('/about', {
				templateUrl : 'pages/about.html',
				controller : AboutCtrl,
				activetab : 'about'
			}).otherwise({
				redirectTo : '/'
			});
		} ]);

app.config([ '$locationProvider', function($location) {
	$location.hashPrefix('!');
} ]);
