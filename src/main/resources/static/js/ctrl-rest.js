'use strict';

var app = angular.module("app");

/*************************/
/* Controller for County dropdown list */
/*************************/
app.controller('countyOptCtrl', function($rootScope, $scope, $http, $log,
        selCritiriaSvc) {
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
      selCritiriaSvc.setSelCountyId($scope.selCountyObj.countyId);
      selCritiriaSvc.setSelCityId(0);
    }
  })
});

/*************************/
/* Controller for City dropdown list */
/*************************/
app.controller('cityOptCtrl', function($rootScope, $scope, $http, $log,
        selCritiriaSvc) {

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
    selCritiriaSvc.setSelZipcode('0');
  });

  $scope.onChange = function() {
    $rootScope.$broadcast('cityListener', {
      cityId: $scope.selCityObj.cityId
    });
    selCritiriaSvc.setSelCityId($scope.selCityObj.cityId)
    selCritiriaSvc.setSelZipcode('0');
  };

  $rootScope.$on('$destroy', function() {
    cleanupFunc();
  });
});

/*************************/
/* Controller for Zipcode dropdown list */
/*************************/
app.controller('zipcodeOptCtrl', function($rootScope, $scope, $http, $log,
        selCritiriaSvc) {

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
    selCritiriaSvc.setSelZipcode($scope.selZipcodeObj.zipcode)
  };

  $rootScope.$on('$destroy', function() {
    cleanupFunc();
  });
});

/*************************/
/* Controller for Type dropdown list */
/*************************/
app.controller('propTypeOptCtrl', function($rootScope, $scope, $log,
        selCritiriaSvc, propTypeSvc) {
  $scope.propTypeObjs = propTypeSvc.getPropTypes();
  $scope.selpropTypeObj =  $scope.propTypeObjs[selCritiriaSvc.getSelTypeId()];

  $scope.onChange = function() {
    selCritiriaSvc.setSelTypeId($scope.selpropTypeObj.typeId)
  };
});

/*************************/
/* Select Rest data for the entire area */
/*************************/
app.controller('allAreaRptCtrl', function($rootScope, $scope, $http, $log,
        allAreaData) {

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

/*************************/
/* Select Rest data for a specific area */
/*************************/
app.controller('selAreaRptCtrl', function($rootScope, $scope, $http, $log,
        selCritiriaSvc, selAreaData) {

  var dataUpdFunc = function() {
    var url = '/price-rpt/prop-addr/' + selCritiriaSvc.getSelCountyId() + '-'
            + selCritiriaSvc.getSelCityId() + '-'
            + selCritiriaSvc.getSelZipcode() + '-'
            + selCritiriaSvc.getSelTypeId();
    $http({
      method: 'GET',
      url: url
    }).then(
            function successCallback(response) {
              selAreaData.parseData(response.data.responseData.priceRpts,
                      'avgPriceStructSqft');
              $rootScope.$broadcast('selAreaDrawlistener');
            });
    $log.info(url)
  };

  dataUpdFunc();
  var cleanupFunc = $rootScope.$on('selAreaListener', function(event, args) {
    dataUpdFunc();
  });

  $rootScope.$on('$destroy', function() {
    cleanupFunc();
  });

});

/*************************/
/* Controller for verification */
/*************************/
app.controller('viewCtrl', function($rootScope, $scope, $log, selCritiriaSvc) {

  $scope.onClick = function() {
    $scope.selCountyId = selCritiriaSvc.getSelCountyId()
    $scope.selCityId = selCritiriaSvc.getSelCityId()
    $scope.selZipcode = selCritiriaSvc.getSelZipcode()
    $log.info(selCritiriaSvc)
    $rootScope.$broadcast('selAreaListener');
  }
})

/*************************/
/* Service for sharing selected property data between controllers */
/*************************/
app.service('selCritiriaSvc', function() {
  var selCountyId = 0;
  var selCityId = 0;
  var selZipcode = '0';
  var selTypeId = 0;

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
    },
    
    getSelTypeId: function(){
      return selTypeId;
    },
    setSelTypeId: function(value){
      selTypeId = value;
    }
  };
});

/*************************/
/* Service for property type lookup */
/*************************/
app.service("propTypeSvc", function(){
  var propTypes = [
    {
      type: "All",
      typeId: 0
    },
    {
      type: "Single Family",
      typeId: 1
    },
    {
      type: "Townhouse",
      typeId: 2
    },
    {
      type: "Condo",
      typeId: 3
    },
    {
      type: "Multi-Unit",
      typeId: 4
    },
    {
      type: "Mobile",
      typeId: 5
    }
  ];
  
  return {
    
    getPropTypes: function() {
      return propTypes;
    }
  }
})

