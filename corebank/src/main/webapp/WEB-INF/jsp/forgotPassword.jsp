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
    <title>Forgot Password</title>
    <head>
        <title>Title</title>
    </head>
<body class="d-flex align-items-center justify-content-center">
<div class="card forgot-password-form-card col-3 bg-transparent forgot-password-form">
    <div class="card-body">
        <h1 class="form-header card-title mb-3">
            <i class="fas fa-user-lock"></i>
            Forgot Password
        </h1>

        <div class="form-group col">
            <p class="text-white">Enter your email and we'll send you an email to reset your password.</p>
        </div>

        <form action="/forgotPassword" method="POST">
            <div class="form-group col">
                <input
                        type="text"
                        name="email"
                        class="form-control form-control-lg"
                        placeholder="E-mail"
                />
            </div>

            <div class="form-group col d-flex align-items-center">
                <button class="btn btn-md submitbtn">Submit</button>
            </div>

            <small class="card-text text-white my-2 d-flex align-items-center">
                <i class="fa-solid fa-circle-left"></i>
                <a href="/login" class="btn btn-sm text-warning">Back</a>
            </small>
        </form>
    </div>
</div>
</body>
</html>
