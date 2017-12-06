app.controller('clientCtrl', ['$scope', 'clientService', clientCtrl]);
app.controller('sellsCtrl', ['$scope', sellsCtrl]);

function clientCtrl($scope, clientService) {

    clientService.GetAll().then(function (data) {
        console.log(data);
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

function sellsCtrl($scope) {

    $scope.myData = [{name: "Moroni", age: 50},
        {name: "Teancum", age: 43},
        {name: "Jacob", age: 27},
        {name: "Nephi", age: 29},
        {name: "Enos", age: 34}];
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


