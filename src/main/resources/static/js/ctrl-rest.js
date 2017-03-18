'use strict';

var app = angular.module("app");

app.service('sharedProperties', function() {
  var selectedCountyId = 0;
  var selectedCityId = 0;
  
  return {
    getSelectedCountyId: function(){
      return selectedCountyId;
    },
    setSetlectedCountyId: function(value){
      selectedCountyId = value;
    },
    getSelectedCityId: function(){
      return selectedCityId;
    },
    setSelectedCityId: function(value){
      selectedCityId = value;
    }
  };
  
});


// Controller for County dropdown list
app.controller('countyOptCtrl', function($scope, $http, $log, sharedProperties){
  $http({
    method : 'GET',
    url : '/area/county'
  }).then(function successCallback(response){
    $scope.counties = response.data.responseData.counties;
    $scope.counties.unshift({'county': 'All', 'countyId': 0})
    $scope.selectedCounty = $scope.counties[0]
    $scope.onChange = function(){
      sharedProperties.setSetlectedCountyId($scope.selectedCounty.countyId);
    }
  })
});


// Controller for City dropdown list
app.controller('cityOptCtrl', function($scope, $http, $log, sharedProperties){
  $scope.selectedCityId = sharedProperties.getSelectedCityId();
  $scope.cities = [{'city': 'All', 'cityId': 0}]
  $scope.selectedCity = $scope.cities[$scope.selectedCityId];
  $scope.onEnter = function(){
    $scope.countyId = sharedProperties.getSelectedCountyId();
    $http({
      method : 'GET',
      url : '/area/city/' + $scope.countyId
    }).then(function successCallback(response){
      $scope.cities = response.data.responseData.cities;
      $scope.cities.unshift({'city': 'All', 'cityId': 0})
      $scope.selectedCity = $scope.cities[0]
    })
  };
  $scope.OnChange = function(){
    sharedProperties.setSelectedCityId($scope.selectedCity.cityId);
  }
  
});

// Controller for verification
app.controller('viewCtrl', function($scope, $log, sharedProperties){
  $scope.countyId = sharedProperties.getSelectedCountyId();
  $scope.onClick = function(){
    $scope.countyId = sharedProperties.getSelectedCountyId();
  }
})
