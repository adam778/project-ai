app.config(function($stateProvider) {
    $stateProvider
        .state("main", {
            url:'/',
            templateUrl : "main.html"
        })
        .state("client", {
            url:'   /client',
            templateUrl : "../html/client.html"
        })
});