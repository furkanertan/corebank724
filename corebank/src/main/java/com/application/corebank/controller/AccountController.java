package com.application.corebank.controller;

import com.application.corebank.assembler.AccountAssembler;
import com.application.corebank.domain.User;
import com.application.corebank.dto.AccountDto;
import com.application.corebank.exception.AccountException;
import com.application.corebank.service.AccountService;
import com.application.corebank.util.AccountNumberGenerator;
import com.application.corebank.validation.AccountValidation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @PostMapping("/createAccount")
    public String createAccount(@RequestParam("accountName") String accountName,
                               @RequestParam("accountType") String accountType,
                               @RequestParam("accountCurrencyType") String accountCurrencyType,
                               HttpSession session,
                               RedirectAttributes redirectAttributes
    ) {
        log.info("Creating a new account...");

        User user = (User) session.getAttribute("user");

        Integer accountNumber = AccountNumberGenerator.generateAccountNumber();

        boolean isValidAccountInfo = accountValidation.isValidAccountInfo(accountName, accountType, accountCurrencyType, accountNumber, user.getId());

        if (!isValidAccountInfo) {
            log.error("Invalid account information given!");
            redirectAttributes.addFlashAttribute("error", "Invalid account information given!");
            return "redirect:/app/accounts";
        }

        AccountDto accountDto = accountAssembler.toAccountDto(accountName, accountType, accountCurrencyType, accountNumber, user.getId());
        accountService.createAccount(accountDto);

        redirectAttributes.addFlashAttribute("success", "Account Created Successfully!");
        return "redirect:/app/accounts";
    }

    @PostMapping("/deleteAccount")
    public String deleteAccount(@RequestParam("accountNumber") String accountNumber) {
        log.info("Deleting account...");
        accountService.deleteAccount(Integer.valueOf(accountNumber));

        return "redirect:/app/accounts";
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
