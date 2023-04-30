<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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


        <!-- Transfer Form Card -->
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
        <!-- End of Transfer Form Card -->

        <!-- Payment Card -->
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

        <!-- Deposit Form Card -->
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
        <!-- End of Form Deposit Card -->

        <!-- Withdraw Form Card -->
        <div class="card withdraw-card">
            <div class="card-body">
                <form action="" class="deposit-form">
                    <div class="form-group mb-2">
                        <label for="">Withdrawal Amount</label>
                        <input
                                type="text"
                                name="withdrawal_amount"
                                placeholder="Enter Withdrawal Amount:"
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
        <!-- End of Withdraw Form Card -->

    </div>
    <!-- End of Offcanvas Body -->
</div>
<!-- End of Fast Transaction Page (Left)-->
