/**
 * Created by Ivan on 4/20/2015.
 */

'use strict';

(function() {

    taxApp.factory("sessionService", ['$http', function($http) {

      return {

          setMethod:function(key, value) {

                return sessionStorage.setItem(key, value);

          },

          getMethod:function(key) {

                return sessionStorage.getItem(key);

          },

          destroyMethod:function(key) {

                return sessionStorage.removeItem(key);

          }

      };

    }]);

})();
