'use strict';

var app = angular.module("app");

app.service('sharedProperties', function() {
  var selectedCountyId = 0;
  
  return {
    getSelectedCountyId: function(){
      return selectedCountyId;
    },
    setSetlectedCountyId: function(value){
      selectedCountyId = value;
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
      $log.info($scope.selectedCounty)
      $log.info($scope.selectedCounty['countyId'])
      $log.info($scope.selectedCounty.countyId)
      sharedProperties.setSetlectedCountyId($scope.selectedCounty.countyId);
    }
  })
});

app.controller('viewCtrl', function($scope, $log, sharedProperties){
  $scope.countyId = sharedProperties.getSelectedCountyId();
  $scope.onClick = function(){
    $scope.countyId = sharedProperties.getSelectedCountyId();
  }
})
