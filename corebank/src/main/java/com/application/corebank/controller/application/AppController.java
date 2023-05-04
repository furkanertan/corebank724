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

        //Set dashboard page values
        setCardValues(userAccountList, dashboardPage);
        setListOfTransactions(userAccountList, dashboardPage);
        setCurrencyRates(dashboardPage);

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

        setUserAccounts(user, accountsPage);
        setCurrencies(accountsPage);

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

        setUserAccounts(user, moneyTransferPage);
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

        List<TransactionHistoryDto> userTransactions;

        //Get all active accounts by user id
        List<AccountDto> userAccounts = accountService.getAllActiveAccountsByCustomerNo(user.getId());
        if (userAccounts.isEmpty()) {
            //Set Objects to transactionsPage
            transactionsPage.addObject("userTransactions", null);
            return transactionsPage;
        }

        //Get user account numbers
        List<String> userAccountNumbers = userAccounts.stream().map(AccountDto::getAccountNumber).map(String::valueOf).collect(Collectors.toList());

        //Get User Transactions
        userTransactions = transactionHistoryService.getAllTransactions(userAccountNumbers);
        transactionsPage.addObject("userTransactions", userTransactions);

        setUserAccounts(user, transactionsPage);
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

    private void setCardValues(List<AccountDto> userAccountList, ModelAndView page) {
        Integer numberOfUserAccounts = userAccountList.isEmpty() ? 0 : userAccountList.size();
        Double totalDeposits = userAccountList.stream().filter(accountDto -> "PLN".equals(accountDto.getCurrencyType()) & "Deposit".equals(accountDto.getAccountType())).mapToDouble(AccountDto::getBalance).sum();
        log.info("Total Deposits: {}", totalDeposits);
        Double totalSavings = userAccountList.stream().filter(accountDto -> "PLN".equals(accountDto.getCurrencyType()) & "Saving".equals(accountDto.getAccountType())).mapToDouble(AccountDto::getBalance).sum();
        log.info("Total Savings: {}", totalSavings);
        Double totalChecks = userAccountList.stream().filter(accountDto -> "PLN".equals(accountDto.getCurrencyType()) & "Check".equals(accountDto.getAccountType())).mapToDouble(AccountDto::getBalance).sum();
        log.info("Total Checks: {}", totalChecks);

        page.addObject("accountsCount", numberOfUserAccounts);
        page.addObject("totalDeposits", totalDeposits);
        page.addObject("totalSavings", totalSavings);
        page.addObject("totalChecks", totalChecks);
    }

    private void setListOfTransactions(List<AccountDto> userAccountList, ModelAndView page) {
        List<String> userAccountNumbers = userAccountList.stream().map(AccountDto::getAccountNumber).map(String::valueOf).collect(Collectors.toList());
        List<TransactionHistoryDto> transactions = transactionHistoryService.getLast5Transactions(userAccountNumbers);
        page.addObject("transactions", transactions);
    }

    private void setCurrencyRates(ModelAndView page) {
        List<CurrencyRatesDto> currencyRates = currencyRatesService.getCurrencyRatesByToCurrency("PLN");
        page.addObject("currencyRates", currencyRates);
    }

    private void setUserAccounts(User user, ModelAndView page) {
        List<AccountDto> userAccounts = accountService.getAllActiveAccountsByCustomerNo(user.getId());
        log.info("AccountsPage userAccounts: {}", userAccounts);
        page.addObject("userAccounts", userAccounts);
    }

    private void setCurrencies(ModelAndView page) {
        List<CurrencyDto> currencies = currencyService.getAllCurrencies();
        page.addObject("currencies", currencies);
    }
}
