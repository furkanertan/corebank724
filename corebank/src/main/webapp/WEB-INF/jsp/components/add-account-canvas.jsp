<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
                <form action="/account/createAccount" class="add-account-form">

                    <!-- Account Name -->
                    <div class="form-group mb-3">
                        <label for="">Account Name</label>
                        <input
                                type="text"
                                name="accountName"
                                placeholder="Enter Account Name:"
                                class="form-control"
                        />
                    </div>
                    <!-- End of Account Name -->

                    <!-- Select Account Type -->
                    <div class="form-group mb-3">
                        <label for="">Select Account Type</label>
                        <select name="accountType" class="form-control" id="accountTypeId">
                            <option value="">-- Select Account Type--</option>
                            <option value="check">Check</option>
                            <option value="savings">Savings</option>
                            <option value="business">Business</option>
                        </select>
                    </div>
                    <!-- End of Select Account Type -->

                    <!-- Select Account Currency Type -->
                    <div class="form-group mb-3">
                        <label for="">Select Account Currency Type</label>
                        <select name="accountCurrencyType" class="form-control" id="accountCurrencyTypeId">
                            <option value="">-- Select Currency Type--</option>
                            <option value="EUR">EUR</option>
                            <option value="GBP">GBP</option>
                            <option value="PLN">PLN</option>
                            <option value="TRY">TRY</option>
                            <option value="USD">USD</option>
                        </select>
                    </div>
                    <!-- End of Select Account Type -->

                    <!-- Create Account Button -->
                    <div class="form-group mb-2">
                        <button id="addAccountBtn" class="btn btn-md add-account-btn">
                            Add Account
                        </button>
                    </div>
                    <!-- End of Create Account Button -->
                </form>
            </div>
            <!-- End of Card Body -->
        </div>
        <!-- End of Account Form-->
    </div>
</div>
<!-- End of Create/Add Account (Right) -->
