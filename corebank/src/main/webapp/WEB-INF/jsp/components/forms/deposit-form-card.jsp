<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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