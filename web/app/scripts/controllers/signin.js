'use strict';

angular.module('TaxPayerApp').controller('SigninCtrl', function ($scope, $location, $cookieStore, Authorization, api) {
  $scope.title = '';

  $scope.login = function () {
      var credentials = {
          email: this.email,
          password: this.password
      };

      var success = function (data) {
          var token = data.token;

          api.init(token);
          $cookieStore.put('token', token);
          $location.path('/');
      };

      var error = function () {
          console.log('error');
      };
      console.log(credentials);
      console.log('-----------------------');
      console.log(Authorization.login(credentials));
      console.log('-----------------------');

      console.log(Authorization.login(credentials).success(success));
      Authorization.login(credentials).success(success).error(error);
  };
});
