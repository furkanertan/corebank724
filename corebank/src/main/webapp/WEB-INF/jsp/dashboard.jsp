<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <title>Dashboard</title>
</head>

<body>

<!-- Navigation bar import -->
<c:import url="components/common/dashboard/dashboard-header.jsp"/>
<!-- End of Navigation bar import -->

<!-- Add Charts -->
<div class="charts-container">
    <div class="row my-2">
        <div class="col-lg-3 col-md-4 col-sm-12">
            <div class="card bg-danger text-white mb-3">
                <div class="card-body">
                    <h5 class="card-title">Account Number</h5>
                    <p class="card-text h3">
                        <c:choose>
                            <c:when test="${accountsCount == 0}">
                                0
                            </c:when>
                            <c:otherwise>
                                ${accountsCount}
                            </c:otherwise>
                        </c:choose>
                    </p>
                    <i class="fas fa-2x fa-coins"></i>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-md-4 col-sm-12">
            <div class="card bg-primary text-white mb-3">
                <div class="card-body">
                    <h5 class="card-title">Total Deposit</h5>
                    <p class="card-text h3">0</p>
                    <i class="fas fa-2x fa-sack-dollar"></i>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-md-4 col-sm-12">
            <div class="card bg-success text-white mb-3">
                <div class="card-body">
                    <h5 class="card-title">Total Withdraw</h5>
                    <p class="card-text h3">0</p>
                    <i class="fas  fa-2x fa-money-bill-transfer"></i></div>
            </div>
        </div>
        <div class="col-lg-3 col-md-4 col-sm-12">
            <div class="card bg-dark text-white mb-3">
                <div class="card-body">
                    <h5 class="card-title">Total Withdraw</h5>
                    <p class="card-text h3">0</p>
                    <i class="fas  fa-2x fa-money-bill-transfer"></i></div>
            </div>
        </div>
    </div>
    <div class="row my-2">
        <div class="col-lg-6 col-md-12 col-sm-12 mt-3" id="last-5-transaction">
            <div class="card shadow-lg">
                <div class="card-title">
                    <h5 class="text-center" style="margin-top: 10px;">Last 5 Transactions</h5>
                </div>
                <div class="card-body">
                    <c:if test="${not empty transactions}">
                        <table>
                        <thead>
                        <tr>
                            <th>Account Number</th>
                            <th>Transaction Type</th>
                            <th>Message</th>
                            <th>Amount</th>
                            <th>Reason Code</th>
                            <th>Transaction Time</th>
                            <th></th>
                        </tr>
                        </thead>
                        <c:forEach items="${transactions}" var="transaction">
                            <tbody>
                            <tr>
                                <td>${transaction.accountNumber}</td>
                                <td>${transaction.transactionType}</td>
                                <td>${transaction.message}</td>
                                <td>${transaction.amount}</td>
                                <td>${transaction.reasonCode}</td>
                                <td>${transaction.transactionTime}</td>
                            </tr>
                            </tbody>
                            </table>
                        </c:forEach>
                    </c:if>
                </div>
            </div>
        </div>
        <div class="col-lg-6 col-md-12 col-sm-12 mt-3" id="char-line-div">
            <div class="card shadow-lg">
                <div class="card-title">
                    <h5 class="text-center" style="margin-top: 10px;color: #14213d">Currency Exchange Rates</h5>
                </div>
                <div class="card-body">
                    <div class="row">
                        <c:if test="${not empty currencyRates}">
                            <c:forEach items="${currencyRates}" var="currency">
                                <c:if test="${currency.fromCurrency == 'USD'}">
                                    <div class="col-6">
                                        <div class="card" style="border: none">
                                            <!-- Dollar currency -->
                                            <div class="card-body d-flex align-items-center" style="background-color: #ffe690">
                                                <i class="fas fa-2x fa-dollar-sign mr-2"></i>
                                                <p class="card-text h5 mb-0"
                                                   style="margin-left: 20px;color: #14213d">1 USD
                                                    = ${currency.rate} PLN</p>
                                            </div>
                                        </div>
                                    </div>
                                </c:if>
                                <c:if test="${currency.fromCurrency == 'EUR'}">
                                    <div class="col-6">
                                        <!-- Euro currency -->
                                        <div class="card" style="border: none">
                                            <div class="card-body d-flex align-items-center" style="background-color: #f8d7da">
                                                <i class="fas fa-2x fa-euro-sign mr-2"></i>
                                                <p class="card-text h5 mb-0"
                                                   style="margin-left: 20px;color: #14213d">1 EUR
                                                    = ${currency.rate} PLN</p>
                                            </div>
                                        </div>
                                    </div>
                                </c:if>
                                <c:if test="${currency.fromCurrency == 'GBP'}">
                                    <div class="col-6">
                                        <!-- Pound currency -->
                                        <div class="card" style="border: none">
                                            <div class="card-body d-flex align-items-center" style="background-color: #5a91bf">
                                                <i class="fas fa-2x fa-gbp mr-2"></i>
                                                <p class="card-text h5 mb-0" style="margin-left: 20px;color: #14213d">1 GBP
                                                    = ${currency.rate} PLN</p>
                                            </div>
                                        </div>
                                    </div>
                                </c:if>
                                <c:if test="${currency.fromCurrency == 'TRY'}">
                                    <div class="col-6">
                                        <!-- Try currency -->
                                        <div class="card" style="border: none">
                                            <div class="card-body d-flex align-items-center" style="background-color: lightcoral;">
                                                <i class="fas fa-2x fa-try mr-2"></i>
                                                <p class="card-text h5 mb-0" style="margin-left: 20px;color: #14213d">1 TRY
                                                    = ${currency.rate} PLN</p>
                                            </div>
                                        </div>
                                    </div>
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</div>
<div class="row my-2">
    <div class="col-12 mt-3" id="bar-chart-div">
        <div class="card shadow-lg">
            <div class="card-title">
                <h5 class="text-center" style="margin-top: 10px;">Assets (Year)</h5>
            </div>
            <div class="card-body">
                <canvas id="bar-chart"></canvas>
            </div>
        </div>
    </div>
</div>
</div>
<!-- End of Charts -->

<!-- Footer import -->
<c:import url="components/common/dashboard/dashboard-footer.jsp"/>
<!-- End of Footer import -->
