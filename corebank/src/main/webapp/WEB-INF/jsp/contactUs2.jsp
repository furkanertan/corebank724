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
    <link rel="stylesheet" href="css/default.css"/>
    <title>Contact Us</title>
    <style>
        /* Add your custom CSS styles here */
        .container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #f8f8f8;
            border: 1px solid #ddd;
            border-radius: 5px;
            margin-top: 50px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }

        .container h2 {
            text-align: center;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-group label {
            font-weight: bold;
        }

        .form-group input,
        .form-group textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 3px;
            font-size: 16px;
        }

        .form-group textarea {
            height: 150px;
        }

        .form-group i {
            position: absolute;
            top: 35px;
            right: 10px;
            color: #cecccc;
            pointer-events: none;
        }

        .form-group.error input,
        .form-group.error textarea {
            border: 1px solid #e74c3c;
        }

        .form-group.error i {
            color: #e74c3c;
        }

        .form-group.success input,
        .form-group.success textarea {
            border: 1px solid #2ecc71;
        }

        .form-group.success i {
            color: #2ecc71;
        }

        .btn {
            display: inline-block;
            padding: 10px 20px;
            background-color: #3498db;
            color: #fff;
            font-size: 18px;
            border: none;
            cursor: pointer;
            border-radius: 3px;
            transition: background-color 0.3s ease;
        }

        .btn:hover {
            background-color: #2980b9;
        }

        .alert {
            padding: 10px;
            margin-bottom: 20px;
            border-radius: 3px;
        }

        .alert.success {
            background-color: #2ecc71;
            color: #fff;
        }

        .alert.error {
            background-color: #e74c3c;
            color: #fff;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Contact Us</h2>
    <form action="/contact" method="post" id="contactForm">
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" name="name" id="name" required>
            <i class="fa fa-user"></i>
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" name="email" id="email" required>
            <i class="fa fa-envelope"></i>
        </div>
        <div class="form-group">
            <label for="phone">Phone</label>
            <input type="text" name="phone" id="phone">
            <i class="fa fa-phone"></i>
        </div>
        <div class="form-group">
            <label for="message">Message</label>
            <textarea name="message" id="message" required></textarea>
            <i class="fa fa-comments"></i></div>
        <button type="submit" class="btn">Submit</button>
    </form>
    <div id="responseMsg"></div>
</div>
<script>
    document.getElementById("contactForm").addEventListener("submit", function (event) {
        event.preventDefault();

        // Clear previous response messages
        document.getElementById("responseMsg").innerHTML = "";

        // Validate form inputs
        let name = document.getElementById("name").value.trim();
        let email = document.getElementById("email").value.trim();
        let message = document.getElementById("message").value.trim();
        let phone = document.getElementById("phone").value.trim();

        if (!name || !email || !message) {
            document.getElementById("responseMsg").innerHTML = '<div class="alert error"><i class="fa fa-exclamation-circle"></i> Please fill in all the required fields</div>';
            return;
        }

        // Send form data to server for processing
        // You can use AJAX or fetch to send the form data to the server
        // Example: fetch('/contact', { method: 'POST', body: new FormData(event.target) })

        // Display success message
        document.getElementById("responseMsg").innerHTML = '<div class="alert success"><i class="fa fa-check-circle"></i> Message sent successfully</div>';

        // Clear form inputs
        document.getElementById("name").value = "";
        document.getElementById("email").value = "";
        document.getElementById("message").value = "";
        document.getElementById("phone").value = "";
    });
</script>
</body>
</html>
