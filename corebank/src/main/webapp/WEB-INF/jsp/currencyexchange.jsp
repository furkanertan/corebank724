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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.9.3/umd/popper.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.2/js/bootstrap.min.js"></script>
    <title>Currency Exchange</title>
</head>
<body>
<!-- Navigation bar import -->
<c:import url="components/common/dashboard/dashboard-header.jsp"/>
<!-- End of Navigation bar import -->

<div class="container">
    <!-- Display success message-->
    <c:if test="${requestScope.successMoneyTransfer != null}">
        <div class="alert alert-success text-center border border-success">
            <p class="text-center">
                <i class="fas fa-check-circle"></i>
                <b>${requestScope.successCurrencyExchange}</b>
            </p>
        </div>
    </c:if>
    <!-- End of display success message -->

    <!-- Display error message-->
    <c:if test="${requestScope.errorCurrencyExchange != null}">
        <div class="alert alert-danger text-center border border-danger">
            <p class="text-center">
                <i class="fas fa-exclamation-triangle"></i>
                <b>${requestScope.errorMoneyTransfer}</b>
            </p>
        </div>
    </c:if>
    <!-- End of display error message -->
</div>

<!-- Currency Exchange Form -->
<div class="container">
    <div class="row justify-content-center" style="margin: 45px">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header text-center" style="color: white;background-color: #14213d;">
                    <h4 style="margin-top: 10px">Currency Exchange</h4>
                </div>
                <div class="card-body" style="color: #14213d;font-weight:500">
                    <form action="/currency/exchange" method="POST" class="currency-exchange-form">
                        <div class="form-group" style="margin: 10px">
                            <div class="drop-list">
                                <div class="row">
                                    <p>From:</p>
                                    <div class="select-box">
                                        <img src="https://flagcdn.com/48x36/us.png" alt="flag">
                                        <select onchange="onFromChange()">
                                        </select>
                                    </div>
                                </div>
                                <div class="to">
                                    <p>To:</p>
                                    <div class="select-box">
                                        <img src="https://flagcdn.com/48x36/fr.png" alt="flag">
                                        <select onchange="onToChange()"></select>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin: 10px">
                            <label for="fromAccount">From Account</label>
                            <select class="form-control" id="fromAccount" name="fromAccount">
                                <option value="">-- Select From Account --</option>
                                <c:forEach items="${userAccounts}" var="account">
                                    <option value="${account.accountNumber}">${account.accountNumber}
                                        - ${account.currencyType}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group" style="margin: 10px">
                            <label for="toAccount">To Account</label>
                            <select class="form-control" id="toAccount" name="toAccount">
                                <option value="">-- Select To Account --</option>
                                <c:forEach items="${userAccounts}" var="account">
                                    <option value="${account.accountNumber}">${account.accountNumber}
                                        - ${account.currencyType}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group" style="margin: 10px">
                            <label for="amount">Amount</label>
                            <input
                                    type="number"
                                    class="form-control"
                                    id="amount"
                                    name="amount"
                                    placeholder="Enter exchange amount"
                                    onchange="onAmountChange()"
                                    value=
                                    <c:if test="${requestScope.amount == null}">
                                            0
                            </c:if>
                            />
                        </div>
                        <div class="form-group" style="margin: 10px">
                            <label for="exchangeRate">Exchange Rate</label>
                            <input
                                    type="number"
                                    class="form-control"
                                    id="exchangeRate"
                                    name="exchangeRate"
                                    placeholder="Enter exchange rate"
                                    onchange="onExchangeRateChange()"
                                    readonly
                                    value=
                                    <c:if test="${requestScope.exchangeRate == null}">
                                            0
                            </c:if>
                            />
                        </div>
                        <div class="form-group" style="margin: 10px">
                            <label for="exchangeAmount">Exchange Amount</label>
                            <input
                                    type="number"
                                    class="form-control"
                                    id="exchangeAmount"
                                    name="exchangeAmount"
                                    placeholder="Enter exchange amount"
                                    readonly
                                    value=
                                    <c:if test="${requestScope.exchangeAmount == null}">
                                            0
                            </c:if>
                            />
                            <button type="submit" class="btn btn-primary btn-block"
                                    style="color:white;background: #e63946;margin: 1px;border: none;padding: 8px 32px;">
                                Exchange
                            </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- End of Currency Exchange Form -->
<script src="../js/country-list.js"></script>
<script src="../js/currencyexchange.js"></script>
</body>
</html>
