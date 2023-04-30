<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
