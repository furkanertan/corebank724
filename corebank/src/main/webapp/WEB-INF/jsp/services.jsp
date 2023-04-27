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
    <link rel="stylesheet" href="css/services.css"/>
    <title>Services</title>
</head>
<body>
<header style="display: flex; justify-content: flex-end; align-items: center; height: 70px; padding: 0 5px;">
    <nav class = "navigation">
        <ul style="display: flex; gap: 15px; list-style: none; margin: 0; padding: 0;">
            <li><a href="/" style="text-decoration: none; color: #ffffff;">HOME</a></li>
            <li><a href="/aboutus" style="text-decoration: none; color: #ffffff;">ABOUT</a></li>
            <li><a href="/services" style="text-decoration: none; color: #ffffff;">SERVICES</a></li>
            <li><a href="/contactus" style="text-decoration: none; color: #ffffff;">CONTACT</a></li>
            <li><a href="/faq" style="text-decoration: none; color: #ffffff;">FAQ</a></li>
        </ul>
    </nav>
</header>

<h2>Our Services</h2>

<div class="container">
    <div class="row">
        <div class="col-md-3">
            <div class="main">
                <div class="service">
                    <div class="service-icon">
                        <img src="${pageContext.servletContext.contextPath}/images/bank-account-icon.png" alt="">
                    </div>
                    <h4>Account Management</h4>
                    <p>CoreBank 7/24 offers comprehensive account management services to help customers keep track of their finances.</p>
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="main">
                <div class="service">
                    <div class="service-icon">
                        <img src="${pageContext.servletContext.contextPath}/images/currency-exchange-icon.png" alt="">
                    </div>
                    <h4>Currency Exchange</h4>
                    <p>CoreBank 7/24 offers a currency exchange service that allows customers to exchange currencies quickly and easily with real-time exchange rates.</p>
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="main">
                <div class="service">
                    <div class="service-icon">
                        <img src="${pageContext.servletContext.contextPath}/images/loan-icon.jpg" alt="">
                    </div>
                    <h4>Loan Calculator</h4>
                    <p>CoreBank 7/24 offer a loan calculator that helps customers calculate their loan amounts, interest rates, and payment schedules.</p>
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="main">
                <div class="service">
                    <div class="service-icon">
                        <img src="${pageContext.servletContext.contextPath}/images/security-icon.png" alt="">
                    </div>
                    <h4>Enhanced Security</h4>
                    <p>CoreBank 7/24 platform is regularly updated and monitored to ensure the highest level of security and protection against emerging threats.</p>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
