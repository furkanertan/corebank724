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
    <link rel="stylesheet" href="css/faq.css"/>
    <title>Services</title>
</head>
<body>
<header style="display: flex; justify-content: flex-end; align-items: center; height: 70px; padding: 0 5px;">
    <nav class="navigation">
        <ul style="display: flex; gap: 15px; list-style: none; margin: 0; padding: 0;">
            <li><a href="/" style="text-decoration: none; color: #ffffff;">HOME</a></li>
            <li><a href="/aboutus" style="text-decoration: none; color: #ffffff;">ABOUT</a></li>
            <li><a href="/services" style="text-decoration: none; color: #ffffff;">SERVICES</a></li>
            <li><a href="/contactus" style="text-decoration: none; color: #ffffff;">CONTACT</a></li>
            <li><a href="/faq" style="text-decoration: none; color: #ffffff;">FAQ</a></li>
        </ul>
    </nav>
</header>

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
</section>

<script src="${pageContext.servletContext.contextPath}/js/app.js"></script>
</body>
</html>
