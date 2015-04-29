'use strict';

angular.module('TaxPayerApp')
  .controller('MainCtrl', function ($scope, Authentication, RouteFilter) {

    $scope.canAccess = function(route)
    {
        return RouteFilter.canAccess(route);
    }
  });
