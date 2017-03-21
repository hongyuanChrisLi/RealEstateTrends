
var app = angular.module("app");

app.service('allAreaData', ['genericDataExtract', function(genericDataExtract) {
  var data = [];
  var labels = [];
  var prices = [];

  return {
    getData: function() {
      return data;
    },
    getLabels: function() {
      return labels;
    },
    getPrices: function() {
      return prices;
    },
    parseData: function(priceRpts, priceType) {
      genericDataExtract.parseData(priceRpts, priceType);
      data = genericDataExtract.getData();
      labels = genericDataExtract.getLabels();
      prices = genericDataExtract.getPrices();
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
  var prices = [];
  var labels = [];

  return {
    getData: function() {
      return data;
    },
    getLabels: function() {
      return labels;
    },
    getPrices: function() {
      return prices;
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
        prices.push(value[priceType]);
      }
    },
  }
})