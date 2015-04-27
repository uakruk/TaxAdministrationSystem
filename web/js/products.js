/**
 * Created by Ivan on 15.04.2015.
 */
(function() {

    var app = angular.module('store-products', []);

    app.directive('productPanels', function(){
        return {
            restrict: 'E',
            templateUrl: 'product-panels.html',
            controller:function() {
                this.tab = 1;

                this.selectTab = function(setTab) {
                    this.tab = setTab;
                };


                this.isSelected = function(select) {
                    return this.tab === select;
                }
            },
            controllerAs: 'panel'
        } ;
    });

    app.directive('productTitle', function() {
        return {
            restrict: 'E',
            templateUrl: 'product-title.html'
        };
    });

})();