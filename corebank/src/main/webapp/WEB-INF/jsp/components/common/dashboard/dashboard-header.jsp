<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Navbar -->
<header class="dashboard-page-header mb-3 bg-primary">
    <div class="container d-flex align-items-center">
        <div class="company-name"><a href="/app/dashboard">CoreBank 7/24</a></div>
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
<!-- End of Navbar -->