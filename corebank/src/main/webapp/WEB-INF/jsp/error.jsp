<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="css/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" href="css/fontawesome/css/all.css"/>
    <link rel="stylesheet" href="css/default.css"/>
    <style>
        * {
            box-sizing: border-box;
            font-family: Arial, serif;
        }

        body {
            height: 100vh;
            background-image: url("../images/corebank-background.png");
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
        }

        .card .card-text {
            font-size: 16px;
        }

        .card .card-title {
            font-size: 20px;
            color: red;
        }
    </style>
    <title>Error</title>
</head>
<body class="d-flex align-items-center justify-content-center">
<div class="card col-4 alert alert-danger border border-danger text-danger">
    <h3 class="card-title">
        <i class="fa fa-window-close me-2"></i> Errors:
    </h3>

    <hr/>
    <div class="card-body">
        <p class="card-text">

            <!-- Display error message-->
            <c:if test="${requestScope.error != null}">
                <div class="alert alert-danger text-center border border-danger">
                     <p class="text-center">
                        <b>${requestScope.error}</b>
                    </p>
                </div>
            </c:if>
            <!-- End of display error message -->

        </p>
        <hr/>
        <a href="/login" class="btn btn-danger btn-sm">
            <i class="fa fa-arrow-left me-1"></i> Back
        </a>
    </div>
</div>
</body>
</html>
