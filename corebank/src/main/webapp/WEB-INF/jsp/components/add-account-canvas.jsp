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
