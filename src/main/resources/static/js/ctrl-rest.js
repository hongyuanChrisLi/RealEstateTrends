'use strict';

var app = angular.module("app");

app.service('sharedProperties', function() {
  var selCountyId = 0;
  var selCityId = 0;
  var selZipcode = '0';
  
  return {
    
    getSelCountyId: function(){
      return selCountyId;
    },
    setSelCountyId: function(value){
      selCountyId = value;
    },
    
    getSelCityId: function(){
      return selCityId;
    },
    setSelCityId: function(value){
      selCityId = value;
    },
    
    getSelZipcode: function(){
      return selZipcode;
    },
    setSelZipcode: function(value){
      selZipcode = value;
    }
   
  };
  
});


// Controller for County dropdown list
app.controller('countyOptCtrl', function($rootScope, $scope, $http, $log, sharedProperties){
  $http({
    method : 'GET',
    url : '/area/county'
  }).then(function successCallback(response){
    $scope.countyObjs = response.data.responseData.counties;
    $scope.countyObjs.unshift({'county': 'All', 'countyId': 0})
    $scope.selCountyObj = $scope.countyObjs[0]
    $scope.onChange = function(){
      $rootScope.$broadcast('countyListener', {countyId : $scope.selCountyObj.countyId});
      sharedProperties.setSelCountyId($scope.selCountyObj.countyId)
    }
  })
});

//Controller for City dropdown list
app.controller('cityOptCtrl', function($rootScope, $scope, $http, $log, sharedProperties){
  
  // initialization
  $scope.cityObjs = [{'city': 'All', 'cityId': 0}]
  $scope.selCityObj = $scope.cityObjs[0]
  
  var cleanupFunc = $rootScope.$on('countyListener', function(event, args){
    var countyId = args.countyId;
    
    // Rest API call
    $http({
      method : 'GET',
      url : '/area/city/' + countyId
    }).then(function successCallback(response){
      $scope.cityObjs = response.data.responseData.cities;
      $scope.cityObjs.unshift({'city': 'All', 'cityId': 0})
      $scope.selCityObj = $scope.cityObjs[0]
    });
    
    // Reset downstream
    $rootScope.$broadcast('cityListener', {cityId : 0});
  });

  $scope.onChange = function(){ 
    $rootScope.$broadcast('cityListener', {cityId : $scope.selCityObj.cityId});
    sharedProperties.setSelCityId($scope.selCityObj.cityId)
   };
  
  $scope.$on('$destroy', function(){
    cleanupFunc();
  });
});


//Controller for Zipcode dropdown list
app.controller('zipcodeOptCtrl', function($rootScope, $scope, $http, $log, sharedProperties){
  
  // functions
  var initFunc = function() {
    $scope.zipcodeObjs = [{'zipcode': 'All'}]
    $scope.selZipcodeObj = $scope.zipcodeObjs[0]
  }
  
  // Core
  initFunc();
  var cleanupFunc = $rootScope.$on('cityListener', function(event, args){
    var cityId = args.cityId;
    if (cityId == 0 ){
      initFunc();
    } else {
      $http({
        method : 'GET',
        url : '/area/zipcode/' + cityId
      }).then(function successCallback(response){
        $scope.zipcodeObjs = response.data.responseData.zipcodes;
        $scope.zipcodeObjs.unshift({'zipcode': 'All'})
        $scope.selZipcodeObj = $scope.zipcodeObjs[0]
      });
    }
  });

  $scope.onChange = function(){ 
    $log.info(sharedProperties)
    sharedProperties.setSelZipcode($scope.selZipcodeObj.zipcode)
   };
  
  $scope.$on('$destroy', function(){
    cleanupFunc();
  });
});


// Controller for verification
app.controller('viewCtrl', function($scope, $log, sharedProperties){
  
  $scope.onClick = function() {
    $scope.selCountyId = sharedProperties.getSelCountyId()
    $scope.selCityId = sharedProperties.getSelCityId()
    $scope.selZipcode = sharedProperties.getSelZipcode()
  }
})
