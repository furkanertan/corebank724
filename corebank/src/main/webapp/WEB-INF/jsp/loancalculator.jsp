<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="css/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" href="css/fontawesome/css/all.css"/>
    <link rel="stylesheet" href="css/dashboard.css"/>
    <title>Loan Calculator</title>
</head>
<body>
<header class="dashboard-page-header mb-3 bg-primary">
    <div class="container d-flex align-items-center">
        <div class="company-name"><a class="company-logo-name" href="/dashboard">CoreBank 7/24</a></div>
        <nav class="navigation">
            <li><a href="">Accounts</a></li>
            <li><a href="">Money Transfers</a></li>
            <li><a href="/currencyexchange">Currency Exchange</a></li>
            <li><a href="">Transactions</a></li>
            <li><a href="/loancalculator">Loan Calculator</a></li>
        </nav>

        <div class="display-name ms-auto">
            <i class="fa fa-circle text-success me-2"> </i> Welcome,
            <span>John Doe</span>
        </div>

        <a href="" class="btn btn-sm btn-outline-light ms-3">
            <i class="fa fa-sign-out-alt"></i> Logout
        </a>
    </div>
</header>

<div class="loan-calculator">
    <div class="top">
        <h2>Loan Calculator</h2>

        <form action="#">
            <div class="group">
                <div class="title">Amount</div>
                <input type="text" value="30000" class="loan-amount"/>
            </div>

            <div class="group">
                <div class="title">Interest Rate</div>
                <input type="text" value="8.5" class="interest-rate"/>
            </div>

            <div class="group">
                <div class="title">Tenure (in months)</div>
                <input type="text" value="240" class="loan-tenure"/>
            </div>
        </form>
    </div>

    <div class="result">
        <div class="left">
            <div class="loan-emi">
                <h3>Loan EMI</h3>
                <div class="value">123</div>
            </div>

            <div class="total-interest">
                <h3>Total Interest Payable</h3>
                <div class="value">1234</div>
            </div>

            <div class="total-amount">
                <h3>Total Amount</h3>
                <div class="value">12345</div>
            </div>

            <button class="calculate-btn">Calculate</button>
        </div>

        <div class="right">
            <canvas id="myChart" width="400" height="400"></canvas>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/chart.js@3.6.2/dist/chart.min.js"></script>

<script src="js/loancalculator.js"></script>
</body>
</html>
