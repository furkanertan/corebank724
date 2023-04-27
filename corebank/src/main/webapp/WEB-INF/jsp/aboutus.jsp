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
    <link rel="stylesheet" href="css/aboutus.css"/>
    <title>About Us</title>
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

<h2>About Us</h2>

<div class="wrapper">
    <div class="about-container">
        <div class="img-container">
            <img src="${pageContext.servletContext.contextPath}/images/about-us-picture.jpg" alt="">
        </div>
        <div class="text-container">
            <h1>CoreBank 7/24: Your Reliable and Convenient Online Banking Solution</h1>
            <p>CoreBank 7/24 is an innovative online banking application designed to provide convenient and secure
                banking services to customers.
                Our mission is to make banking accessible anytime, anywhere, and on any device, while ensuring the
                highest standards of security and reliability.
                We believe that technology should simplify banking, and that's why we have developed a user-friendly and
                intuitive platform that caters to the needs of modern-day customers.</p>
            <p>At CoreBank 7/24, we understand the importance of trust and security in banking.
                That's why we have implemented state-of-the-art security features to protect our customers' sensitive
                information and transactions.
                We use the latest encryption technology to safeguard data, and we have multiple layers of authentication
                to prevent unauthorized access.
                Our platform is continuously monitored and updated to ensure optimal performance and protection against
                emerging threats.</p>
            <p>We are committed to providing excellent customer service and support to our users.
                Our team of experienced professionals is dedicated to assisting customers with any questions or issues
                they may encounter while using our platform.
                We value feedback from our customers and strive to continuously improve our services based on their
                needs and preferences.
                We believe that our customers are at the heart of our business,
                and we are committed to delivering the best possible banking experience to them through CoreBank
                7/24.</p>
        </div>
    </div>
</div>
</body>
</html>
