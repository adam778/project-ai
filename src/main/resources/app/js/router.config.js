app.config(function($stateProvider, $urlRouterProvider) {
    $stateProvider
        .state("main", {
            url:'/',
            templateUrl : "template/main.html"
        })
        .state("client", {
            url:'/client',
            templateUrl : "template/client.html",
            controller: 'clientCtrl'
        })
        .state("sell", {
            url:'/sell',
            templateUrl : "template/sell.html",
            controller: 'sellCtrl'
        })
        .state("visualisation", {
            url:'/visualisation',
            templateUrl : "template/visualisation.html"
        });
    $urlRouterProvider.otherwise("/");
});
