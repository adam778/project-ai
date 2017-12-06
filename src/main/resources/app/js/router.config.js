app.config(function($stateProvider, $urlRouterProvider) {
    $stateProvider
        .state("main", {
            url:'/',
            templateUrl : "template/main.html",
            controller: 'simpleController'
        })
        .state("client", {
            url:'/client',
            templateUrl : "template/client.html",
            controller: 'clientCtrl'
        });
   // $urlRouterProvider.otherwise("/");
});
