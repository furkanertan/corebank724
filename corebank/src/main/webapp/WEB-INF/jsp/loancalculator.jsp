<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="../css/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" href="../css/fontawesome/css/all.css"/>
    <link rel="stylesheet" href="../css/dashboard.css"/>
    <script src="../js/bootstrap.bundle.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <title>Loan Calculator</title>
</head>
<body>
<!-- Navigation bar import -->
<c:import url="components/common/dashboard/dashboard-header.jsp"/>
<!-- End of Navigation bar import -->

<div class="loan-calculator">
    <div class="top">
        <h2>Loan Calculator</h2>

        <form class="loan-calculator-form">
            <div class="group">
                <div class="title">Amount</div>
                <input type="text" value="30000" class="loan-amount"/>
            </div>

            <div class="group">
                <div class="title">Interest Rate</div>
                <input type="text" value="8.5" class="interest-rate"/>
            </div>

            <div class="group">
                <div class="title">Installments (Month) </div>
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

<script src="../js/loancalculator.js"></script>
</body>
</html>
