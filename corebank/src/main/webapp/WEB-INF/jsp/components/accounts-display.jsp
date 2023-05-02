<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- Accounts Table -->
<head>
    <title>List/Edit Accounts</title>
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

        thead:hover {
            color: white;
            background-color: #14213d;
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
    <label for="tab1" class="tabs__label">List/Update Accounts</label>
    <div class="tabs__content">
        <!-- List/Update Accounts -->
        <div class="container d-flex">
            <table>
                <thead style="color: white; background-color: #14213d;">
                <tr>
                    <th>ID</th>
                    <th>Account Number</th>
                    <th>Account Name</th>
                    <th>Account Type</th>
                    <th>Account Currency Type</th>
                    <th>Balance</th>
                    <th>Created At</th>
                    <th>Updated At</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${userAccounts}" var="account">
                    <tr>
                        <td>${account.id}</td>
                        <td>${account.accountNumber}</td>
                        <td>${account.accountName}</td>
                        <td>${account.accountType}</td>
                        <td>${account.currencyType}</td>
                        <td>${account.balance}</td>
                        <td>${account.createdAt}</td>
                        <td>${account.updatedAt}</td>
                        <td>
                            <button class="btn btn-primary btn-block edit"
                                    style="padding: 6px 12px;color: white;border: none;border-radius: 4px;cursor: pointer;">
                                Edit
                            </button>
                            <form action="/account/deleteAccount" method="POST" class="delete-account-form">
                                <input type="hidden" name="accountNumber" value="${account.accountNumber}">
                                <button class="btn btn-primary btn-block delete"
                                        style="padding: 6px 12px;color: white;border: none;border-radius: 4px;cursor: pointer;">
                                    Delete
                                </button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <!-- End of List/Update Accounts -->
    </div>
    <!-- End of Tab1-->

    <!-- Tab2-->
    <input type="radio" class="tabs__radio" name="tabs-example" id="tab2">
    <label for="tab2" class="tabs__label">Create Account</label>
    <div class="tabs__content">
        <!-- Create account Form -->
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-6">
                    <div class="card">
                        <div class="card-header text-center" style="color: white;background-color: #14213d;">
                            <h4 style="margin-top: 10px">Create Account</h4>
                        </div>
                        <div class="card-body" style="color: #14213d;font-weight:500">
                            <form action="/account/createAccount" method="POST" class="add-account-form">
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
                                        <option value="EUR">EUR</option>
                                        <option value="GBP">GBP</option>
                                        <option value="PLN">PLN</option>
                                        <option value="TRY">TRY</option>
                                        <option value="USD">USD</option>
                                    </select>
                                </div>
                                <div class="form-group" style="margin: 10px">
                                    <label for="accountType">Account Type</label>
                                    <select class="form-control" id="accountType" name="accountType">
                                        <option value="">-- Select Currency Type --</option>
                                        <option value="Deposit">Deposit</option>
                                        <option value="Savings">Savings</option>
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




