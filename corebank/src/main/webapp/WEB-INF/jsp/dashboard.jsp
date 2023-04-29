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
    <title>Login</title>
</head>

<body>
<header class="dashboard-page-header mb-3 bg-primary">
    <div class="container d-flex align-items-center">
        <div class="company-name"><a href="/dashboard">CoreBank 7/24</a></div>
        <nav class="navigation">
            <li><a href="">Accounts</a></li>
            <li><a href="/moneystransfer">Money Transfers</a></li>
            <li><a href="/currencyexchange">Currency Exchange</a></li>
            <li><a href="">Transactions</a></li>
            <li><a href="/loancalculator">Loan Calculator</a></li>
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

<!-- Add Charts -->
<div class="container">
    <div class="row my-2">
        <div class="col-lg-4 col-md-4 col-sm-12">
            <div class="card bg-danger text-white mb-3">
                <div class="card-body">
                    <h5 class="card-title">Total Balance</h5>
                    <p class="card-text h3">0</p>
                    <i class="fas fa-2x fa-coins"></i>
                </div>
            </div>
        </div>
        <div class="col-lg-4 col-md-4 col-sm-12">
            <div class="card bg-primary text-white mb-3">
                <div class="card-body">
                    <h5 class="card-title">Total Deposit</h5>
                    <p class="card-text h3">0</p>
                    <i class="fas fa-2x fa-sack-dollar"></i>
                </div>
            </div>
        </div>
        <div class="col-lg-4 col-md-4 col-sm-12">
            <div class="card bg-success text-white mb-3">
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

<div class="container d-flex">
    <div class="accordion accordion-flush" id="accordionFlushExample">
        <div class="accordion-item">
            <h2 class="accordion-header" id="flush-headingOne">
                <button
                        class="accordion-button collapsed"
                        type="button"
                        data-bs-toggle="collapse"
                        data-bs-target="#flush-collapseOne"
                        aria-expanded="false"
                        aria-controls="flush-collapseOne"
                >
                    Accordion Item #1
                </button>
            </h2>
            <div
                    id="flush-collapseOne"
                    class="accordion-collapse collapse"
                    aria-labelledby="flush-headingOne"
                    data-bs-parent="#accordionFlushExample"
            >
                <div class="accordion-body">
                    Placeholder content for this accordion, which is intended to
                    demonstrate the <code>.accordion-flush</code> class. This is the
                    first item's accordion body.
                </div>
            </div>
        </div>
        <div class="accordion-item">
            <h2 class="accordion-header" id="flush-headingTwo">
                <button
                        class="accordion-button collapsed"
                        type="button"
                        data-bs-toggle="collapse"
                        data-bs-target="#flush-collapseTwo"
                        aria-expanded="false"
                        aria-controls="flush-collapseTwo"
                >
                    Accordion Item #2
                </button>
            </h2>
            <div
                    id="flush-collapseTwo"
                    class="accordion-collapse collapse"
                    aria-labelledby="flush-headingTwo"
                    data-bs-parent="#accordionFlushExample"
            >
                <div class="accordion-body">
                    Placeholder content for this accordion, which is intended to
                    demonstrate the <code>.accordion-flush</code> class. This is the
                    second item's accordion body. Let's imagine this being filled with
                    some actual content.
                </div>
            </div>
        </div>
        <div class="accordion-item">
            <h2 class="accordion-header" id="flush-headingThree">
                <button
                        class="accordion-button collapsed"
                        type="button"
                        data-bs-toggle="collapse"
                        data-bs-target="#flush-collapseThree"
                        aria-expanded="false"
                        aria-controls="flush-collapseThree"
                >
                    Accordion Item #3
                </button>
            </h2>
            <div
                    id="flush-collapseThree"
                    class="accordion-collapse collapse"
                    aria-labelledby="flush-headingThree"
                    data-bs-parent="#accordionFlushExample"
            >
                <div class="accordion-body">
                    Placeholder content for this accordion, which is intended to
                    demonstrate the <code>.accordion-flush</code> class. This is the
                    third item's accordion body. Nothing more exciting happening here
                    in terms of content, but just filling up the space to make it
                    look, at least at first glance, a bit more representative of how
                    this would look in a real-world application.
                </div>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <div class="card no-accounts-card">
        <div class="card-body">
            <div class="card-title">
                <h2><i class="fas fa-ban text-danger"></i> No Accounts Found</h2>
                <div class="card-text">
                    You have no accounts yet. <br/>
                    Click the button below to create a new account.
                </div>
                <br/>
                <button
                        id="add-account-btn"
                        class="btn btn-primary btn-lg shadow"
                        type="button"
                        data-bs-toggle="offcanvas"
                        data-bs-target="#offcanvasRight"
                        aria-controls="offcanvasRight"
                >
                    <i class="fa-solid fa-square-plus"></i>
                    Create new account
                </button>
            </div>
        </div>
    </div>
</div>

<!-- Fast Transaction Page (Left) -->
<div
        class="offcanvas offcanvas-start"
        tabindex="-1"
        id="offcanvasExample"
        aria-labelledby="offcanvasExampleLabel"
>
    <div class="offcanvas-header">
        <h5 class="offcanvas-title" id="offcanvasExampleLabel">
            Fast Transaction Page
        </h5>
        <button
                type="button"
                class="btn-close text-reset"
                data-bs-dismiss="offcanvas"
                aria-label="Close"
        ></button>
    </div>

    <div class="offcanvas-body">
        <small class="card-text text-white">
            Choose the type of transaction you want to make
        </small>
        <select
                name="transact-type"
                class="form-control my-3"
                id="transact-type"
        >
            <option value="">-- Select Transaction Type --</option>
            <option value="payment">Payment</option>
            <option value="transfer">Transfer</option>
            <option value="deposit">Deposit</option>
            <option value="withdraw">Withdraw</option>
        </select>

        <div class="card payment-card">
            <div class="card-body">
                <form action="" class="payment-form">
                    <div class="form-group mb-2">
                        <label for="">Account Holder / Beneficiary</label>
                        <input
                                type="text"
                                name="beneficiary"
                                placeholder="Enter Account Holder / Beneficiary name:"
                                class="form-control"
                        />
                    </div>

                    <div class="form-group mb-2">
                        <label for="">Beneficiary Account Number</label>
                        <input
                                type="text"
                                name="account_number"
                                placeholder="Enter Beneficiary Account Number:"
                                class="form-control"
                        />
                    </div>

                    <div class="form-group mb-2">
                        <label for="">Select Account</label>
                        <select name="account_id" class="form-control mb-2" id="">
                            <option value="">-- Select Account --</option>
                        </select>
                    </div>

                    <div class="form-group mb-2">
                        <label for="">Reference</label>
                        <input
                                type="text"
                                name="reference"
                                placeholder="Enter Reference:"
                                class="form-control"
                        />
                    </div>

                    <div class="form-group mb-2">
                        <label for="">Payment Amount</label>
                        <input
                                type="text"
                                name="payment_amount"
                                placeholder="Enter Payment Amount:"
                                class="form-control"
                        />
                    </div>

                    <div class="form-group mb-2">
                        <button id="" class="btn btn-md payment-btn">Pay</button>
                    </div>
                </form>
            </div>
            <!-- End of Payment Body -->
        </div>
        <!-- End of Payment Card -->

        <div class="card transfer-card">
            <div class="card-body">
                <form action="" class="transfer-form">
                    <div class="form-group mb-2">
                        <label for="">Select Account</label>
                        <select name="account_id" class="form-control mb-2" id="">
                            <option value="">-- Select Account --</option>
                        </select>
                    </div>

                    <div class="form-group mb-2">
                        <label for="">Select Account</label>
                        <select name="account_id" class="form-control mb-2" id="">
                            <option value="">-- Select Account --</option>
                        </select>
                    </div>

                    <div class="form-group mb-2">
                        <label for="">Transfer Amount</label>
                        <input
                                type="text"
                                name="transfer_amount"
                                placeholder="Enter Transfer Amount:"
                                class="form-control"
                        />
                    </div>

                    <div class="form-group mb-2">
                        <button id="" class="btn btn-md transfer-btn">Transfer</button>
                    </div>
                </form>
            </div>
            <!-- End of Transfer Body -->
        </div>
        <!-- End of Transfer Card -->

        <!-- Deposit Card -->
        <div class="card deposit-card">
            <div class="card-body">
                <form action="" class="deposit-form">
                    <div class="form-group mb-2">
                        <label for="">Deposit Amount</label>
                        <input
                                type="text"
                                name="deposit_amount"
                                placeholder="Enter Deposit Amount:"
                                class="form-control"
                        />
                    </div>

                    <div class="form-group mb-2">
                        <label for="">Select Account</label>
                        <select name="account_id" class="form-control mb-2" id="">
                            <option value="">-- Select Account --</option>
                        </select>
                    </div>

                    <div class="form-group mb-2">
                        <button id="" class="btn btn-md deposit-btn">Deposit</button>
                    </div>
                </form>
                <!-- End of Deposit Form -->
            </div>
            <!-- End of Deposit Body -->
        </div>
        <!-- End of Deposit Card -->

        <!-- Withdraw Card -->
        <div class="card withdraw-card">
            <div class="card-body">
                <form action="" class="deposit-form">
                    <div class="form-group mb-2">
                        <label for="">Withrawal Amount</label>
                        <input
                                type="text"
                                name="withdrawal_amount"
                                placeholder="Enter Withrawal Amount:"
                                class="form-control"
                        />
                    </div>

                    <div class="form-group mb-2">
                        <label for="">Select Account</label>
                        <select name="account_id" class="form-control mb-2" id="">
                            <option value="">-- Select Account --</option>
                        </select>
                    </div>

                    <div class="form-group mb-2">
                        <button id="" class="btn btn-md withdraw-btn">Withdraw</button>
                    </div>
                </form>
                <!-- End of Withdraw Form -->
            </div>
            <!-- End of Withdraw Body -->
        </div>
        <!-- End of Withdraw Card -->
    </div>
    <!-- End of Offcanvas Body -->
</div>
<!-- End of Fast Transaction Page (Left)-->

<!-- Create/Add Account (Right) -->
<div
        class="offcanvas offcanvas-end"
        tabindex="-1"
        id="offcanvasRight"
        aria-labelledby="offcanvasRightLabel"
>
    <div class="offcanvas-header">
        <h5 id="offcanvasRightLabel" class="text-white">
            Create / Add an Account
        </h5>
        <button
                type="button"
                class="btn-close text-reset"
                data-bs-dismiss="offcanvas"
                aria-label="Close"
        ></button>
    </div>
    <div class="offcanvas-body">
        <!-- Card: Account Form-->
        <div class="card">
            <!-- Card Body -->
            <div class="card-body">
                <form action="" class="add-account-form">
                    <!-- Form Group -->
                    <div class="form-group mb-3">
                        <label for="">Account Name</label>
                        <input
                                type="text"
                                name="account_name"
                                placeholder="Enter Account Name:"
                                class="form-control"
                        />
                    </div>
                    <!-- End of Form Group -->

                    <!-- Form Group -->
                    <div class="form-group mb-3">
                        <label for="">Select Account Type</label>
                        <select name="account_type" class="form-control" id="">
                            <option value="">-- Select Account Type--</option>
                            <option value="check">Check</option>
                            <option value="savings">Savings</option>
                            <option value="business">Business</option>
                        </select>
                    </div>
                    <!-- End of Form Group -->

                    <!-- Form Group -->
                    <div class="form-group mb-2">
                        <button id="" class="btn btn-md add-account-btn">
                            Add Account
                        </button>
                    </div>
                    <!-- End of Form Group -->
                </form>
            </div>
            <!-- End of Card Body -->
        </div>
        <!-- End of Account Form-->
    </div>
</div>
<!-- End of Create/Add Account (Right) -->

<script src="js/main.js"></script>
</body>
</html>
