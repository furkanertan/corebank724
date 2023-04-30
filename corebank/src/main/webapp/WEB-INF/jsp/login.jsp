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
    <title>Login</title>
</head>

<body class="d-flex align-items-center justify-content-center">
<div class="card login-form-card col-3 bg-transparent login-form">
    <div class="card-body">
        <h1 class="form-header card-title mb-3">
            <i class="fa fa-user-circle"></i> Login
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

        <!-- Display logged out message-->
        <c:if test="${logged_out != null}">
            <div class="alert alert-info text-center border border-info">
                <p class="text-center">
                    <i class="fas fa-check-circle"></i>
                    <b>${logged_out}</b>
                </p>
            </div>
        </c:if>
        <!-- End of display success message -->

        <form action="/login" method="POST">
            <div class="form-group col">
                <input
                        type="text"
                        name="email"
                        class="form-control form-control-lg"
                        placeholder="E-mail"
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

            <!-- Token -->
            <div class="form-group col">
                <input
                        type="hidden"
                        name="_token"
                        value="${token}"
                />
            </div>
            <!-- End of token -->

            <div class="form-group col d-flex align-items-center">
                <button class="btn btn-md logbtn">Login</button>
                <span class="ms-1 text-warning"></span>
                <a href="/forgotPassword" class="btn btn-sm text-warning">Forgot Password?</a>
            </div>
        </form>

        <p class="card-text text-white my-2 d-flex align-items-center">
            Don't have an account?
            <span class="ms-1 text-warning"></span>
            <a href="/register" class="btn btn-sm text-warning">Sign Up</a>
        </p>

        <small class="card-text text-white my-2 d-flex align-items-center">
            <i class="fa-solid fa-circle-left"></i>
            <a href="/" class="btn btn-sm text-warning">Back to Main Page</a>
        </small>
    </div>
</div>
</body>
</html>
