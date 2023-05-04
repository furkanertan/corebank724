package com.application.corebank.controller;

import com.application.corebank.assembler.AccountAssembler;
import com.application.corebank.domain.User;
import com.application.corebank.dto.AccountDto;
import com.application.corebank.dto.CurrencyDto;
import com.application.corebank.exception.AccountException;
import com.application.corebank.service.AccountService;
import com.application.corebank.service.CurrencyService;
import com.application.corebank.util.AccountNumberGenerator;
import com.application.corebank.validation.AccountValidation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/account")
@AllArgsConstructor
public class AccountController {

    private AccountService accountService;
    private AccountValidation accountValidation;
    private AccountAssembler accountAssembler;
    private CurrencyService currencyService;

    @PostMapping("/createAccount")
    public ModelAndView createAccount(@RequestParam("accountName") String accountName,
                                      @RequestParam("accountType") String accountType,
                                      @RequestParam("accountCurrencyType") String accountCurrencyType,
                                      HttpSession session
    ) {
        ModelAndView accountsPage = new ModelAndView("accounts");
        log.info("Creating a new account...");

        //Get user from session
        User user = (User) session.getAttribute("user");

        setAccountsToPageView(accountsPage, user);
        setCurrencyTypesToPageView(accountsPage);

        //Check if accountName is valid
        if (!accountValidation.isValidAccountName(accountName)) {
            log.error("Invalid account name!");
            accountsPage.addObject("error", "Invalid account name!");
            return accountsPage;
        }

        //Check if accountCurrencyType is valid
        if (!accountValidation.isValidAccountCurrencyType(accountCurrencyType)) {
            log.error("Invalid account currency type!");
            accountsPage.addObject("error", "Invalid account currency type!");
            return accountsPage;
        }

        //Check if accountType is valid
        if (!accountValidation.isValidAccountType(accountType)) {
            log.error("Invalid account type!");
            accountsPage.addObject("error", "Invalid account type!");
            return accountsPage;
        }

        //Check if accountName is unique
        if (!accountValidation.isValidUser(user.getId())) {
            log.error("Invalid user!");
            accountsPage.addObject("error", "Invalid user!");
            return accountsPage;
        }

        //Create account
        createAccount(accountName, accountType, accountCurrencyType, user);

        accountsPage.addObject("success", "Account created successfully!");
        //Updated accounts sent to view
        setAccountsToPageView(accountsPage, user);
        return accountsPage;
    }

    @PostMapping("/deleteAccount")
    public ModelAndView deleteAccount(@RequestParam("accountNumber") String accountNumber,
                                      HttpSession session) {
        ModelAndView accountsPage = new ModelAndView("accounts");
        log.info("Deleting account...");

        //Get user from session
        User user = (User) session.getAttribute("user");

        accountService.deleteAccount(Integer.valueOf(accountNumber));

        //Updated accounts sent to view
        setAccountsToPageView(accountsPage, user);

        //Get currency types
        setCurrencyTypesToPageView(accountsPage);

        accountsPage.addObject("success", "Account deleted successfully!");
        return accountsPage;
    }

    //For Admin Panel
    @GetMapping("/getAllAccounts")
    List<AccountDto> getAllAccounts() throws AccountException {
        log.info("Getting all accounts");

        return accountService.getAllAccounts();
    }

    @GetMapping("/getAllActiveAccountsByCustomerNo")
    List<AccountDto> getAllActiveAccountsByCustomerNo(@RequestParam Long userId) {
        log.info("Getting all active accounts by logged user: {}", userId);

        return accountService.getAllActiveAccountsByCustomerNo(userId);
    }

    @GetMapping("/getAllActiveAccountsByCustomerNoAndCurrencyType")
    List<AccountDto> getAllActiveAccountsByCustomerNoAndCurrencyType(@RequestParam Long userId,
                                                                     @RequestParam String currencyType) {
        log.info("Getting all active accounts by logged user: {} and currency type: {}", userId, currencyType);

        return accountService.getAccountsByUserIdAndCurrencyType(userId, currencyType);
    }

    private void setAccountsToPageView(ModelAndView accountsPage, User user) {
        //Get user accounts by user id
        List<AccountDto> userAccounts = accountService.getAllActiveAccountsByCustomerNo(user.getId());
        log.info("AccountsPage setAccountsToPageView: {}", userAccounts);

        accountsPage.addObject("userAccounts", userAccounts);
    }

    private void setCurrencyTypesToPageView(ModelAndView accountsPage) {
        //Get currency types
        List<CurrencyDto> currencies = currencyService.getAllCurrencies();
        accountsPage.addObject("currencies", currencies);
    }

    private void createAccount(String accountName, String accountType, String accountCurrencyType, User user) {
        //Generate account number
        Integer accountNumber = AccountNumberGenerator.generateAccountNumber();

        //Create account
        AccountDto accountDto = accountAssembler.toAccountDto(accountName, accountType, accountCurrencyType, accountNumber, user.getId());
        accountService.createAccount(accountDto);
    }
}
