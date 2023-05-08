package com.application.corebank.controller;

import com.application.corebank.domain.User;
import com.application.corebank.dto.AccountDto;
import com.application.corebank.dto.TransactionHistoryDto;
import com.application.corebank.service.AccountService;
import com.application.corebank.service.TransactionHistoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("/transaction")
@AllArgsConstructor
public class TransactionController {

    private TransactionHistoryService transactionHistoryService;
    private AccountService accountService;

    @PostMapping("/makeTransaction")
    public ModelAndView makeTransaction(@RequestParam("account") Integer account,
                                        @RequestParam("amount") Double amount,
                                        @RequestParam("message") String message,
                                        HttpSession session) {
        log.info("Making a new transaction...");
        ModelAndView transactionsPage = new ModelAndView("transactions");

        //Get user from session
        User user = (User) session.getAttribute("user");

        //set user transactions and accounts to page view
        setUserTransactions(user, transactionsPage);
        setUserAccounts(user, transactionsPage);

        //check if accountNumber is valid
        if (account == null) {
            log.error("Invalid account number!");
            transactionsPage.addObject("errorTransactions", "Invalid account number!");
            return transactionsPage;
        }

        //check if amount is valid
        if (amount <= 0) {
            log.error("Invalid amount!");
            transactionsPage.addObject("errorTransactions", "Invalid amount!");
            return transactionsPage;
        }

        //check if message is valid
        if (message.isEmpty()) {
            log.error("Invalid message!");
            transactionsPage.addObject("errorTransactions", "Invalid message!");
            return transactionsPage;
        }

        //create transaction history
        transactionHistoryService.createTransactionHistory(String.valueOf(account), "PAYMENT", message, amount, "INCOMING");

        //update account balance
        accountService.updateAccountBalance(account, amount, false);

        //set user transactions to page view
        setUserTransactions(user, transactionsPage);

        transactionsPage.addObject("successTransactions", "Transaction completed successfully!");
        return transactionsPage;
    }

    private void setUserTransactions(User user, ModelAndView transactionsPage){
        List<AccountDto> userAccounts = accountService.getAllActiveAccountsByCustomerNo(user.getId());
        List<String> userAccountNumbers = userAccounts.stream().map(AccountDto::getAccountNumber).map(String::valueOf).collect(Collectors.toList());
        List<TransactionHistoryDto> userTransactions = transactionHistoryService.getAllTransactionsByAccountNumber(userAccountNumbers);
        transactionsPage.addObject("userTransactions", userTransactions);
    }

    private void setUserAccounts(User user, ModelAndView page) {
        List<AccountDto> userAccounts = accountService.getAllActiveAccountsByCustomerNo(user.getId());
        log.info("AccountsPage userAccounts: {}", userAccounts);
        page.addObject("userAccounts", userAccounts);
    }
}
