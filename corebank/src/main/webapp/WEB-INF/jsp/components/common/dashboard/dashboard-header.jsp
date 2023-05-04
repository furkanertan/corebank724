<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Navbar -->
<header class="dashboard-page-header mb-3 bg-primary">
    <div class="container d-flex align-items-center">
        <div class="company-name"><a href="/app/dashboard">CoreBank 7/24</a></div>
        <nav class="navigation">
            <li><a href="/app/accounts">Accounts</a></li>
            <li><a href="/app/moneytransfer">Money Transfers</a></li>
            <li><a href="/app/currencyexchange">Currency Exchange</a></li>
            <li><a href="/app/transactions">Transactions</a></li>
            <li><a href="/app/loancalculator">Loan Calculator</a></li>
        </nav>

        <div class="display-name ms-auto dropdown">
            <a class="btn btn-secondary dropdown-toggle" style="background-color: transparent;border-color: white" href="#" role="button"
               id="dropdownMenuLink"
               data-bs-toggle="dropdown" aria-expanded="false">
                <i class="fa fa-circle text-success me-2"></i>Welcome,
                <span>
                <c:out value="${sessionScope.user.firstName}"/>
                <c:out value="${sessionScope.user.lastName}"/>
              </span>
            </a>

            <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                <li class="dropdown-li">
                    <a href="/app/profile" class="btn btn-sm btn-outline-light w-100"
                       style="background-color: white; color: black;"
                       onmouseover="this.style.backgroundColor = '#E5E4E4FF'"
                       onMouseOut="this.style.backgroundColor = '#fff'">
                        <i class="fa fa-user mr-2"></i> Profile
                    </a>
                </li>
                <li class="dropdown-li d-flex align-items-center">
                    <a href="/app/help" class="btn btn-sm btn-outline-light w-100"
                       style="background-color: white; color: black;"
                       onmouseover="this.style.backgroundColor = '#E5E4E4FF'"
                       onMouseOut="this.style.backgroundColor = '#fff'">
                        <i class="fa fa-question mr-2"></i> Help
                    </a>
                </li>
                <li class="dropdown-li d-flex align-items-center">
                    <a href="/logout" class="btn btn-sm btn-outline-light w-100"
                       style="background-color: white; color: black;"
                       onmouseover="this.style.backgroundColor = '#E5E4E4FF'"
                       onMouseOut="this.style.backgroundColor = '#fff'">
                        <i class="fa fa-sign-out-alt mr-2"></i> Logout
                    </a>
                </li>
            </ul>

        </div>
    </div>
</header>
<!-- End of Navbar -->