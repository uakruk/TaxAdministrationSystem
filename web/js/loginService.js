/**
 * Created by Ivan on 4/20/2015.
 */

'use strict';

(function() {

    taxApp.factory("loginService", function($http, $location, sessionService) {

        return {

            login:function(user) {

                var $promise = $http.post('data/data.php', user);

                $promise.then(function(msg) {

                    var uid = msg.data;

                    if ( uid ) {

                        sessionService.setMethod('user', uid);

                        $location.path('/profile');

                        console.log("Successful log");

                    }
                    else {

                        $location.path('/log');

                        console.log("Error logging");

                    }

                });

            },

            logout:function() {

                sessionService.destroyMethod('user');
                $location.path('/log');

            },

            isLogged:function() {

                if (sessionService.getMethod('user')) {

                    return true;

                }

            }

        }

    });

})();
