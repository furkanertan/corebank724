package com.application.corebank.controller.application;

import com.application.corebank.domain.User;
import com.application.corebank.dto.AccountDto;
import com.application.corebank.dto.CurrencyDto;
import com.application.corebank.dto.CurrencyRatesDto;
import com.application.corebank.dto.TransactionHistoryDto;
import com.application.corebank.service.AccountService;
import com.application.corebank.service.CurrencyRatesService;
import com.application.corebank.service.CurrencyService;
import com.application.corebank.service.TransactionHistoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("/app")
public class AppController {

    private AccountService accountService;
    private TransactionHistoryService transactionHistoryService;
    private CurrencyRatesService currencyRatesService;
    private CurrencyService currencyService;

    @GetMapping("/dashboard")
    public ModelAndView getDashboard(HttpSession session) {
        ModelAndView dashboardPage = new ModelAndView("dashboard");

        //Logged user information is stored in session
        User user = (User) session.getAttribute("user");

        //If user is not logged in, redirect to login page
        if (user == null) {
            return new ModelAndView("redirect:/login");
        }

        //Get User Account Numbers
        List<AccountDto> userAccountList = accountService.getAllActiveAccountsByCustomerNo(user.getId());
        Integer numberOfUserAccounts = userAccountList.isEmpty() ? 0 : userAccountList.size();

        //Get User Account Numbers
        List<String> userAccountNumbers = userAccountList.stream().map(AccountDto::getAccountNumber).map(String::valueOf).collect(Collectors.toList());

        //Get List of Transactions
        List<TransactionHistoryDto> transactions = transactionHistoryService.getLast5Transactions(userAccountNumbers);

        //Get List of Currency Rates
        List<CurrencyRatesDto> currencyRates = currencyRatesService.getCurrencyRatesByToCurrency("PLN");

        //Set Objects to dashboardPage
        dashboardPage.addObject("accountsCount", numberOfUserAccounts);
        dashboardPage.addObject("transactions", transactions);
        dashboardPage.addObject("currencyRates", currencyRates);

        return dashboardPage;
    }

    @GetMapping("/accounts")
    public ModelAndView getAccountsPage(HttpSession session) {
        ModelAndView accountsPage = new ModelAndView("accounts");

        //Logged user information is stored in session
        User user = (User) session.getAttribute("user");

        //If user is not logged in, redirect to login page
        if (user == null) {
            return new ModelAndView("redirect:/login");
        }

        //Get user accounts by user id
        List<AccountDto> userAccounts = accountService.getAllActiveAccountsByCustomerNo(user.getId());
        log.info("AccountsPage userAccounts: {}", userAccounts);

        //Get currency types
        List<CurrencyDto> currencies = currencyService.getAllCurrencies();

        accountsPage.addObject("userAccounts", userAccounts);
        accountsPage.addObject("currencies", currencies);
        return accountsPage;
    }

    @GetMapping("/moneytransfer")
    public ModelAndView getMoneyTransferPage(HttpSession session) {
        ModelAndView moneyTransferPage = new ModelAndView("moneytransfer");

        //Logged user information is stored in session
        User user = (User) session.getAttribute("user");

        //If user is not logged in, redirect to login page
        if (user == null) {
            return new ModelAndView("redirect:/login");
        }

        //Get user accounts by user id
        List<AccountDto> userAccounts = accountService.getAllActiveAccountsByCustomerNo(user.getId());
        log.info("MoneyTransferPage userAccounts: {}", userAccounts);

        moneyTransferPage.addObject("userAccounts", userAccounts);

        return moneyTransferPage;
    }

    @GetMapping("/currencyexchange")
    public ModelAndView getCurrencyExchangePage(HttpSession session) {
        ModelAndView currencyExchangePage = new ModelAndView("currencyexchange");

        //Logged user information is stored in session
        User user = (User) session.getAttribute("user");

        //If user is not logged in, redirect to login page
        if (user == null) {
            return new ModelAndView("redirect:/login");
        }

        return currencyExchangePage;
    }

    @GetMapping("/transactions")
    public ModelAndView getTransactionsPage(HttpSession session) {
        ModelAndView transactionsPage = new ModelAndView("transactions");

        //Logged user information is stored in session
        User user = (User) session.getAttribute("user");

        //If user is not logged in, redirect to login page
        if (user == null) {
            return new ModelAndView("redirect:/login");
        }

        return transactionsPage;
    }


    @GetMapping("/loancalculator")
    public ModelAndView getLoanCalculatorPage(HttpSession session) {
        ModelAndView loanCalculatorPage = new ModelAndView("loancalculator");

        //Logged user information is stored in session
        User user = (User) session.getAttribute("user");

        //If user is not logged in, redirect to login page
        if (user == null) {
            return new ModelAndView("redirect:/login");
        }

        return loanCalculatorPage;
    }
}
