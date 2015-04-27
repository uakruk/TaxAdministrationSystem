/**
 * Created by Ivan on 4/20/2015.
 */

'use strict';

(function() {

    var tabControllers = angular.module('tabControllers', [ ]);

    tabControllers.controller("ProfileController", function() {

    });

    tabControllers.controller("LogController", function(loginService) {

        this.login = function(user) {

            loginService.login(user);

        };

    });

    tabControllers.controller("ProfileController",['loginService', function(loginService) {


        this.logout = function() {

            loginService.logout();

        }

    }]);

    tabControllers.controller("RegController", function() {

       this.dataLog = {};

    });


})();