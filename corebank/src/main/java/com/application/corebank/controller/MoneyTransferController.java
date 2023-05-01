package com.application.corebank.controller;

import com.application.corebank.domain.User;
import com.application.corebank.dto.AccountDto;
import com.application.corebank.service.AccountService;
import com.application.corebank.service.MoneyTransferService;
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

@RestController
@Slf4j
@RequestMapping("/moneytransfer")
@AllArgsConstructor
public class MoneyTransferController {

    private MoneyTransferService moneyTransferService;
    private TransactionHistoryService transactionHistoryService;
    private AccountService accountService;

    private static final String TRANSACTION_TYPE = "TRANSFER";

    @PostMapping("/transfer")
    public ModelAndView transferMoney(@RequestParam("fromAccount") String fromAccountNumber,
                                      @RequestParam("toAccount") String toAccountNumber,
                                      @RequestParam("title") String title,
                                      @RequestParam("amount") Double amount,
                                      @RequestParam("commissionAmount") Double commissionAmount,
                                      @RequestParam("totalAmount") Double totalAmount,
                                      HttpSession session) {
        ModelAndView moneyTransferModelAndView = new ModelAndView("moneytransfer");

        //Add user to session
        User user = (User) session.getAttribute("user");
        List<AccountDto> userAccounts = accountService.getAllActiveAccountsByCustomerNo(user.getId());
        moneyTransferModelAndView.addObject("userAccounts", userAccounts);

        //If sender's account is null
        if (fromAccountNumber == null || fromAccountNumber.isEmpty()) {
            log.error("Sender's account is null!");
            moneyTransferModelAndView.addObject("errorMoneyTransfer", "Sender's account cannot be null!");
            return moneyTransferModelAndView;
        }

        //Check if sender's account has enough balance for totalAmount
        AccountDto senderAccountDto = accountService.getAccountByAccountNumber(Integer.valueOf(fromAccountNumber));
        if (senderAccountDto.getBalance() < totalAmount) {
            log.error("Sender's account does not have enough balance for this transaction!");
            moneyTransferModelAndView.addObject("errorMoneyTransfer", "Selected account does not have enough balance for this transaction!");
            return moneyTransferModelAndView;
        }

        //If recipient's account is null
        if (toAccountNumber == null || toAccountNumber.isEmpty()) {
            log.error("Recipient's account is null!");
            moneyTransferModelAndView.addObject("errorMoneyTransfer", "Recipient's account cannot be null!");
            return moneyTransferModelAndView;
        }

        //Check if recipient's account exists
        AccountDto recipientAccountDto = accountService.getAccountByAccountNumber(Integer.valueOf(toAccountNumber));
        if (recipientAccountDto == null || !"A".equals(recipientAccountDto.getStatus())) {
            log.error("Recipient's account does not exist or is not active");
            moneyTransferModelAndView.addObject("errorMoneyTransfer", "Recipient's account does not exist or is not active!");
            return moneyTransferModelAndView;
        }

        //If sender and recipient accounts are the same, do not transfer money
        if (fromAccountNumber.equals(toAccountNumber)) {
            log.error("Sender and recipient accounts are the same!");
            moneyTransferModelAndView.addObject("errorMoneyTransfer", "Sender and recipient accounts cannot be the same!");
            return moneyTransferModelAndView;
        }

        //If sender and recipient accounts have different currencies, do not transfer money
        if (!senderAccountDto.getCurrencyType().equals(recipientAccountDto.getCurrencyType())) {
            log.error("Sender and recipient accounts have different currencies!");
            moneyTransferModelAndView.addObject("errorMoneyTransfer", "Sender and recipient accounts have different currencies!");
            return moneyTransferModelAndView;
        }

        //Check if title is not empty
        if (title == null || title.isEmpty()) {
            log.error("Title is empty!");
            moneyTransferModelAndView.addObject("errorMoneyTransfer", "Title cannot be empty!");
            return moneyTransferModelAndView;
        }

        //If amount is less than 0 or amount is null, do not transfer money
        if (amount <= 0) {
            log.error("Amount cannot be equal or less than 0");
            moneyTransferModelAndView.addObject("errorMoneyTransfer", "Amount cannot be less than 0 or null!");
            return moneyTransferModelAndView;
        }

        //Transfer money from account to account
        moneyTransferService.transferMoney(senderAccountDto, recipientAccountDto, title, amount, commissionAmount, totalAmount);
        //Create transactionHistory for sender
        transactionHistoryService.createTransactionHistory(fromAccountNumber, TRANSACTION_TYPE, title, totalAmount, "OUTGOING");
        //Create transactionHistory for receiver
        transactionHistoryService.createTransactionHistory(toAccountNumber, TRANSACTION_TYPE, title, amount, "INCOMING");
        log.info("Money transfer completed successfully");

        moneyTransferModelAndView.addObject("successMoneyTransfer", "Money transfer completed successfully!");
        return moneyTransferModelAndView;
    }
}
