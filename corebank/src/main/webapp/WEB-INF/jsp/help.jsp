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
    <title>Help</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            font-size: 16px;
            line-height: 1.5;
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
            margin-top: 50px;
        }

        .faq {
            border: 1px solid #ddd;
            padding: 20px;
            margin-top: 40px;
        }

        .faq h3 {
            font-size: 20px;
            margin-top: 0;
            margin-bottom: 10px;
            color: #0a53be;
        }

        .faq p {
            margin-bottom: 20px;
        }

        .faq h3:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<!-- Navigation bar import -->
<c:import url="components/common/dashboard/dashboard-header.jsp"/>
<!-- End of Navigation bar import -->

<div class="container">
    <h2>Frequently Asked Questions</h2>
    <div class="faq">
        <h3>How can I create an account?</h3>
        <p>First, you should click on "Accounts" section on the header of the page, and then you should choose "Create
            Account" tab in the page.
            After you filled all required fields, you will have a new account created.</p>
    </div>
    <div class="faq">
        <h3>How can I update an account?</h3>
        <p>First, you should click on "Accounts" section on the header of the page, and all of your active accounts will
            appear on "List/Update Accounts" tab in the page.
            After you clicked on "Update" button at the end of the list, you will be able to update your account.
            When all data is correct, you can click "Update Account" button and account update process will be
            completed.</p>
    </div>
    <div class="faq">
        <h3>How can I delete an account?</h3>
        <p>First, you should click on "Accounts" section on the header of the page, and all of your active accounts will
            appear on "List/Update Accounts" tab in the page.
            After you clicked on "Delete" button at the end of the list, your account will be deleted and your account
            list will be refreshed.</p>
    </div>
    <div class="faq">
        <h3>How can I see all my accounts?</h3>
        <p>First, you should click on "Accounts" section on the header of the page, and then you should choose
            "List/Update
            Accounts" tab in the page.
            After you filled all required fields, you will have a new account created.</p>
    </div>
    <div class="faq">
        <h3>Is there any limitation on number of creating accounts?</h3>
        <p>No, there is no limitation on number of creating accounts.</p>
    </div>
    <div class="faq">
        <h3>What kind of accounts I can create?</h3>
        <p>You can create three types of account, which are "Saving", "Deposit" and "Check" accounts.</p>
    </div>
    <div class="faq">
        <h3>Which currencies are available for accounts?</h3>
        <p>You can create accounts with "USD", "GBP", "PLN", "EUR" and "TRY" currencies.</p>
    </div>
    <div class="faq">
        <h3>How can I transfer money to another accounts?</h3>
        <p>You should click on "Money Transfers" section on the header of the page, and a form will appear on the
            page.
            After you filled all required fields, you will successfully complete transfer.</p>
    </div>
    <div class="faq">
        <h3>Can I transfer money between my accounts?</h3>
        <p>Yes, you can transfer money between your accounts.</p>
    </div>
    <div class="faq">
        <h3>How can I see all my money transfers?</h3>
        <p>Money transfer history is available under "Transactions" section. Also, you can see your "Last 5
            Transactions" on the dashboard.</p>
    </div>
    <div class="faq">
        <h3>Can I transfer money between different currencies?</h3>
        <p>No, you cannot transfer money between different currencies. First, you have to exchange currency, and then
            you
            can complete the transfer.</p>
    </div>
    <div class="faq">
        <h3>How can I exchange currencies?</h3>
        <p>You should click on "Currency Exchange" section on the header of the page, and a form will appear on the
            page.
            After you choose "from" and "to" currencies right, and all required fields are filled, you will successfully
            complete exchange.</p>
    </div>
    <div class="faq">
        <h3>Which currencies are available for exchange?</h3>
        <p>You can exchange "USD", "GBP", "PLN", "EUR" and "TRY" currencies.</p>
    </div>
    <div class="faq">
        <h3>How can I see all my currency exchange history?</h3>
        <p>Currency exchange history is available under "Transactions" section. So, you should click on "Transactions"
            section on the header of the page
            and all your transactions will appear on "List of Transactions" tab.</p>
    </div>
    <div class="faq">
        <h3>How can I see all my transaction history?</h3>
        <p>Transaction history is available under "Transactions" section. So, you should click on "Transactions" section
            on the header of the page
            and all your transactions will appear on "List of Transactions" tab.</p>
    </div>
    <div class="faq">
        <h3>How can I update my profile?</h3>
        <p>You should click your name on the header of the page, and on the dropdown menu, you should click "Profile".
            Your profile information will appear, and you can update them and save changes.</p>
    </div>
    <div class="faq">
        <h3>What should I do if I forget my online banking password?</h3>
        <p>If you forget your online banking password, you can usually reset it by following the "forgot password" or
            "reset password" link on the login page. You will then be prompted to enter your email address or other
            identifying information, and the bank will send you a link or code to reset your password.</p>
    </div>
</div>

<!-- Footer import -->
<c:import url="components/common/dashboard/dashboard-footer.jsp"/>
<!-- End of Footer import -->