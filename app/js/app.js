'use strict';

/* App Module */

var KursachApp = angular.module('KursachApp', [
  'ngRoute',
  'phonecatAnimations',

  'phonecatFilters',
  'phonecatServices',
  'KursachControllers'
]);

KursachApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/test', {
              templateUrl: 'partials/test.html',
              controller: 'UserListCtrl'
            }).
      when('/authplace', {
              templateUrl: 'partials/auth-place.html',
              controller: 'UserListCtrl'
            }).
      otherwise({
        redirectTo: '/test'
      });
  }]);
