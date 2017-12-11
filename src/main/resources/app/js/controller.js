app.controller('clientCtrl', ['$scope', 'clientService', clientCtrl]);
app.controller('sellCtrl', ['$scope', sellCtrl]);
app.controller('visualisationCtrl', ['$scope', visualisationCtrl]);

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

function sellCtrl($scope) {

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


function visualisationCtrl($scope) {

    $scope.data = sinAndCos();

    /*Random Data Generator */
    function sinAndCos() {
        var sin = [],sin2 = [],
            cos = [];

        //Data is represented as an array of {x,y} pairs.
        for (var i = 0; i < 100; i++) {
            sin.push({x: i, y: Math.sin(i/10)});
            sin2.push({x: i, y: i % 10 == 5 ? null : Math.sin(i/10) *0.25 + 0.5});
            cos.push({x: i, y: .5 * Math.cos(i/10+ 2) + Math.random() / 10});
        }

        //Line chart data should be sent as an array of series objects.
        return [
            {
                values: sin,      //values - represents the array of {x,y} data points
                key: 'Sine Wave', //key  - the name of the series.
                color: '#ff7f0e'  //color - optional: choose your own line color.
            },
            {
                values: cos,
                key: 'Cosine Wave',
                color: '#2ca02c'
            },
            {
                values: sin2,
                key: 'Another sine wave',
                color: '#7777ff',
                area: true      //area - set to true if you want this line to turn into a filled area chart.
            }
        ];
    };



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
            "useInteractiveGuideline": true,
            "dispatch": {},
            "xAxis": {
                "axisLabel": "Time (ms)"
            },
            "yAxis": {
                "axisLabel": "Voltage (v)",
                "axisLabelDistance": -10
            }
        },
        "title": {
            "enable": true,
            "text": "Title for Line Chart"
        },
        "subtitle": {
            "enable": true,
            "text": "Subtitle for simple line chart. Lorem ipsum dolor sit amet, at eam blandit sadipscing, vim adhuc sanctus disputando ex, cu usu affert alienum urbanitas.",
            "css": {
                "text-align": "center",
                "margin": "10px 13px 0px 7px"
            }
        },
        "caption": {
            "enable": true,
            "html": "<b>Figure 1.</b> Lorem ipsum dolor sit amet, at eam blandit sadipscing, <span style=\"text-decoration: underline;\">vim adhuc sanctus disputando ex</span>, cu usu affert alienum urbanitas. <i>Cum in purto erat, mea ne nominavi persecuti reformidans.</i> Docendi blandit abhorreant ea has, minim tantas alterum pro eu. <span style=\"color: darkred;\">Exerci graeci ad vix, elit tacimates ea duo</span>. Id mel eruditi fuisset. Stet vidit patrioque in pro, eum ex veri verterem abhorreant, id unum oportere intellegam nec<sup>[1, <a href=\"https://github.com/krispo/angular-nvd3\" target=\"_blank\">2</a>, 3]</sup>.",
            "css": {
                "text-align": "justify",
                "margin": "10px 13px 0px 7px"
            }
        }
    };

    console.log("here");
}
