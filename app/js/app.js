'use strict';

/* App Module */

var KursachApp = angular.module('KursachApp', [
  'ngRoute',
  'ng-token-auth',
  'phonecatAnimations',
  'phonecatFilters',
  'phonecatServices',
  'KursachControllers'
]);

KursachApp.config(function($authProvider) {
              $authProvider.configure({
                apiUrl:                  '/api',
                tokenValidationPath:     '/auth/validate_token',
                signOutUrl:              '/auth/sign_out',
                emailRegistrationPath:   '/auth',
                accountUpdatePath:       '/auth',
                accountDeletePath:       '/auth',
                confirmationSuccessUrl:  window.location.href,
                passwordResetPath:       '/auth/password',
                passwordUpdatePath:      '/auth/password',
                passwordResetSuccessUrl: window.location.href,
                emailSignInPath:         '/auth/sign_in',
                storage:                 'cookies',
                proxyIf:                 function() { return false; },
                proxyUrl:                '/proxy',
                authProviderPaths: {
                  github:   '/auth/github',
                  facebook: '/auth/facebook',
                  google:   '/auth/google'
                },
                tokenFormat: {
                  "access-token": "{{ token }}",
                  "token-type":   "Bearer",
                  "client":       "{{ clientId }}",
                  "expiry":       "{{ expiry }}",
                  "uid":          "{{ uid }}"
                },
                parseExpiry: function(headers) {
                  // convert from UTC ruby (seconds) to UTC js (milliseconds)
                  return (parseInt(headers['expiry']) * 1000) || null;
                },
                handleLoginResponse: function(response) {
                  return response.data;
                },
                handleAccountResponse: function(response) {
                  return response.data;
                },
                handleTokenValidationResponse: function(response) {
                  return response.data;
                }
              });
            });

KursachApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/profile', {
              templateUrl: 'partials/profile.html',
              controller: 'UserProfileCtrl'
            }).
      when('/auth', {
                    templateUrl: 'partials/auth.html',
                    controller: 'UserListCtrl'
                  }).
      when('/login', {
                          templateUrl: 'partials/login.html',
                          controller: 'LoginCtrl'
      }).
      otherwise({
        redirectTo: '/login'
      });
  }]);
