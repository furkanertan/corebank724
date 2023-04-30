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
    <title>Dashboard</title>
</head>

<body>

<!-- Navigation bar import -->
<c:import url="components/common/dashboard/dashboard-header.jsp"/>
<!-- End of Navigation bar import -->

<!-- Add Charts -->
<div class="charts-container">
    <div class="row my-2">
        <div class="col-lg-3 col-md-4 col-sm-12">
            <div class="card bg-danger text-white mb-3">
                <div class="card-body">
                    <h5 class="card-title">Account Number</h5>
                    <p class="card-text h3">
                        <c:choose>
                            <c:when test="${accountsCount == 0}">
                                0
                            </c:when>
                            <c:otherwise>
                                ${accountsCount}
                            </c:otherwise>
                        </c:choose>
                    </p>
                    <i class="fas fa-2x fa-coins"></i>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-md-4 col-sm-12">
            <div class="card bg-primary text-white mb-3">
                <div class="card-body">
                    <h5 class="card-title">Total Deposit</h5>
                    <p class="card-text h3">0</p>
                    <i class="fas fa-2x fa-sack-dollar"></i>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-md-4 col-sm-12">
            <div class="card bg-success text-white mb-3">
                <div class="card-body">
                    <h5 class="card-title">Total Withdraw</h5>
                    <p class="card-text h3">0</p>
                    <i class="fas  fa-2x fa-money-bill-transfer"></i></div>
            </div>
        </div>
        <div class="col-lg-3 col-md-4 col-sm-12">
            <div class="card bg-dark text-white mb-3">
                <div class="card-body">
                    <h5 class="card-title">Total Withdraw</h5>
                    <p class="card-text h3">0</p>
                    <i class="fas  fa-2x fa-money-bill-transfer"></i></div>
            </div>
        </div>
    </div>
    <div class="row my-2">
        <div class="col-lg-6 col-md-12 col-sm-12 mt-3" id="char-line-div">
            <div class="card shadow-lg">
                <div class="card-title">
                    <h5 class="text-center">Last 5 Transactions</h5>
                </div>
                <div class="card-body">
                    <div
                            style="display: none;text-align: center; width: 100%; height: 100%; position: absolute; left: 0; top: 100px; z-index: 20;"
                            id="no-category"
                    >
                        <b>No category!</b>
                    </div>
                    <canvas id="chart-line"></canvas>
                </div>
            </div>
        </div>
        <div class="col-lg-6 col-md-12 col-sm-12 mt-3" id="char-line-div">
            <div class="card shadow-lg">
                <div class="card-title">
                    <h5 class="text-center">Currency Exchange Rates</h5>
                </div>
                <div class="card-body">
                    <div
                            style="display: none;text-align: center; width: 100%; height: 100%; position: absolute; left: 0; top: 100px; z-index: 20;"
                            id="no-brands"
                    >
                        <b>{% trans 'message:no_brands_found' %}</b>
                    </div>
                    <canvas id="chart-line-brands"></canvas>
                </div>
            </div>
        </div>
    </div>
    <div class="row my-2">
        <div class="col-12 mt-3" id="bar-chart-div">
            <div class="card shadow-lg">
                <div class="card-title">
                    <h5 class="text-center">Assets (Year)</h5>
                </div>
                <div class="card-body">
                    <canvas id="bar-chart"></canvas>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- End of Charts -->

<div class="container d-flex">
    <button
            id="transact-btn"
            class="btn btn-md ms-auto shadow"
            type="button"
            data-bs-toggle="offcanvas"
            data-bs-target="#offcanvasExample"
            aria-controls="offcanvasExample"
    >
        <i class="fa-solid fa-money-bill-transfer"></i> Transact
    </button>
</div>

<div class="container d-flex py-3">
    <h3 class="ms-auto">Total Accounts Balance:</h3>
    <h3 class="ms-auto">0.00</h3>
</div>

<c:import url="components/fast-transaction-canvas.jsp"/>
<c:import url="components/add-account-canvas.jsp"/>

<!-- Footer import -->
<c:import url="components/common/dashboard/dashboard-footer.jsp"/>
<!-- End of Footer import -->
