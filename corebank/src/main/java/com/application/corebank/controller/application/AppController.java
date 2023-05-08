package com.application.corebank.controller.application;

import com.application.corebank.domain.User;
import com.application.corebank.dto.*;
import com.application.corebank.exception.AccountException;
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
    public ModelAndView getDashboard(HttpSession session) throws AccountException {
        ModelAndView dashboardPage = new ModelAndView("dashboard");

        //Logged user information is stored in session
        User user = (User) session.getAttribute("user");

        //If user is not logged in, redirect to login page
        if (user == null) {
            return new ModelAndView("redirect:/login");
        }

        List<AccountDto> userAccountList;

        //If user is admin get all accounts
        if (user.getIsAdmin() == 1) {
            userAccountList = accountService.getAllAccounts();
        } else {
            //Get all active accounts by customer no
            userAccountList = accountService.getAllActiveAccountsByCustomerNo(user.getId());
        }

        //Set dashboard page values
        setCardValues(userAccountList, dashboardPage);
        setListOfTransactions(userAccountList, dashboardPage);
        setCurrencyRates(dashboardPage);

        return dashboardPage;
    }

    @GetMapping("/accountBalances")
    public AccountBalanceDto getAccountBalancesByType(HttpSession session) {
        AccountBalanceDto accountBalanceDto = new AccountBalanceDto();
        log.info("Account Balance by type");

        //Logged user information is stored in session
        User user = (User) session.getAttribute("user");

        accountBalanceDto.setChecksBalance(accountService.getTotalBalanceByAccountType("Check", user.getId()));
        accountBalanceDto.setSavingsBalance(accountService.getTotalBalanceByAccountType("Saving", user.getId()));
        accountBalanceDto.setDepositsBalance(accountService.getTotalBalanceByAccountType("Deposit", user.getId()));

        log.info("Account Balance by type: {}", accountBalanceDto);

        return accountBalanceDto;
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

        //If user is admin get all accounts
        if (user.getIsAdmin() == 1) {
            setAllAccounts(accountsPage);
        } else {
            //Get all active accounts by customer no
            setUserAccounts(user, accountsPage);
        }

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

        //If user is admin get all accounts
        if (user.getIsAdmin() == 1) {
            setAllAccounts(moneyTransferPage);
        } else {
            //Get all active accounts by customer no
            setUserAccounts(user, moneyTransferPage);
        }

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

        if (user.getIsAdmin() == 1) {
            userTransactions = transactionHistoryService.getAllTransactions();
            setAllAccounts(transactionsPage);

        } else {
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
            userTransactions = transactionHistoryService.getAllTransactionsByAccountNumber(userAccountNumbers);
            setUserAccounts(user, transactionsPage);
        }

        transactionsPage.addObject("userTransactions", userTransactions);

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

    @GetMapping("/profile")
    public ModelAndView getProfilePage(HttpSession session) {
        ModelAndView profilePage = new ModelAndView("profile");

        //Logged user information is stored in session
        User user = (User) session.getAttribute("user");

        //If user is not logged in, redirect to login page
        if (user == null) {
            return new ModelAndView("redirect:/login");
        }

        profilePage.addObject("user", user);
        return profilePage;
    }

    @GetMapping("/help")
    public ModelAndView getHelpPage(HttpSession session) {
        ModelAndView helpPage = new ModelAndView("help");

        //Logged user information is stored in session
        User user = (User) session.getAttribute("user");

        //If user is not logged in, redirect to login page
        if (user == null) {
            return new ModelAndView("redirect:/login");
        }

        return helpPage;
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

    private void setAllAccounts(ModelAndView page) {
        List<AccountDto> userAccounts = accountService.getAllAccounts();
        log.info("AccountsPage userAccounts: {}", userAccounts);
        page.addObject("userAccounts", userAccounts);
    }

    private void setCurrencies(ModelAndView page) {
        List<CurrencyDto> currencies = currencyService.getAllCurrencies();
        page.addObject("currencies", currencies);
    }
}
