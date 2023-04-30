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
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <title>Money Transfer</title>
</head>
<body>
<!-- Navigation bar import -->
<c:import url="components/common/dashboard/dashboard-header.jsp"/>
<!-- End of Navigation bar import -->

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
