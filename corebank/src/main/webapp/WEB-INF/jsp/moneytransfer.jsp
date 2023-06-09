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
    <title>Money Transfer</title>
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
                <b>${requestScope.successMoneyTransfer}</b>
            </p>
        </div>
    </c:if>
    <!-- End of display success message -->

    <!-- Display error message-->
    <c:if test="${requestScope.errorMoneyTransfer != null}">
        <div class="alert alert-danger text-center border border-danger">
            <p class="text-center">
                <i class="fas fa-exclamation-triangle"></i>
                <b>${requestScope.errorMoneyTransfer}</b>
            </p>
        </div>
    </c:if>
    <!-- End of display error message -->
</div>

<!-- Money Transfer Form -->
<div class="container">
    <div class="row justify-content-center" style="margin: 45px">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header text-center" style="color: white;background-color: #14213d;">
                    <h4 style="margin-top: 10px">Money Transfer</h4>
                </div>
                <div class="card-body" style="color: #14213d;font-weight:500">
                    <form action="/moneytransfer/transfer" method="POST" class="money-transfer-form">
                        <div class="form-group" style="margin: 10px">
                            <label for="fromAccount">Sender's Account</label>
                            <select class="form-control" id="fromAccount" required name="fromAccount" onchange="onAccountChange(fromAccount)">
                                <option value="">-- Select Account --</option>
                                <c:forEach items="${userAccounts}" var="account">
                                    <option value="${account.accountNumber}">${account.accountNumber}
                                        - ${account.currencyType}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group" style="margin: 10px">
                            <label for="toAccount">Recipient's Account</label>
                            <input
                                    type="text"
                                    class="form-control"
                                    id="toAccount"
                                    name="toAccount"
                                    required
                                    placeholder="Enter recipient's account number"
                            />
                        </div>
                        <div class="form-group" style="margin: 10px">
                            <label for="title">Title</label>
                            <input
                                    type="text"
                                    class="form-control"
                                    id="title"
                                    name="title"
                                    required
                                    placeholder="Enter title of transfer"
                            />
                        </div>
                        <div class="form-group" style="margin: 10px">
                            <label for="amount">Amount</label>
                            <input
                                    type="number"
                                    class="form-control"
                                    id="amount"
                                    name="amount"
                                    placeholder="Enter transfer amount"
                                    min="0.00"
                                    required
                                    onchange="onAmountChange()"
                                    value=
                                    <c:if test="${requestScope.amount == null}">
                                            0.00
                            </c:if>
                            />
                        </div>
                        <div class="form-group" style="margin: 10px">
                            <label for="commissionAmount">Commission Amount</label>
                            <input
                                    type="number"
                                    class="form-control"
                                    id="commissionAmount"
                                    name="commissionAmount"
                                    placeholder="0.00"
                                    required
                                    value=
                                    <c:if test="${requestScope.commissionAmount == null}">
                                            0.00
                                    </c:if>
                                    readonly
                            />
                        </div>
                        <div class="form-group" style="margin: 10px">
                            <label for="totalAmount">Total Amount</label>
                            <input
                                    type="number"
                                    class="form-control"
                                    id="totalAmount"
                                    name="totalAmount"
                                    placeholder="0.00"
                                    required
                                    value=
                                    <c:if test="${requestScope.totalAmount == null}">
                                            0.00
                                    </c:if>
                                    readonly
                            />
                        </div>

                        <button type="submit" class="btn btn-primary btn-block"
                                style="color:white;background: #e63946;margin: 1px;border: none;padding: 8px 32px;">
                            Transfer
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- End of Money Transfer Form -->
<script src="../js/moneytransfer.js"></script>
</body>
</html>
