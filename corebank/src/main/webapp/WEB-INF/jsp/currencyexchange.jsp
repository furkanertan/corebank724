<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="css/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" href="css/fontawesome/css/all.css"/>
    <link rel="stylesheet" href="css/dashboard.css"/>
    <script src="js/bootstrap.bundle.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.9.3/umd/popper.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.2/js/bootstrap.min.js"></script>
    <title>Currency Exchange</title>
</head>
<body>
<!-- Navigation bar import -->
<c:import url="components/common/dashboard/dashboard-header.jsp"/>
<!-- End of Navigation bar import -->

<div class="currency-cards">
    <div class="row row-cols-1 row-cols-md-3 g-4">
        <div class="col">
            <div class="card h-100">
                <div class="card-body">
                    <h5 class="card-title">EUR/PLN</h5>
                    <p class="card-text">1 EUR = 1.17 PLN</p>
                </div>
                <div class="card-footer">
                    <img
                            src="https://www.countryflags.io/eu/flat/32.png"
                            alt="European Union Flag"
                    />
                    <img
                            src="https://www.countryflags.io/us/flat/32.png"
                            alt="United States Flag"
                    />
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card h-100">
                <div class="card-body">
                    <h5 class="card-title">USD/PLN</h5>
                    <p class="card-text">1 USD = 0.85 PLN</p>
                </div>
                <div class="card-footer">
                    <img
                            src="https://www.countryflags.io/eu/flat/32.png"
                            alt="European Union Flag"
                    />
                    <img
                            src="https://www.countryflags.io/gb/flat/32.png"
                            alt="United Kingdom Flag"
                    />
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card h-100">
                <div class="card-body">
                    <h5 class="card-title">TL/PLN</h5>
                    <p class="card-text">1 TL = 111.18 PLN</p>
                </div>
                <div class="card-footer">
                    <img
                            src="https://www.countryflags.io/us/flat/32.png"
                            alt="United States Flag"
                    />
                    <img
                            src="https://www.countryflags.io/jp/flat/32.png"
                            alt="Japan Flag"
                    />
                </div>
            </div>
        </div>
    </div>

    <div class="row row-cols-1 row-cols-md-3 g-4">
        <div class="col">
            <div class="card h-100">
                <div class="card-body">
                    <h5 class="card-title">EUR/PLN</h5>
                    <p class="card-text">1 EUR = 1.17 PLN</p>
                </div>
                <div class="card-footer">
                    <img
                            src="https://www.countryflags.io/eu/flat/32.png"
                            alt="European Union Flag"
                    />
                    <img
                            src="https://www.countryflags.io/us/flat/32.png"
                            alt="United States Flag"
                    />
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card h-100">
                <div class="card-body">
                    <h5 class="card-title">USD/PLN</h5>
                    <p class="card-text">1 USD = 0.85 PLN</p>
                </div>
                <div class="card-footer">
                    <img
                            src="https://www.countryflags.io/eu/flat/32.png"
                            alt="European Union Flag"
                    />
                    <img
                            src="https://www.countryflags.io/gb/flat/32.png"
                            alt="United Kingdom Flag"
                    />
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card h-100">
                <div class="card-body">
                    <h5 class="card-title">TL/PLN</h5>
                    <p class="card-text">1 TL = 111.18 PLN</p>
                </div>
                <div class="card-footer">
                    <img
                            src="https://www.countryflags.io/us/flat/32.png"
                            alt="United States Flag"
                    />
                    <img
                            src="https://www.countryflags.io/jp/flat/32.png"
                            alt="Japan Flag"
                    />
                </div>
            </div>
        </div>
    </div>
</div>

<div class="currency-exchange-form">
    <!-- Currency Exchange Form -->
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <form>
                <div class="form-group">
                    <label for="from_currency">From Currency</label>
                    <select class="form-control" id="from_currency">
                        <option value="USD">USD</option>
                        <option value="EUR">EUR</option>
                        <option value="GBP">GBP</option>
                        <option value="JPY">JPY</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="to_currency">To Currency</label>
                    <select class="form-control" id="to_currency">
                        <option value="EUR">EUR</option>
                        <option value="USD">USD</option>
                        <option value="TRY">USD</option>
                        <option value="GBP">GBP</option>
                        <option value="JPY">JPY</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="amount">Amount</label>
                    <input
                            type="number"
                            class="form-control"
                            id="amount"
                            placeholder="Enter amount"
                    />
                </div>
                <button type="submit" class="btn btn-primary">Convert</button>
            </form>
        </div>
    </div>

    <!-- Currency Exchange Result -->
    <div class="row mt-4">
        <div class="col-md-6 offset-md-3">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Conversion Result</h5>
                    <p class="card-text">1 USD = 0.85 EUR</p>
                    <p class="card-text">0.85 EUR = 1.00 USD</p>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
