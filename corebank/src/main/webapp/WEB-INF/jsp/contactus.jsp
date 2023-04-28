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
    <link rel="stylesheet" href="css/contactUs.css"/>
    <title>Contact Us</title>
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

<!-- Display success message-->
<c:if test="${requestScope.success != null}">
    <div class="alert alert-success text-center border border-success">
        <p class="text-center">
            <i class="fas fa-check-circle"></i>
            <b>${requestScope.success}</b>
        </p>
    </div>
</c:if>
<!-- End of display success message -->

<!-- Display error message-->
<c:if test="${requestScope.error != null}">
    <div class="alert alert-danger text-center border border-danger">
        <p class="text-center">
            <i class="fas fa-exclamation-triangle"></i>
            <b>${requestScope.error}</b>
        </p>
    </div>
</c:if>
<!-- End of display error message -->

<div class="contactUs">
    <div class="row">
        <h2 style="color: white;align-content: center;justify-content: center;display: flex">Contact Us</h2>
    </div>
    <div class="row">
        <div class="box">

            <!-- Contact form -->
            <div class="contact form">
                <h3>Send us a message</h3>
                <form action="/contactus" method="POST">
                    <div class="formBox">
                        <div class="row50">
                            <div class="inputBox">
                                <span>First Name</span>
                                <input type="text" name="name" placeholder="John" required>
                            </div>
                            <div class="inputBox">
                                <span>Last Name</span>
                                <input type="text" name="surname" placeholder="Doe" required>
                            </div>
                        </div>

                        <div class="row50">
                            <div class="inputBox">
                                <span>Email</span>
                                <input type="text" name="email" placeholder="johndoe@email.com" required>
                            </div>
                            <div class="inputBox">
                                <span>Phone Number</span>
                                <input type="text" name="phoneNumber" placeholder="+48 123 456 789" required>
                            </div>
                        </div>

                        <div class="row100">
                            <div class="inputBox">
                                <span>Message</span>
                                <textarea name="message" placeholder="Please write your message" required></textarea>
                            </div>
                        </div>

                        <div class="row100">
                            <div class="inputBox">
                                <input type="submit" value="Send">
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <!-- End of Contact form -->

            <!-- Contact info -->
            <div class="contact info">
                <h3>Contact Information</h3>
                <div class="infoBox">
                    <div>
                        <span><ion-icon name="location-outline"></ion-icon></span>
                        <p>Rewolucji 1905 roku 45, Lodz, POLAND, 90-215</p>
                    </div>

                    <div>
                        <span><ion-icon name="mail-outline"></ion-icon></span>
                        <a href="mailto:corebank724@gmail.com">corebank724@gmail.com</a>
                    </div>

                    <div>
                        <span><ion-icon name="call-outline"></ion-icon></span>
                        <a href="tel:+48159874632">+48 159 874 632</a>
                    </div>

                    <ul class="sci">
                        <li><a href="#">
                            <ion-icon name="logo-facebook"></ion-icon>
                        </a></li>
                        <li><a href="#">
                            <ion-icon name="logo-twitter"></ion-icon>
                        </a></li>
                        <li><a href="#">
                            <ion-icon name="logo-instagram"></ion-icon>
                        </a></li>
                        <li><a href="#">
                            <ion-icon name="logo-linkedin"></ion-icon>
                        </a></li>
                    </ul>
                </div>
            </div>
            <!-- End of Contact info -->

            <!-- Contact map -->
            <div class="contact map">
                <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d9874.70108584123!2d19.4661191!3d51.7755434!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x471bcb27c0625d07%3A0xf61faa71bd193a62!2zQmFzZWNhbXAgxYHDs2TFuiBSZXdvbHVjamk!5e0!3m2!1str!2spl!4v1682276286303!5m2!1str!2spl"
                        width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy"
                        referrerpolicy="no-referrer-when-downgrade"></iframe>
            </div>
            <!-- End of Contact map -->
        </div>
    </div>
</div>

<script type="module" src="https://unpkg.com/ionicons@5.2.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@5.2.2/dist/ionicons/ionicons.js"></script>
</body>
</html>
