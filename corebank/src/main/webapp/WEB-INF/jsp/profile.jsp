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
    <style>

        form {
            display: flex;
            flex-direction: column;
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        label {
            font-size: 18px;
            margin-top: 10px;
        }

        input[type=text], input[type=email], input[type=tel], input[type=password] {
            padding: 10px;
            margin: 5px 0;
            border: none;
            border-radius: 3px;
            background-color: #f2f2f2;
        }

        input[type=submit] {
            background-color: #4CAF50;
            color: #fff;
            border: none;
            border-radius: 3px;
            padding: 10px;
            margin-top: 20px;
            font-size: 18px;
            cursor: pointer;
        }

        input[type=submit]:hover {
            background-color: #3e8e41;
        }
    </style>
    <title>Profile</title>
</head>
<body>
<!-- Navigation bar import -->
<c:import url="components/common/dashboard/dashboard-header.jsp"/>
<!-- End of Navigation bar import -->

<div class="container" style="width: 50%;">
    <!-- Display success message-->
    <c:if test="${requestScope.successProfile != null}">
        <div class="alert alert-success text-center border border-success">
            <p class="text-center">
                <i class="fas fa-check-circle"></i>
                <b>${requestScope.successProfile}</b>
            </p>
        </div>
    </c:if>
    <!-- End of display success message -->

    <!-- Display error message-->
    <c:if test="${requestScope.errorProfile != null}">
        <div class="alert alert-danger text-center border border-danger">
            <p class="text-center">
                <i class="fas fa-exclamation-triangle"></i>
                <b>${requestScope.errorProfile}</b>
            </p>
        </div>
    </c:if>
    <!-- End of display error message -->
</div>

<div class="container" style="width: 60%;margin-top: 50px">
    <form action="/editProfile" method="POST" class="profile-update-form">
        <h2>Profile</h2>
        <label for="firstName">First Name</label>
        <input type="text" id="firstName" name="firstName" value="${user.firstName}" required>

        <label for="lastName">Last Name</label>
        <input type="text" id="lastName" name="lastName" value="${user.lastName}" required>

        <label for="email">Email</label>
        <input type="email" id="email" name="email" value="${user.email}" required readonly>

        <label for="phone">Phone Number</label>
        <input type="tel" id="phone" name="phone" value="${user.phone}" required>

        <label for="address">Address</label>
        <input type="text" id="address" name="address" value="${user.address}" required>

        <input type="submit" value="Save Changes">
    </form>
</div>

<!-- Footer import -->
<c:import url="components/common/dashboard/dashboard-footer.jsp"/>
<!-- End of Footer import -->
