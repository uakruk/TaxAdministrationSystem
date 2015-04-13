'use strict';

/* Controllers */

//var phonecatControllers = angular.module('phonecatControllers', []);
//
//phonecatControllers.controller('PhoneListCtrl', ['$scope', 'Phone',
//  function($scope, Phone) {
//    $scope.phones = Phone.query();
//    $scope.orderProp = 'age';
//  }]);
//
//phonecatControllers.controller('PhoneDetailCtrl', ['$scope', '$routeParams', 'Phone',
//  function($scope, $routeParams, Phone) {
//    $scope.phone = Phone.get({phoneId: $routeParams.phoneId}, function(phone) {
//      $scope.mainImageUrl = phone.images[0];
//    });
//
//    $scope.setImage = function(imageUrl) {
//      $scope.mainImageUrl = imageUrl;
//    }
//  }]);

var KursachControllers = angular.module('KursachControllers',[]);

KursachControllers.controller('UserListCtrl',['$scope','$http',
  function ($scope, $http) {
      $http.get('users/users2.json').success(function(data) {
        $scope.users = data;
      });
      $scope.orderProp = 'age';
  }]);