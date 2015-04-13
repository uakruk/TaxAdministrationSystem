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

KursachControllers.controller('UserProfileCtrl',['$scope','$http',
  function ($scope, $http) {
      $http.get('users/users2.json').success(function(data) {
        $scope.users = data;
      });
      $scope.orderProp = 'age';
  }]);
KursachControllers.controller('AuthCtrl',
  function($scope, $auth) {
      $scope.handleRegBtnClick = function() {
        $auth.submitRegistration($scope.registrationForm)
          .then(function(resp) {

          })
          .catch(function(resp) {
          });
      };
  });
KursachControllers.controller('LoginCtrl', function($scope, $auth) {
    $scope.handleLoginBtnClick = function() {
      $auth.submitLogin($scope.loginForm)
        .then(function(resp) {

        })
        .catch(function(resp) {
        });
    };
  });
KursachControllers.controller('SignoutCtrl', function($scope, $auth) {
    $scope.handleSignOutBtnClick = function() {
      $auth.signOut()
        .then(function(resp) {
          // handle success response
        })
        .catch(function(resp) {
          // handle error response
        });
    };
  });