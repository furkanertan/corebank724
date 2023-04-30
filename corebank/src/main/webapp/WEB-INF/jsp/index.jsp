<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="css/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" href="css/fontawesome/css/all.css"/>
    <link rel="stylesheet" href="css/default.css"/>
    <title>Welcome to Corebank 7/24!</title>
</head>
<body>

<!-- Navigation bar import -->
<c:import url="components/common/index/index-header.jsp"/>
<!-- End of Navigation bar import -->

<!-- Welcome Message -->
<div id="welcome-page-card" class="card col-6 bg-transparent border-0">
    <div class="card-body" style="margin-top: 260px">
        <h1 class="mb-3">CoreBank 7/24</h1>
        <h5 class="card-title">
            Banking solutions for everyone!
        </h5>
        <p class="card-text">
            Welcome to CoreBank 7/24, It is designed to provide you with secure, and convenient banking
            services around the clock.
            With CoreBank 7/24, access your accounts, manage your finances and conduct transactions anytime,
            anywhere.<br/>
            Join us today and experience the next generation of digital banking with CoreBank 7/24!
        </p>
        <div class="button-wrapper d-flex align-items-center">
            <a href="/register" class="btn btn-md register" role="button">Register</a>
            <a href="/login" class="btn btn-md login" role="button">Login</a>
        </div>
    </div>
</div>
<!-- End of Welcome Message -->

</body>
</html>
