app.factory('clientService', function ($http) {
    return {
        GetAll: function () {
            return $http.get('/client/').then(extractSuccessResponse);
        },
        GetOne: function (id) {
            return $http.get('/client/:id', id).then(extractSuccessResponse);
        },
        Save: function (client) {
            if (client) {
                if (client.id) {
                    return $http.put('/client/:id', client.id, client).then(extractSuccessResponse);
                }
                else {
                    return $http.post('/client/', client).then(extractSuccessResponse);
                }
            }
        },
        Delete: function (id) {
            return $http.delete('/client/:id', id).then(extractSuccessResponse);
        }
    };
});


app.factory('sellService', function ($http) {
    return {
        GetAll: function () {
            return $http.get('/sell/').then(extractSuccessResponse);
        },
        GetOne: function (id) {
            return $http.get('/sell/:id', id).then(extractSuccessResponse);
        },
        Save: function (client) {
            if (client) {
                if (client.id) {
                    return $http.put('/sell/:id', client.id, client).then(extractSuccessResponse);
                }
                else {
                    return $http.post('/sell/', client).then(extractSuccessResponse);
                }
            }
        },
        Delete: function (id) {
            return $http.delete('/sell/:id', id).then(extractSuccessResponse);
        },
        SendFile: function (fd) {
            return $http.post('/sell/parse', fd, {
                headers: {'Content-Type': undefined},
                transformRequest: angular.identity
            }).then(extractSuccessResponse)

        },
        GetDataForChart: function () {
            return $http.get('/sell/chartData').then(extractSuccessResponse);
        },
    };
});

function extractSuccessResponse(response) {
    return response.data;
}