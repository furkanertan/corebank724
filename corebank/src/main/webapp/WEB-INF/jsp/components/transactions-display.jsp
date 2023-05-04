<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- List of Transactions Table -->
<head>
    <title>List of Transactions</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            text-align: left;
            padding: 8px;
            border-bottom: 1px solid #ddd;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        .btn.edit {
            background-color: #008CBA;
        }

        .btn.delete {
            background-color: #f44336;
        }

        .tabs {
            display: flex;
            flex-wrap: wrap;
            font-family: sans-serif;
            padding: 10px 70px;
            margin: 60px;
        }

        .tabs__label {
            padding: 10px 16px;
            cursor: pointer;
        }

        .tabs__radio {
            display: none;
        }

        .tabs__content {
            order: 1;
            width: 100%;
            line-height: 1.5;
            display: none;
        }

        .tabs__radio:checked + .tabs__label {
            font-weight: bold;
            color: #009578;
            border-bottom: 2px solid #009578;
        }

        .tabs__radio:checked + .tabs__label + .tabs__content {
            display: initial;
        }
    </style>
    <script src="../../../js/accounts-display.js"></script>
</head>
<div class="tabs">
    <!-- Tab1 -->
    <input type="radio" class="tabs__radio" name="tabs-example" id="tab1" checked>
    <label for="tab1" class="tabs__label">List of Transactions</label>
    <div class="tabs__content">
        <!-- List of Transactions Table -->
        <table style="margin-left: 20px;margin-top: 20px; border-collapse: collapse; border: 1px solid #ddd;">
            <thead>
            <tr>
                <th style="padding: 10px; background-color: #f2f2f2;">ID</th>
                <th style="padding: 10px; background-color: #f2f2f2;">Account Number</th>
                <th style="padding: 10px; background-color: #f2f2f2;">Transaction Type</th>
                <th style="padding: 10px; background-color: #f2f2f2;">Message</th>
                <th style="padding: 10px; background-color: #f2f2f2;">Amount</th>
                <th style="padding: 10px; background-color: #f2f2f2;">Reason Code</th>
                <th style="padding: 10px; background-color: #f2f2f2;">Transaction Time</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${userTransactions}" var="transaction">
                <tr>
                    <td style="padding: 10px; border: 1px solid #ddd;">${transaction.id}</td>
                    <td style="padding: 10px; border: 1px solid #ddd;">${transaction.accountNumber}</td>
                    <td style="padding: 10px; border: 1px solid #ddd;">${transaction.transactionType}</td>
                    <td style="padding: 10px; border: 1px solid #ddd;">${transaction.message}</td>
                    <td style="padding: 10px; border: 1px solid #ddd;">${transaction.amount}</td>
                    <td style="padding: 10px; border: 1px solid #ddd;">${transaction.reasonCode}</td>
                    <td style="padding: 10px; border: 1px solid #ddd;">${transaction.transactionTime}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <!-- End of List of Transactions -->
    </div>
    <!-- End of Tab1-->

    <!-- Tab2-->
    <input type="radio" class="tabs__radio" name="tabs-example" id="tab2">
    <label for="tab2" class="tabs__label">Create Transaction</label>
    <div class="tabs__content">
        <!-- Create Transact Form -->
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <div class="card">
                        <div class="card-header text-center" style="color: white;background-color: #14213d;">
                            <h4 style="margin-top: 10px">Create Transaction</h4>
                        </div>
                        <div class="card-body" style="color: #14213d;font-weight:500">
                            <form action="/account/createAccount" method="POST" class="create-transact-form">
                                <div class="form-group" style="margin: 10px">
                                    <label for="accountName">Account Name</label>
                                    <input
                                            type="text"
                                            class="form-control"
                                            id="accountName"
                                            name="accountName"
                                            placeholder="Enter account's name"
                                    />
                                </div>
                                <div class="form-group" style="margin: 10px">
                                    <label for="accountCurrencyType">Account Currency Type</label>
                                    <select class="form-control" id="accountCurrencyType" name="accountCurrencyType">
                                        <option value="">-- Select Currency Type --</option>
                                        <c:forEach items="${currencies}" var="currency">
                                            <option value="${currency.type}">${currency.type}
                                                - ${currency.description}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group" style="margin: 10px">
                                    <label for="accountType">Account Type</label>
                                    <select class="form-control" id="accountType" name="accountType">
                                        <option value="">-- Select Account Type --</option>
                                        <option value="Check">Check</option>
                                        <option value="Deposit">Deposit</option>
                                        <option value="Saving">Saving</option>
                                    </select>
                                </div>
                                <button type="submit" class="btn btn-primary btn-block"
                                        style="color:white;background: #e63946;margin: 10px;border: none;padding: 8px 32px;">
                                    Create Account
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End of Create account Form -->
    </div>
    <!-- End of Tab2-->
</div>
<!-- End of Accounts Table -->
