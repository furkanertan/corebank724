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
    <title>Set Up New Password</title>
</head>
<body class="d-flex align-items-center justify-content-center">
<div class="card login-form-card col-3 bg-transparent login-form">
    <div class="card-body">
        <h1 class="form-header card-title mb-3">
            <i class="fas fa-key"></i>
            Set New Password
        </h1>

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

        <form action="/setUpNewPassword" method="POST">
            <div class="form-group col">
                <input
                        type="hidden"
                        name="_userId"
                        value="${userId}"
                />
            </div>

            <div class="form-group col">
                <input
                        type="password"
                        name="password"
                        class="form-control"
                        placeholder="Password"
                />
            </div>

            <div class="form-group col">
                <input
                        type="password"
                        name="confirmPassword"
                        class="form-control"
                        placeholder="Confirm Password"
                />
            </div>

            <div class="form-group col d-flex align-items-center">
                <button class="btn btn-md submitbtn">Submit</button>
            </div>
        </form>

        <small class="card-text text-white my-2 d-flex align-items-center">
            <i class="fa-solid fa-circle-left"><a href="/login"></a></i>
            <a href="/login" class="btn btn-sm text-warning">Back to Login</a>
        </small>
</body>
</html>
