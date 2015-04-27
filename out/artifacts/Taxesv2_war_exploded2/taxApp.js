/**
 * Created by Ivan on 15.04.2015.
 */

    'use strict';

    var taxApp = angular.module('system', [
    'ngRoute',
    'tabControllers'
    ]);

    taxApp.config(['$routeProvider', function($routeProvider) {
        $routeProvider.

        when ('/log', {

            templateUrl: 'partials/log.html',
            controller: 'LogController'

        }).

        when ('/reg', {

            templateUrl: 'partials/reg.html',
            controller: 'RegController'

        }).

        when ('/profile', {

            templateUrl: 'partials/profile.html',
            controller: 'ProfileController'

        }).

        otherwise({

            redirectTo: '/log'

        });

    }]);

    // much more like a main method

    taxApp.run(function($rootScope, $location, loginService) {

        var routesPermission = ['/profile']; //hiding route

        $rootScope.$on('$routeChangeStart', function() {

            if ( routesPermission.indexOf($location.path()) != -1 && !loginService.isLogged() ) {

                     $location.path('/log');

            }

        });

    });