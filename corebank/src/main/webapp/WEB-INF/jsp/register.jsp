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
    <title>Register</title>
</head>

<body class="d-flex align-items-center justify-content-center">
<div class="card registration-form-card col-4 bg-transparent register-form">
    <div class="card-body">
        <h1 class="form-header card-title mb-3">
            <i class="fas fa-user-plus"></i> Register
        </h1>

        <!-- Display error message-->
        <c:if test="${requestScope.errorUser != null}">
            <div class="alert alert-danger text-center border border-danger">
                <p class="text-center">
                    <i class="fas fa-exclamation-triangle"></i>
                    <b>${requestScope.errorUser}</b>
                </p>
            </div>
        </c:if>
        <!-- End of display error message -->

        <!-- Display success message-->
        <c:if test="${requestScope.success != null}">
            <div class="alert alert-success text-center border border-success">
                <p class="text-center">
                    <i class="fas fa-check-circle"></i>
                    Registration successful!
                </p>
            </div>
        </c:if>
        <!-- End of display success message -->


        <form:form action="/register" class="reg-form" modelAttribute="registerUser">
            <div class="row">
                <div class="form-group col">
                    <form:input
                            type="text"
                            path="firstName"
                            class="form-control form-control-lg"
                            placeholder="First Name"
                    />
                    <form:errors path="firstName" cssClass="text-white bg-danger"/>
                </div>
                <div class="form-group col">
                    <form:input
                            type="text"
                            path="lastName"
                            class="form-control form-control-lg"
                            placeholder="Last Name"
                    />
                    <form:errors path="lastName" cssClass="text-white bg-danger"/>
                </div>
            </div>
            <div class="form-group col">
                <form:input
                        type="text"
                        path="email"
                        class="form-control form-control-lg"
                        placeholder="E-mail"
                />
                <form:errors path="email" cssClass="text-white bg-danger"/>
            </div>

            <div class="form-group col">
                <form:input
                        type="text"
                        path="phone"
                        class="form-control form-control-lg"
                        placeholder="Phone"
                />
                <form:errors path="phone" cssClass="text-white bg-danger"/>
            </div>

            <div class="form-group col">
                <form:input
                        type="text"
                        path="address"
                        class="form-control form-control-lg"
                        placeholder="Address"
                />
                <form:errors path="address" cssClass="text-white bg-danger"/>
            </div>

            <div class="row">
                <div class="form-group col">
                    <form:input
                            type="password"
                            path="password"
                            class="form-control"
                            placeholder="Password"
                    />
                </div>

                <div class="form-group col">
                    <form:input
                            type="password"
                            path="confirmPassword"
                            class="form-control"
                            placeholder="Confirm Password"
                    />
                    <small class="text-white bg-danger">
                            ${confirmPassword}
                    </small>
                </div>
            </div>

            <div class="form-group col">
                <button class="btn btn-md regbtn">Register</button>
            </div>
        </form:form>

        <p class="card-text text-white my-2 d-flex align-items-center">
            Already have an account?
            <span class="ms-1 text-warning"></span>
            <a href="/login" class="btn btn-sm text-warning">Login</a>
        </p>

        <small class="card-text text-white my-2 d-flex align-items-center">
            <i class="fa-solid fa-circle-left"><a href="/"></a></i>
            <a href="/" class="btn btn-sm text-warning">Back to Main Page</a>
        </small>
    </div>
</div>
</body>
</html>
