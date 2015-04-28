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
      when('/unit', {
        templateUrl: 'partials/unit.html',
        controller: 'UnitCtrl'
      }).
      when('/unit/:unit_id', {
        templateUrl: 'partials/unit_id.html',
        controller: 'UnitIdCtrl'
      }).
      when('/taxpayer/:id/tax', {
        templateUrl: 'partials/tax.html',
        controller: 'TaxpayerTaxCtrl'
      }).
        when('/taxpayer/:id/tax/:tax_id', {
            templateUrl: 'partials/tax_id.html',
            controller: 'TaxpayerTaxIdCtrl'
        }).
        when('/taxpayer/:id', {
            templateUrl: 'partials/taxpayer.html',
            controller: 'TaxpayerCtrl'
        }).
        when('/taxpayer/:id/taxitionobject', {
            templateUrl: 'partials/taxpayer_objects.html',
            controller: 'TaxpayerObjectsCtrl'
        }).
        when('/taxpayer/:id/taxitionobject/:taxition_id', {
            templateUrl: 'partials/taxpayer_object.html',
            controller: 'TaxpayerObjectCtrl'
        }).
        when('/taxpayer/:id/property', {
            templateUrl: 'partials/taxpayer_properties.html',
            controller: 'TaxpayerPropertiesCtrl'
        }).
        when('/taxpayer/:id/property/:property_id', {
            templateUrl: 'partials/taxpayer_property.html',
            controller: 'TaxpayerPropertyCtrl'
        }).
        when('/taxpayer/:id/tax/:tax_id/payment', {
            templateUrl: 'partials/taxpayer_payments.html',
            controller: 'TaxpayerPaymentsCtrl'
        }).
        when('/taxpayer/:id/tax/:tax_id/payment/:payment_id', {
            templateUrl: 'partials/taxpayer_payment.html',
            controller: 'TaxpayerPaymentCtrl'
        }).
        when('/taxpayer/:id/licence', {
            templateUrl: 'partials/taxpayer_licences.html',
            controller: 'TaxpayerLicencesCtrl'
        }).
        when('/taxpayer/:id/licence/:licence_id', {
            templateUrl: 'partials/taxpayer_licence.html',
            controller: 'TaxpayerLicenceCtrl'
        }).
        when('/taxpayer/:id/taxitionobject/:taxition_id/cacheregister', {
            templateUrl: 'partials/taxpayer_cash.html',
            controller: 'TaxpayerCashCtrl'
        }).
        when('/taxpayer/:id/tax/:tax_id/charge', {
            templateUrl: 'partials/taxpayer_charges.html',
            controller: 'TaxpayerChargesCtrl'
        }).
        when('/taxpayer/:id/tax/:tax_id/charge/:charge_id', {
            templateUrl: 'partials/taxpayer_charge.html',
            controller: 'TaxpayerChargeCtrl'
        }).
        when('/taxpayer/:id/audit', {
            templateUrl: 'partials/taxpayer_audits.html',
            controller: 'TaxpayerAuditsCtrl'
        }).
        when('/taxpayer/:id/audit/:audit_id', {
            templateUrl: 'partials/taxpayer_audit.html',
            controller: 'TaxpayerAuditCtrl'
        }).
        when('/taxpayer/:id/audit/:audit_id', {
            templateUrl: 'partials/taxpayer_audit.html',
            controller: 'TaxpayerAuditCtrl'
        }).when('/taxpayer/:id/audit/:audit_id/decision', {
            templateUrl: 'partials/taxpayer_decision.html',
            controller: 'TaxpayerDecisionCtrl'
        }).
      when('/login', {
                          templateUrl: 'partials/login.html',
                          controller: 'LoginCtrl'
      }).
      otherwise({
        redirectTo: '/login'
      });
  }]);
