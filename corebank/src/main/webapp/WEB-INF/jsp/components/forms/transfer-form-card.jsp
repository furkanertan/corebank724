<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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