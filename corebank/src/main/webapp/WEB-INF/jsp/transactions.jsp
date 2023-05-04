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
    <title>Transactions</title>
</head>
<body>
<!-- Navigation bar import -->
<c:import url="components/common/dashboard/dashboard-header.jsp"/>
<!-- End of Navigation bar import -->

<div class="container">
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
</div>

<c:choose>
<c:when test="${fn:length(userTransactions) > 0}">
    <c:import url="components/transactions-display.jsp"/>
</c:when>
<c:otherwise>
    <c:import url="components/no-transactions-display.jsp"/>
</c:otherwise>
</c:choose>

<!-- Footer import -->
<c:import url="components/common/dashboard/dashboard-footer.jsp"/>
<!-- End of Footer import -->
