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
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <title>Money Transfer</title>
</head>
<body>
<header class="dashboard-page-header mb-3 bg-primary">
    <div class="container d-flex align-items-center">
        <div class="company-name">CoreBank 7/24</div>
        <nav class="navigation">
            <li><a href="dashboard.html">Dashboard</a></li>
            <li><a href="">Accounts</a></li>
            <li><a href="moneytransfer.html">Money Transfers</a></li>
            <li><a href="currencyexchange.html">Currency Exchange</a></li>
            <li><a href="">Transactions</a></li>
        </nav>

        <div class="display-name ms-auto">
            <i class="fa fa-circle text-success me-2"> </i> Welcome,
            <span>John Doe</span>
        </div>

        <a href="" class="btn btn-sm btn-outline-light ms-3">
            <i class="fa fa-sign-out-alt"></i> Logout
        </a>
    </div>
</header>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header text-center">
                    <h4>Money Transfer</h4>
                </div>
                <div class="card-body">
                    <form>
                        <div class="form-group">
                            <label for="sender">Sender</label>
                            <input
                                    type="text"
                                    class="form-control"
                                    id="sender"
                                    placeholder="Enter sender's name"
                            />
                        </div>
                        <div class="form-group">
                            <label for="receiver">Receiver</label>
                            <input
                                    type="text"
                                    class="form-control"
                                    id="receiver"
                                    placeholder="Enter receiver's name"
                            />
                        </div>
                        <div class="form-group">
                            <label for="amount">Amount</label>
                            <div class="input-group">
                                <div class="input-group-prepend">
                      <span class="input-group-text"
                      ><i class="fas fa-dollar-sign"></i
                      ></span>
                                </div>
                                <input
                                        type="number"
                                        class="form-control"
                                        id="amount"
                                        placeholder="Enter amount"
                                />
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary btn-block">
                            Transfer
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
