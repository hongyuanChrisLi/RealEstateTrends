'use strict';

var app = angular.module("app");

// Controller for County dropdown list
app.controller('countyOptCtrl', function($rootScope, $scope, $http, $log,
        selProperties) {
  $http({
    method: 'GET',
    url: '/area/county'
  }).then(function successCallback(response) {
    $scope.countyObjs = response.data.responseData.counties;
    $scope.countyObjs.unshift({
      'county': 'All',
      'countyId': 0
    })
    $scope.selCountyObj = $scope.countyObjs[0]
    $scope.onChange = function() {
      $rootScope.$broadcast('countyListener', {
        countyId: $scope.selCountyObj.countyId
      });
      selProperties.setSelCountyId($scope.selCountyObj.countyId)
    }
  })
});

// Controller for City dropdown list
app.controller('cityOptCtrl', function($rootScope, $scope, $http, $log,
        selProperties) {

  // initialization
  $scope.cityObjs = [{
    'city': 'All',
    'cityId': 0
  }]
  $scope.selCityObj = $scope.cityObjs[0]

  var cleanupFunc = $rootScope.$on('countyListener', function(event, args) {
    var countyId = args.countyId;

    // Rest API call
    $http({
      method: 'GET',
      url: '/area/city/' + countyId
    }).then(function successCallback(response) {
      $scope.cityObjs = response.data.responseData.cities;
      $scope.cityObjs.unshift({
        'city': 'All',
        'cityId': 0
      })
      $scope.selCityObj = $scope.cityObjs[0]
    });

    // Reset downstream
    $rootScope.$broadcast('cityListener', {
      cityId: 0
    });
  });

  $scope.onChange = function() {
    $rootScope.$broadcast('cityListener', {
      cityId: $scope.selCityObj.cityId
    });
    selProperties.setSelCityId($scope.selCityObj.cityId)
  };

  $rootScope.$on('$destroy', function() {
    cleanupFunc();
  });
});

// Controller for Zipcode dropdown list
app.controller('zipcodeOptCtrl', function($rootScope, $scope, $http, $log,
        selProperties) {

  // functions
  var initFunc = function() {
    $scope.zipcodeObjs = [{
      'zipcode': 'All'
    }]
    $scope.selZipcodeObj = $scope.zipcodeObjs[0]
  }

  // Core
  initFunc();
  var cleanupFunc = $rootScope.$on('cityListener', function(event, args) {
    var cityId = args.cityId;
    if (cityId == 0) {
      initFunc();
    } else {
      $http({
        method: 'GET',
        url: '/area/zipcode/' + cityId
      }).then(function successCallback(response) {
        $scope.zipcodeObjs = response.data.responseData.zipcodes;
        $scope.zipcodeObjs.unshift({
          'zipcode': 'All'
        })
        $scope.selZipcodeObj = $scope.zipcodeObjs[0]
      });
    }
  });

  $scope.onChange = function() {
    $log.info(selProperties)
    selProperties.setSelZipcode($scope.selZipcodeObj.zipcode)
  };

  $rootScope.$on('$destroy', function() {
    cleanupFunc();
  });
});

// 
app.controller('allAreaRptCtrl', function($rootScope, $scope, $http, $log, allAreaData) {
  $http({
    method: 'GET',
    url: '/price-rpt/prop-addr/0-0-0-0'
  }).then(
          function successCallback(response) {
            allAreaData.parseData(response.data.responseData.priceRpts,
                    'avgPriceStructSqft');
           $log.info(allAreaData.getData());
           $rootScope.$broadcast('allAreaDrawlistener');
          });
});


// 
app.controller('selAreaRptCtrl', function($rootScope, $scope, $http, $log,
        selProperties, selAreaData) {

  var cleanupFunc = $rootScope.$on('selAreaListener', function(event, args) {
    $http(
            {
              method: 'GET',
              url: '/price-rpt/prop-addr/' + selProperties.getSelCountyId()
                      + '-' + selProperties.getSelCityId() + '-'
                      + selProperties.getSelZipcode() + '-0'
            }).then(
            function successCallback(response) {
              selAreaData.parseData(response.data.responseData.priceRpts,
                      'avgPriceStructSqft');
              $rootScope.$broadcast('selAreaDrawlistener');
            });
  });

  $rootScope.$on('$destroy', function() {
    cleanupFunc();
  });

});

// Controller for verification
app.controller('viewCtrl', function($rootScope, $scope, $log, selProperties) {

  $scope.onClick = function() {
    $scope.selCountyId = selProperties.getSelCountyId()
    $scope.selCityId = selProperties.getSelCityId()
    $scope.selZipcode = selProperties.getSelZipcode()
    $log.info(selProperties)
    $rootScope.$broadcast('selAreaListener');
  }
})

//
app.service('selProperties', function() {
  var selCountyId = 0;
  var selCityId = 0;
  var selZipcode = '0';

  return {

    getSelCountyId: function() {
      return selCountyId;
    },
    setSelCountyId: function(value) {
      selCountyId = value;
    },

    getSelCityId: function() {
      return selCityId;
    },
    setSelCityId: function(value) {
      selCityId = value;
    },

    getSelZipcode: function() {
      return selZipcode;
    },
    setSelZipcode: function(value) {
      selZipcode = value;
    }

  };

});

//
app.service('allAreaData', ['genericDataExtract', function(genericDataExtract) {
  var data = [];
  
  return {
    getData: function() {
      return data;
    },
    parseData: function(priceRpts, priceType) {
      genericDataExtract.parseData(priceRpts, priceType);
      data = genericDataExtract.getData();
    }
  }
}]);

//
app.service('selAreaData', ['genericDataExtract', function(genericDataExtract) {
  var data = [];
  
  return {
    getData: function() {
      return data;
    },
    parseData: function(priceRpts, priceType) {
      genericDataExtract.parseData(priceRpts, priceType);
      data = genericDataExtract.getData();
    }
  }
}]);

app.service('genericDataExtract', function() {
  var data = [];
  var labels = [];

  return {
    getData: function() {
      return data;
    },
    getLabels: function() {
      return labels;
    },
    parseData: function(priceRpts, priceType) {
      
      data = [];
      labels = [];
      
      var len = priceRpts.length;
      for (var i = 0; i < len; i++) {
        var value = priceRpts[i];
        var dateStr = value.rptDate;
        var dateA = dateStr.split("-")
        var date = new Date(dateA[0], dateA[1], dateA[2])
        var item = {
          x: date,
          y: value[priceType]
        };
        data.push(item);
        labels.push(dateStr);
      }
    },
  }
})
