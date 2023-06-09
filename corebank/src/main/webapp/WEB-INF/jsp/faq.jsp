<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="css/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" href="css/fontawesome/css/all.css"/>
    <link rel="stylesheet" href="css/faq.css"/>
    <title>Services</title>
</head>
<body>
<!-- Navigation bar import -->
<c:import url="components/common/index/index-header.jsp"/>
<!-- End of Navigation bar import -->

<h2>Frequently Asked Questions</h2>
<section>
    <div class="faq">
        <div class="question">
            <h4>What is CoreBank 7/24?</h4>
            <svg width="15" height="10" viewBox="0 0 42 25">
                <path d="M3 3L21 21L39 3" fill="transparent" stroke="white" stroke-width="7" stroke-linecap="round"/>
            </svg>
        </div>
        <div class="answer">
            <p>CoreBank 7/24 is an online banking application designed to provide convenient and secure banking services
                to customers.</p>
        </div>
    </div>
    <div class="faq">
        <div class="question">
            <h4>Is CoreBank 7/24 safe to use?</h4>
            <svg width="15" height="10" viewBox="0 0 42 25">
                <path d="M3 3L21 21L39 3" fill="transparent" stroke="white" stroke-width="7" stroke-linecap="round"/>
            </svg>
        </div>
        <div class="answer">
            <p>Yes, CoreBank 7/24 employs advanced security features to protect our customers' information and
                transactions.</p>
        </div>
    </div>
    <div class="faq">
        <div class="question">
            <h4>How do I sign up for CoreBank 7/24?</h4>
            <svg width="15" height="10" viewBox="0 0 42 25">
                <path d="M3 3L21 21L39 3" fill="transparent" stroke="white" stroke-width="7" stroke-linecap="round"/>
            </svg>
        </div>
        <div class="answer">
            <p>You can sign up for CoreBank 7/24 by visiting our website and following the registration process.
                You will need to provide some personal information and create a username and password.</p>
        </div>
    </div>
    <div class="faq">
        <div class="question">
            <h4>What services does CoreBank 7/24 offer?</h4>
            <svg width="15" height="10" viewBox="0 0 42 25">
                <path d="M3 3L21 21L39 3" fill="transparent" stroke="white" stroke-width="7" stroke-linecap="round"/>
            </svg>
        </div>
        <div class="answer">
            <p>CoreBank 7/24 offers a range of banking services, including account management, currency exchange, loan calculator, and enhanced security.</p>
        </div>
    </div>
    <div class="faq">
        <div class="question">
            <h4>How do I reset my password for CoreBank 7/24?</h4>
            <svg width="15" height="10" viewBox="0 0 42 25">
                <path d="M3 3L21 21L39 3" fill="transparent" stroke="white" stroke-width="7" stroke-linecap="round"/>
            </svg>
        </div>
        <div class="answer">
            <p>You can reset your password by clicking the "Forgot Password" link on the login page and following the instructions.
                You will need to provide some personal information to verify your identity.</p>
        </div>
    </div>
    <div class="faq">
        <div class="question">
            <h4>How do I make a transfer using CoreBank 7/24?</h4>
            <svg width="15" height="10" viewBox="0 0 42 25">
                <path d="M3 3L21 21L39 3" fill="transparent" stroke="white" stroke-width="7" stroke-linecap="round"/>
            </svg>
        </div>
        <div class="answer">
            <p>You can make a transfer by logging in to your account and selecting the "Money Transfers" option.
                You will need to provide the recipient's information and the amount you wish to transfer.</p>
        </div>
    </div>
    <div class="faq">
        <div class="question">
            <h4>How do I contact customer support for CoreBank 7/24?</h4>
            <svg width="15" height="10" viewBox="0 0 42 25">
                <path d="M3 3L21 21L39 3" fill="transparent" stroke="white" stroke-width="7" stroke-linecap="round"/>
            </svg>
        </div>
        <div class="answer">
            <p>You can contact customer support by visiting our website and clicking the "Contact" tab.</p>
        </div>
    </div>
    <div class="faq">
        <div class="question">
            <h4>What types of accounts can I open with CoreBank 7/24?</h4>
            <svg width="15" height="10" viewBox="0 0 42 25">
                <path d="M3 3L21 21L39 3" fill="transparent" stroke="white" stroke-width="7" stroke-linecap="round"/>
            </svg>
        </div>
        <div class="answer">
            <p>CoreBank 7/24 offers various types of accounts, including deposits, savings, and different currency accounts.</p>
        </div>
    </div>
</section>

<script src="${pageContext.servletContext.contextPath}/js/faq.js"></script>
</body>
</html>
