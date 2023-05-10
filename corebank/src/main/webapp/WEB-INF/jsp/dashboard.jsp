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
            <div class="card text-white mb-3" style="background: linear-gradient(to right,  #FF0000, #FFC0CB);">
                <div class="card-body">
                    <h5 class="card-title">Total Accounts</h5>
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
                    <i class="fas fa-2x fa-pager"></i>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-md-4 col-sm-12">
            <div class="card text-white mb-3" style="background: linear-gradient(to right,  #1584e0, #16e0d9);">
                <div class="card-body">
                    <h5 class="card-title">Total Deposits (PLN)</h5>
                    <p class="card-text h3"><c:choose>
                        <c:when test="${totalDeposits == 0}">
                            0
                        </c:when>
                        <c:otherwise>
                            ${totalDeposits}
                        </c:otherwise>
                    </c:choose></p>
                    <i class="fas fa-2x fa-coins"></i>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-md-4 col-sm-12">
            <div class="card text-white mb-3" style="background: linear-gradient(to right,  #1db446, #1bd947);">
                <div class="card-body">
                    <h5 class="card-title">Total Savings (PLN)</h5>
                    <p class="card-text h3"><c:choose>
                        <c:when test="${totalSavings == 0}">
                            0
                        </c:when>
                        <c:otherwise>
                            ${totalSavings}
                        </c:otherwise>
                    </c:choose></p>
                    <i class="fas  fa-2x fa-sack-dollar"></i></div>
            </div>
        </div>
        <div class="col-lg-3 col-md-4 col-sm-12">
            <div class="card text-white mb-3" style="background: linear-gradient(to right,  #6e6e6e, #b0afaf);">
                <div class="card-body">
                    <h5 class="card-title">Total Checks (PLN)</h5>
                    <p class="card-text h3"><c:choose>
                        <c:when test="${totalChecks == 0}">
                            0
                        </c:when>
                        <c:otherwise>
                            ${totalChecks}
                        </c:otherwise>
                    </c:choose></p>
                    <i class="fas  fa-2x fa-check-to-slot"></i></div>
            </div>
        </div>
        <!-- Chart Values -->
        <input hidden value="${totalCheckBalance}" id="totalCheckBalance" name="totalCheckBalance"/>
        <input hidden value="${totalSavingBalance}" id="totalSavingBalance" name="totalSavingBalance"/>
        <input hidden value="${totalDepositBalance}" id="totalDepositBalance" name="totalDepositBalance"/>
        <input hidden value="${totalPayments}" id="totalPayments" name="totalPayments"/>
        <input hidden value="${totalTransfers}" id="totalTransfers" name="totalTransfers"/>
        <input hidden value="${totalExchanges}" id="totalExchanges" name="totalExchanges"/>
        <!-- End of Chart Values -->
    </div>
    <div class="row my-2">
        <div class="grid-container">
            <div class="big-card" id="last-5-transaction">
                <div class="card shadow-lg" style="height: 87.1%">
                    <div class="card-title">
                        <h5 class="text-center" style="margin-top: 10px;">Last 5 Transactions</h5>
                    </div>
                    <div class="card-body">
                        <c:if test="${not empty transactions}">
                            <div class="table-responsive">
                                <table class="table table-bordered table-hover">
                                    <thead class="thead-dark">
                                    <tr>
                                        <th>Account Number</th>
                                        <th>Transaction Type</th>
                                        <th>Message</th>
                                        <th>Amount</th>
                                        <th>Reason Code</th>
                                        <th>Transaction Time</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${transactions}" var="transaction">
                                        <tr>
                                            <td>${transaction.accountNumber}</td>
                                            <td>${transaction.transactionType}</td>
                                            <td>${transaction.message}</td>
                                            <td>${transaction.amount}</td>
                                            <td>${transaction.reasonCode}</td>
                                            <td>${transaction.transactionTime}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </c:if>
                        <c:if test="${empty transactions}">
                            <div class="table-responsive">
                                <table class="table table-bordered table-hover">
                                    <thead class="thead-dark">
                                    <tr>
                                        <th>Account Number</th>
                                        <th>Transaction Type</th>
                                        <th>Message</th>
                                        <th>Amount</th>
                                        <th>Reason Code</th>
                                        <th>Transaction Time</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="i" begin="0" end="${5}">
                                        <tr>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
            <div class="small-card-1" id="small-card-1">
                <div class="card shadow-lg">
                    <div class="card-title">
                        <h5 class="text-center" style="margin-top: 10px;color: #14213d">Account Balance Distribution (PLN)</h5>
                    </div>
                    <div class="card-body">
                        <div class="row">
                                <canvas id="accountPieChart" height="220%"></canvas>
                        </div></div>
                </div>
            </div>
            <div class="small-card-2" id="small-card-2">
                <div class="card shadow-lg" style="margin-top: 1px;">
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
                                                <div class="card-body d-flex align-items-center"
                                                     style="background: linear-gradient(to right,  #f8ff00, #f1e4af);">
                                                    <i class="fas fa-2x fa-dollar-sign mr-2"></i>
                                                    <p class="card-text h6 mb-0"
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
                                                <div class="card-body d-flex align-items-center"
                                                     style="background: linear-gradient(to right,  #d727ba, #f088f6);">
                                                    <i class="fas fa-2x fa-euro-sign mr-2"></i>
                                                    <p class="card-text h6 mb-0"
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
                                                <div class="card-body d-flex align-items-center"
                                                     style="background: linear-gradient(to right,  #9423f1, #d8a0f5);">
                                                    <i class="fas fa-2x fa-gbp mr-2"></i>
                                                    <p class="card-text h6 mb-0"
                                                       style="margin-left: 20px;color: #14213d">1
                                                        GBP
                                                        = ${currency.rate} PLN</p>
                                                </div>
                                            </div>
                                        </div>
                                    </c:if>
                                    <c:if test="${currency.fromCurrency == 'TRY'}">
                                        <div class="col-6">
                                            <!-- Try currency -->
                                            <div class="card" style="border: none">
                                                <div class="card-body d-flex align-items-center"
                                                     style="background: linear-gradient(to right,  #f17d23, #f3b288);">
                                                    <i class="fas fa-2x fa-try mr-2"></i>
                                                    <p class="card-text h6 mb-0"
                                                       style="margin-left: 20px;color: #14213d">1
                                                        TRY
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
    <div class="row my-2">
        <div class="col-12" id="bar-chart-div">
            <div class="card shadow-lg">
                <div class="card-title">
                    <h5 class="text-center" style="margin-top: 10px;">Transaction Type Distribution</h5>
                </div>
                <div class="card-body">
                    <canvas id="assetBarChart" style="margin-left: 50px;margin-right: 50px"></canvas>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- End of Charts -->

<!-- Footer import -->
<c:import url="components/common/dashboard/dashboard-footer.jsp"/>
<!-- End of Footer import -->
