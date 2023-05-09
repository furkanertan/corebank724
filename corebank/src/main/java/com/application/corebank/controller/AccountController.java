package com.application.corebank.controller;

import com.application.corebank.assembler.AccountAssembler;
import com.application.corebank.domain.User;
import com.application.corebank.dto.AccountDto;
import com.application.corebank.dto.CurrencyDto;
import com.application.corebank.service.AccountService;
import com.application.corebank.service.CurrencyService;
import com.application.corebank.service.UserService;
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
    private UserService userService;

    @PostMapping("/createAccount")
    public ModelAndView createAccount(@RequestParam("accountName") String accountName,
                                      @RequestParam("accountType") String accountType,
                                      @RequestParam("accountCurrencyType") String accountCurrencyType,
                                      @RequestParam("userSelect") Long userSelect,
                                      HttpSession session
    ) {
        ModelAndView accountsPage = new ModelAndView("accounts");
        log.info("Creating a new account...");

        //Get user from session
        User user = (User) session.getAttribute("user");

        //If user is admin user get all accounts and transactions, else get user accounts and transactions
        if (user.getIsAdmin() == 1) {
            setAllAccountsToPageView(accountsPage);
        } else {
            setUserAccountsToPageView(accountsPage, user);
        }

        //Get currency types and send to view
        setCurrencyTypesToPageView(accountsPage);

        //Validations for account
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

        //Check if user is selected
        if (!accountValidation.isValidUser(userSelect)) {
            log.error("Invalid user!");
            accountsPage.addObject("error", "Invalid user selected!");
            return accountsPage;
        }

        User selectedUser = userService.findById(userSelect);

        //Create account and send success message to view
        createAccount(accountName, accountType, accountCurrencyType, selectedUser);
        accountsPage.addObject("success", "Account created successfully!");

        //If user is admin user get all updated accounts to view, else get user accounts to view
        if (user.getIsAdmin() == 1) {
            setAllAccountsToPageView(accountsPage);
        } else {
            setUserAccountsToPageView(accountsPage, user);
        }

        return accountsPage;
    }

    @PostMapping("/deleteAccount")
    public ModelAndView deleteAccount(@RequestParam("accountNumber") String accountNumber,
                                      HttpSession session) {
        ModelAndView accountsPage = new ModelAndView("accounts");
        log.info("Deleting account...");

        //Get user from session
        User user = (User) session.getAttribute("user");

        //Delete given account
        accountService.deleteAccount(Integer.valueOf(accountNumber));

        //If user is admin user get all updated accounts after delete to view, else get user accounts to view
        if (user.getIsAdmin() == 1) {
            setAllAccountsToPageView(accountsPage);
        } else {
            setUserAccountsToPageView(accountsPage, user);
        }

        //Get currency types
        setCurrencyTypesToPageView(accountsPage);

        //Return success message to view
        accountsPage.addObject("success", "Account deleted successfully!");
        return accountsPage;
    }

    @PostMapping("/updateAccount")
    public ModelAndView updateAccount(@RequestParam("updAccountNumber") String updAccountNumber,
                                      @RequestParam("updAccountName") String updAccountName,
                                      @RequestParam("updAccountType") String updAccountType,
                                      HttpSession session) {
        ModelAndView accountsPage = new ModelAndView("accounts");
        log.info("Updating account...");

        //Get user from session
        User user = (User) session.getAttribute("user");

        //Validations for account
        //Check if accountName is valid
        if (!accountValidation.isValidAccountName(updAccountName)) {
            log.error("Invalid account name!");
            accountsPage.addObject("error", "Invalid account name!");
            //Updated accounts sent to view
            setUserAccountsToPageView(accountsPage, user);
            //Get currency types
            setCurrencyTypesToPageView(accountsPage);
            return accountsPage;
        }

        //Check if accountType is valid
        if (!accountValidation.isValidAccountType(updAccountType)) {
            log.error("Invalid account type!");
            accountsPage.addObject("error", "Invalid account type!");
            //Updated accounts sent to view
            setUserAccountsToPageView(accountsPage, user);
            //Get currency types
            setCurrencyTypesToPageView(accountsPage);
            return accountsPage;
        }

        //Get updated account by its account number from database and update it with new values
        AccountDto accountDto = accountService.getAccountByAccountNumber(Integer.valueOf(updAccountNumber));
        accountAssembler.updateAccount(accountDto, updAccountName, updAccountType);

        //Save updated account
        accountService.updateAccount(accountDto);

        //If user is admin user get all updated accounts after update to view, else get user accounts to view
        if (user.getIsAdmin() == 1) {
            setAllAccountsToPageView(accountsPage);
        } else {
            setUserAccountsToPageView(accountsPage, user);
        }

        //Get currency types
        setCurrencyTypesToPageView(accountsPage);

        //Return success message to view
        accountsPage.addObject("success", "Account updated successfully!");
        return accountsPage;
    }

    @GetMapping("/getAccountCurrencyType")
    public String getAccountCurrencyType(@RequestParam("accountNumber") String accountNumber) {
        log.info("Getting account currency type...");
        AccountDto accountDto = accountService.getAccountByAccountNumber(Integer.valueOf(accountNumber));
        return accountDto.getCurrencyType();
    }


    //For Admin Panel
    @GetMapping("/getAllAccounts")
    List<AccountDto> getAllAccounts() {
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

    private void setUserAccountsToPageView(ModelAndView accountsPage, User user) {
        //Get user accounts by user id
        List<AccountDto> userAccounts = accountService.getAllActiveAccountsByCustomerNo(user.getId());
        log.info("AccountsPage setAccountsToPageView: {}", userAccounts);

        accountsPage.addObject("userAccounts", userAccounts);
    }

    private void setAllAccountsToPageView(ModelAndView accountsPage) {
        //Get all accounts
        List<AccountDto> allAccounts = accountService.getAllAccounts();
        log.info("AccountsPage setAccountsToPageView: {}", allAccounts);

        accountsPage.addObject("userAccounts", allAccounts);
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
