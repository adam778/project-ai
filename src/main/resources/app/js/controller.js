app.controller('clientCtrl', ['$scope', 'clientService', clientCtrl]);
app.controller('sellCtrl', ['$scope', 'sellService', sellCtrl]);
app.controller('visualisationCtrl', ['$scope', 'sellService', visualisationCtrl]);

function clientCtrl($scope, clientService) {

    clientService.GetAll().then(function (data) {
        $scope.myData = data;
    });

    $scope.myOptions = {
        enableSorting: true,
        enableCellEditOnFocus: true,
        minRowsToShow: 5,
        columnDefs: [
            { name: 'name', displayName:"Name" },
            { name: 'surname', displayName:"Surname" },
            { name: 'companyName', displayName:"Company name" },
            { name: 'adress', displayName:"Address" },
            { name: 'phone', displayName:"Phone" },
            { name: 'email', displayName:"Email" }
            ],
        data: 'myData' };
}

function sellCtrl($scope, sellService) {

    sellService.GetAll().then(function (data) {
        $scope.myData = data;
    });

    $scope.uploadFile = function(files) {
        var fd = new FormData();
        //Take the first selected file
        fd.append("file", files[0]);

        sellService.SendFile(fd);
    };

    $scope.myOptions = {
        enableSorting: true,
        enableCellEditOnFocus: true,
        minRowsToShow: 5,
        columnDefs: [
            { name: 'customerId', displayName:"Customer" },
            { name: 'itemId', displayName:"Item" },
            { name: 'amount', displayName:"Amount" },
        ],
        data: 'myData' };
}


function visualisationCtrl($scope, sellService) {

    $scope.data = [];

    sellService.GetAll().then(function (data) {
        $scope.data = data;
        console.log($scope.data);
    });

    $scope.options = {
        "chart": {
            "type": "lineChart",
            "height": 450,
            "margin": {
                "top": 20,
                "right": 20,
                "bottom": 40,
                "left": 55
            },
            x: function (d) {
                return d.customerId;
            },
            y: function (d) {
                return d.amount;
            },
            "dispatch": {},
            "xAxis": {
                "axisLabel": "Clients"
            },
            "yAxis": {
                "axisLabel": "Selles amount of Product",
                "axisLabelDistance": -10
            }
        },
        "title": {
            "enable": true,
            "text": "Sales visualisation"
        }
    };

}
