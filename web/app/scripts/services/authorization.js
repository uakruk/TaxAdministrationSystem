'use strict';

angular.module('TaxPayerApp')
  .factory('Authorization', function Authorization ($http) {
  var url = 'https://127.0.0.1:9000';

  return {
      login: function (credentials) {
          console.log(credentials);
          return $http.post(url + '/signin', credentials);
      }
  };
});
