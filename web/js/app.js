/**
 * Created by Ivan on 12.04.2015.
 */
(function() {
    var app = angular.module('store', ['store-products']);


    app.controller("ReviewController" , function(){
       this.review = {};

        this.addReview = function(product) {
            product.reviews.push(this.review);
            this.review = {};
        };

    });

    app.controller("StoreController", ['$http', function($http) {

        var store = this;

        store.products = [];

        $http.get('/product.json').success(function(data) {
            store.products = data;
        });

        //this.products = myProudct;
    }]);

    //
    //var myProudct = [{
    //        name : "Keybord",
    //        price : 50,
    //        Description : "It is a very nice product",
    //        reviews : [
    //            {
    //                'stars' : 5,
    //                'body' : 'love it',
    //                'author' : 'dog'
    //            },
    //            {
    //                'stars' : 4,
    //                'body' : 'fuck iy',
    //                'author' : 'kitty'
    //            },
    //            {
    //                'stars' : 2,
    //                'body' : 'Not bad at all',
    //                'author' : 'daddy'
    //            }
    //        ]
    //},
    //    {
    //        name : "Speakers",
    //        price : 20,
    //        Description : "It is a very nice product",
    //        reviews : [
    //            {
    //                'stars' : 1,
    //                'body' : 'love it',
    //                'author' : 'dog'
    //            },
    //            {
    //                'stars' : 1,
    //                'body' : 'fuck iy',
    //                'author' : 'kitty'
    //            },
    //            {
    //                'stars' : 1,
    //                'body' : 'Not bad at all',
    //                'author' : 'daddy'
    //            }
    //        ]
    //    }
    //];
})();