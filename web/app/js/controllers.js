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

KursachControllers.controller('UnitCtrl',['$scope','$http',
    function ($scope, $http) {
        $http.post('/unit').success(function(data) {
            $scope.units = data;
        });
        $scope.orderProp = 'age';
    }]);
KursachControllers.controller('UnitIdCtrl',['$scope','$http',
    function ($scope, $http) {
        var unit_id = $routeParams.unit_id;
        $http.post('/unit/:unit_id').success(function(data) {
            $scope.unit = data;
        });
        $scope.orderProp = 'age';
    }]);
KursachControllers.controller('TaxpayerTaxCtrl',['$scope','$http',
    function ($scope, $http) {
        var id = $routeParams.id;
        $http.post('/taxpayer/:id/tax').success(function(data) {
            $scope.taxes = data;
        });
        $scope.orderProp = 'age';
    }]);
KursachControllers.controller('TaxpayerTaxIdCtrl',['$scope','$http',
    function ($scope, $http) {
        var id = $routeParams.id;
        var tax_id = $routeParams.tax_id
        $http.post('/taxpayer/:id/tax/tax_id').success(function(data) {
            $scope.tax = data;
        });
    }]);
KursachControllers.controller('TaxpayerCtrl',['$scope','$http',
    function ($scope, $http) {
        var id = $routeParams.id;
        $http.post('/taxpayer/:id').success(function(data) {
            $scope.taxpayer = data;
        });
    }]);
KursachControllers.controller('TaxpayerObjectsCtrl',['$scope','$http',
    function ($scope, $http) {
        var id = $routeParams.id;
        $http.post('/taxpayer/:id/taxitionobject').success(function(data) {
            $scope.object = data;
        });
        $scope.orderProp = 'age';
    }]);
KursachControllers.controller('TaxpayerObjectCtrl',['$scope','$http',
    function ($scope, $http) {
        var id = $routeParams.id;
        var taxition_id = $routeParams.taxition_id;
        $http.post('/taxpayer/:id/taxitionobject/:taxition_id').success(function(data) {
            $scope.object = data;
        });
    }]);
KursachControllers.controller('TaxpayerPropertiesCtrl',['$scope','$http',
    function ($scope, $http) {
        var id = $routeParams.id;
        $http.post('/taxpayer/:id/property').success(function(data) {
            $scope.properties = data;
        });
        $scope.orderProp = 'age';
    }]);
KursachControllers.controller('TaxpayerPropertyCtrl',['$scope','$http',
    function ($scope, $http) {
        var id = $routeParams.id;
        var property_id = $routeParams.property_id;
        $http.post('/taxpayer/:id/property/:property_id').success(function(data) {
            $scope.property = data;
        });
    }]);
KursachControllers.controller('TaxpayerPaymentsCtrl',['$scope','$http',
    function ($scope, $http) {
        var id = $routeParams.id;
        var tax_id = $routeParams.tax_id;
        $http.post('/taxpayer/:id/tax/:tax_id/payment').success(function(data) {
            $scope.payments = data;
        });
        $scope.orderProp = 'age';
    }]);
KursachControllers.controller('TaxpayerPaymentCtrl',['$scope','$http',
    function ($scope, $http) {
        var id = $routeParams.id;
        var tax_id = $routeParams.tax_id;
        var payment_id = $routeParams.payment_id;
        $http.post('/taxpayer/:id/tax/:tax_id/payment/:payment_id').success(function(data) {
            $scope.payment = data;
        });
    }]);
KursachControllers.controller('TaxpayerLicencesCtrl',['$scope','$http',
    function ($scope, $http) {
        var id = $routeParams.id;
        $http.post('/taxpayer/:id/licence').success(function(data) {
            $scope.licences = data;
        });
    }]);
KursachControllers.controller('TaxpayerLicenceCtrl',['$scope','$http',
    function ($scope, $http) {
        var id = $routeParams.id;
        var licence_id = $routeParams.licence_id;
        $http.post('/taxpayer/:id/licence/:licence_id').success(function(data) {
            $scope.licence = data;
        });
    }]);
KursachControllers.controller('TaxpayerCashCtrl',['$scope','$http',
    function ($scope, $http) {
        var id = $routeParams.id;
        var taxition_id = $routeParams.taxition_id;
        $http.post('/taxpayer/:id/taxitionobject/:taxition_id/casheregisters').success(function(data) {
            $scope.cashes = data;
        });
    }]);
KursachControllers.controller('TaxpayerChargesCtrl',['$scope','$http',
    function ($scope, $http) {
        var id = $routeParams.id;
        var tax_id = $routeParams.tax_id;
        $http.post('/taxpayer/:id/tax/:tax_id/charge').success(function(data) {
            $scope.charges = data;
        });
    }]);
KursachControllers.controller('TaxpayerChargeCtrl',['$scope','$http',
    function ($scope, $http) {
        var id = $routeParams.id;
        var tax_id = $routeParams.tax_id;
        var charge_id = $routeParams.charge_id;
        $http.post('/taxpayer/:id/tax/:tax_id/charge/:charge_id').success(function(data) {
            $scope.charge = data;
        });
    }]);
KursachControllers.controller('TaxpayerAuditsCtrl',['$scope','$http',
    function ($scope, $http) {
        var id = $routeParams.id;
        $http.post('/taxpayer/:id/audit').success(function(data) {
            $scope.audits = data;
        });
    }]);
KursachControllers.controller('TaxpayerAuditCtrl',['$scope','$http',
    function ($scope, $http) {
        var id = $routeParams.id;
        var audit_id = $routeParams.audit_id;
        $http.post('/taxpayer/:id/audit/:audit_id').success(function(data) {
            $scope.audit = data;
        });
    }]);
KursachControllers.controller('TaxpayerDecisionCtrl',['$scope','$http',
    function ($scope, $http) {
        var id = $routeParams.id;
        var audit_id = $routeParams.audit_id;
        $http.post('/taxpayer/:id/audit/:audit_id/decision').success(function(data) {
            $scope.decision = data;
        });
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