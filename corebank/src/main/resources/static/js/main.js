// Get the canvas element and context
const accountCanvas = document.getElementById("accountPieChart");
const totalSavingBalance = document.getElementById("totalSavingBalance").value;
const totalCheckBalance = document.getElementById("totalCheckBalance").value;
const totalDepositBalance = document.getElementById("totalDepositBalance").value;
const totalPayments = document.getElementById("totalPayments").value;
const totalTransfers = document.getElementById("totalTransfers").value;
const totalExchanges = document.getElementById("totalExchanges").value;
const accountCtx = accountCanvas.getContext("2d");

// Define the chart data
const accountData = {
    labels: ["Check", "Deposit", "Saving"],
    datasets: [
        {
            data: [totalCheckBalance, totalDepositBalance, totalSavingBalance], // Replace with your own data
            backgroundColor: ["#FF6384", "#36A2EB", "#FFCE56"],
            hoverBackgroundColor: ["#FF6384", "#36A2EB", "#FFCE56"],
        },
    ],
};

// Create the chart
const accountPieChart = new Chart(accountCtx, {
    type: "pie",
    data: accountData,
    options: {
        responsive: true,
        maintainAspectRatio: false,
        title: {
            display: true,
            text: "Account Balance Distributions (PLN)",
        },
    },
});

// Data for the assets bar chart
const transactionTypeDistData = {
    labels: ["Payments", "Transfers", "Currency Exchanges"],
    datasets: [
        {
            data: [totalPayments, totalTransfers, totalExchanges],
            backgroundColor: ['#007bff', '#28a745', '#ffc107'],
            hoverBackgroundColor: ['#007bff', '#28a745', '#ffc107'],
        }
    ]
};

// Options for the assets bar chart
const options = {
    responsive: true,
    legend: {
        display: false,
        position: 'bottom'
    },
    scales: {
        yAxes: [{
            ticks: {
                beginAtZero: true
            }
        }]
    }
};

// Create the assets bar chart
const contextAsset = document.getElementById('assetBarChart').getContext('2d');
const myAssetChart = new Chart(contextAsset, {
    type: 'bar',
    data: transactionTypeDistData,
    options: options
});
