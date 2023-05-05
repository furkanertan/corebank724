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
        <h3>What is online banking?</h3>
        <p>Online banking is a service that allows you to manage your bank account over the internet. With online
            banking, you can check your account balance, view transaction history, transfer money, pay bills, and
            more.</p>
    </div>
    <div class="faq">
        <h3>Is online banking secure?</h3>
        <p>Yes, online banking is generally considered to be safe and secure. Banks use a variety of security measures,
            such as encryption, firewalls, and two-factor authentication, to protect your personal and financial
            information.</p>
    </div>
    <div class="faq">
        <h3>How do I sign up for online banking?</h3>
        <p>To sign up for online banking, you will need to contact your bank and request access to their online banking
            service. The bank will then provide you with login credentials, which you can use to access your account
            online.</p>
    </div>
    <div class="faq">
        <h3>What should I do if I forget my online banking password?</h3>
        <p>If you forget your online banking password, you can usually reset it by following the "forgot password" or
            "reset password" link on the login page. You will then be prompted to enter your email address or other
            identifying information, and the bank will send you a link or code to reset your password.</p>
    </div>
    <div class="faq">
        <h3>Can I access online banking from my mobile device?</h3>
        <p>Yes, most banks offer a mobile app or a mobile-friendly website that you can use to access your online
            banking account from your smartphone or tablet.</p>
    </div>
</div>

<!-- Footer import -->
<c:import url="components/common/dashboard/dashboard-footer.jsp"/>
<!-- End of Footer import -->