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

        //Get user accounts by user id
        List<AccountDto> userAccounts = accountService.getAllActiveAccountsByCustomerNo(user.getId());
        log.info("AccountsPage userAccounts: {}", userAccounts);

        //Get currency types
        List<CurrencyDto> currencies = currencyService.getAllCurrencies();

        accountsPage.addObject("userAccounts", userAccounts);
        accountsPage.addObject("currencies", currencies);

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

        //Generate account number
        Integer accountNumber = AccountNumberGenerator.generateAccountNumber();

        //Create account
        AccountDto accountDto = accountAssembler.toAccountDto(accountName, accountType, accountCurrencyType, accountNumber, user.getId());
        accountService.createAccount(accountDto);

        accountsPage.addObject("success", "Account created successfully!");
        return accountsPage;
    }

    @PostMapping("/deleteAccount")
    public ModelAndView deleteAccount(@RequestParam("accountNumber") String accountNumber,
                                      HttpSession session) {

        ModelAndView accountsPage = new ModelAndView("accounts");
        log.info("Deleting account...");

        //Get user from session
        User user = (User) session.getAttribute("user");

        //Get user accounts by user id
        List<AccountDto> userAccounts = accountService.getAllActiveAccountsByCustomerNo(user.getId());
        log.info("AccountsPage userAccounts: {}", userAccounts);

        //Get currency types
        List<CurrencyDto> currencies = currencyService.getAllCurrencies();

        accountsPage.addObject("userAccounts", userAccounts);
        accountsPage.addObject("currencies", currencies);

        accountService.deleteAccount(Integer.valueOf(accountNumber));
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
}
