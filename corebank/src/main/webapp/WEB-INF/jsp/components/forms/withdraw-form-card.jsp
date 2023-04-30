<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
