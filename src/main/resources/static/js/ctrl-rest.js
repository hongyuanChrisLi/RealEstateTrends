'use strict';

var app = angular.module("app");

// Controller for County dropdown list
app.controller('countyOptCtrl', function($scope, $http, $log){
  $http({
    method : 'GET',
    url : '/area/county'
  }).then(function successCallback(response){
    var jsonCounties = response.data.responseData.counties;
    var counties = [];
    var num = jsonCounties.length;
    for ( var i = 0; i < num; i++ ){
      counties.push(jsonCounties[i].county)
    }
    $scope.names = counties;
  })
});
