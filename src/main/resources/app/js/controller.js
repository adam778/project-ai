app.controller('clientCtrl', ['$scope', 'clientService', clientCtrl]);
app.controller('sellCtrl', ['$scope', 'sellService', sellCtrl]);
app.controller('visualisationCtrl', ['$scope', 'sellService', visualisationCtrl]);

function clientCtrl($scope, clientService) {

    $scope.selected = {};


    function refreshGrid() {
        clientService.GetAll().then(function (data) {
            $scope.myData = data;
            $scope.selected = {};
        });
    }

    refreshGrid();

    $scope.save = function (newSell) {
        clientService.Save(newSell).then(refreshGrid)
    };

    $scope.delete = function (row) {
        if (row && row.id) {
            clientService.Delete(row.id).then(refreshGrid);
        }
    };

    $scope.myOptions = {
        enableSorting: true,
        enableCellEditOnFocus: true,
        minRowsToShow: 5,
        multiSelect: false,
        columnDefs: [
            { name: 'name', displayName:"Name" },
            { name: 'surname', displayName:"Surname" },
            { name: 'companyName', displayName:"Company name" },
            { name: 'adress', displayName:"Address" },
            { name: 'phone', displayName:"Phone" },
            { name: 'email', displayName:"Email" }
            ],
        data: 'myData' };

    $scope.myOptions.onRegisterApi = function(gridApi){
        //set gridApi on scope
        $scope.gridApi = gridApi;
        gridApi.selection.on.rowSelectionChanged($scope,function(row){
            $scope.selected = row.entity;
        });
    };
}

function sellCtrl($scope, sellService) {

    $scope.selected = {};
    $scope.required = true;

    function refreshGrid() {
        sellService.GetAll().then(function (data) {
            $scope.selected = {};
            $scope.myData = data;
        });
    }

    $scope.save = function (newSell) {
        sellService.Save(newSell).then(refreshGrid)
    };

    $scope.delete = function (row) {
        if (row && row.id) {
          sellService.Delete(row.id).then(refreshGrid);
        }
    };

    sellService.GetAll().then(function (data) {
        $scope.myData = data;
    });

    $scope.uploadFile = function(files) {
        var fd = new FormData();
        //Take the first selected file
        fd.append("file", files[0]);

        sellService.SendFile(fd).then(function () {
            sellService.GetAll().then(function (data) {
                $scope.myData = data;
            });
        });
    };

    $scope.myOptions = {
        enableSorting: true,
        enableCellEditOnFocus: true,
        minRowsToShow: 5,
        multiSelect:false,
        columnDefs: [
            { name: 'customerId', displayName:"Customer" },
            { name: 'itemId', displayName:"Item" },
            { name: 'amount', displayName:"Amount" },
        ],
        data: 'myData' };

    $scope.myOptions.onRegisterApi = function(gridApi){
        //set gridApi on scope
        $scope.gridApi = gridApi;
        gridApi.selection.on.rowSelectionChanged($scope,function(row){
            console.log("Row:", row);
            $scope.selected = row.entity;
        });
    };
}


function visualisationCtrl($scope, sellService) {

    $scope.data = [
        {
            key: "Selles" ,
            values: [
                { "label" : "A" , "value" : -29.765957771107 },
                { "label" : "B" , "value" : 0 },
                { "label" : "C" , "value" : 32.807804682612 },
                { "label" : "D" , "value" : 196.45946739256 },
                { "label" : "E" , "value" : 0.19434030906893 },
                { "label" : "F" , "value" : -98.079782601442 },
                { "label" : "G" , "value" : -13.925743130903 },
                { "label" : "H" , "value" : -5.1387322875705 }
            ]
        }
    ];

    function prepareDataForChart(data) {
        var result = {
            key: "Selles",
            values: []
        };
        for (index in data) {
            result.values.push({
                    "label": index,
                    "value": data[index]
                }
            )
        }
        return [result];
    }

    sellService.GetDataForChart().then(function (data) {
        $scope.data = prepareDataForChart(data);
    });

    $scope.options = {
        "chart": {
            "type": "discreteBarChart",
            "height": 450,
            "margin": {
                "top": 20,
                "right": 20,
                "bottom": 40,
                "left": 55
            },
            x: function (d) {
                return d.label;
            },
            y: function (d) {
                return d.value;
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
