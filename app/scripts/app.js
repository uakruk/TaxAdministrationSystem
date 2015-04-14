'use strict';

angular
  .module('TaxPayerApp', [
    'ngRoute',
    'ngCookies',
    'ngResource',
    'ngSanitize'
  ])
  .config(function ($routeProvider) {

    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl'
      })
      .when('/loading', {
        templateUrl: 'views/loading.html',
        controller: 'LoadingCtrl'
      })
      .when('/profile', {
        templateUrl: 'views/profile.html',
        controller: 'ProfileCtrl'
      })
      .when('/settings', {
        templateUrl: 'views/settings.html',
        controller: 'SettingsCtrl'
      })
      .when('/signin', {
        templateUrl: 'views/login.html',
        controller: 'SigninCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
  })
//  .config(function($locationProvider, $httpProvider){
//    $httpProvider.responseInterceptors.push('httpInterceptor');
//  })
  .run(function (Authentication, Application, $rootScope, $location, RouteFilter,api) {

    api.init();

    Authentication.requestUser().then(function() {

      Application.makeReady();
    });


    $rootScope.$on('$locationChangeStart', function(scope, next, current) {

      if($location.path() === '/loading') return;

      if(! Application.isReady())
      {
        $location.path('loading');
      }

      RouteFilter.run($location.path());
    })
  });

