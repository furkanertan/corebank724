package com.application.corebank.controller;

import com.application.corebank.dto.AccountDto;
import com.application.corebank.dto.CurrencyRatesDto;
import com.application.corebank.service.AccountService;
import com.application.corebank.service.CurrencyRatesService;
import com.application.corebank.service.CurrencyService;
import com.application.corebank.service.TransactionHistoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Set;

@RestController
@Slf4j
@RequestMapping("/currencyRates")
@AllArgsConstructor
public class CurrencyRatesController {

    private CurrencyService currencyService;
    private CurrencyRatesService currencyRatesService;
    private AccountService accountService;
    private TransactionHistoryService transactionHistoryService;

    @PostMapping("/updateCurrencyRates")
    String updateCurrencyRates() throws IOException, InterruptedException, JSONException {
        //Get all currency types
        Set<String> currencyTypes = currencyService.getAllCurrencyTypes();

        //Remove all previous currency rates from database
        currencyRatesService.deleteAllCurrencyRates();

        //Get current USD currency rates from API
        log.info("Get USD currency rates.");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://exchangerate-api.p.rapidapi.com/rapid/latest/USD"))
                .header("X-RapidAPI-Key", "203a5ac582msh20fb09e70ef3e49p1fd4fbjsn88bcc9c6d0ec")
                .header("X-RapidAPI-Host", "exchangerate-api.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject jsonResponse = new JSONObject(response.body());
        JSONObject ratesObject = jsonResponse.getJSONObject("rates");
        log.info("Update USD currency rates.");
        currencyRatesService.updateCurrencyRate("USD", ratesObject, currencyTypes);

        //Get current EUR currency rates from API
        log.info("Get EUR currency rates.");
        request = HttpRequest.newBuilder()
                .uri(URI.create("https://exchangerate-api.p.rapidapi.com/rapid/latest/EUR"))
                .header("X-RapidAPI-Key", "203a5ac582msh20fb09e70ef3e49p1fd4fbjsn88bcc9c6d0ec")
                .header("X-RapidAPI-Host", "exchangerate-api.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        jsonResponse = new JSONObject(response.body());
        ratesObject = jsonResponse.getJSONObject("rates");
        log.info("Update EUR currency rates.");
        currencyRatesService.updateCurrencyRate("EUR", ratesObject, currencyTypes);

        //Get current GBP currency rates from API
        log.info("Get GBP currency rates.");
        request = HttpRequest.newBuilder()
                .uri(URI.create("https://exchangerate-api.p.rapidapi.com/rapid/latest/GBP"))
                .header("X-RapidAPI-Key", "203a5ac582msh20fb09e70ef3e49p1fd4fbjsn88bcc9c6d0ec")
                .header("X-RapidAPI-Host", "exchangerate-api.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        jsonResponse = new JSONObject(response.body());
        ratesObject = jsonResponse.getJSONObject("rates");
        log.info("Update GBP currency rates.");
        currencyRatesService.updateCurrencyRate("GBP", ratesObject, currencyTypes);

        //Get current PLN currency rates from API
        log.info("Get PLN currency rates.");
        request = HttpRequest.newBuilder()
                .uri(URI.create("https://exchangerate-api.p.rapidapi.com/rapid/latest/PLN"))
                .header("X-RapidAPI-Key", "203a5ac582msh20fb09e70ef3e49p1fd4fbjsn88bcc9c6d0ec")
                .header("X-RapidAPI-Host", "exchangerate-api.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        jsonResponse = new JSONObject(response.body());
        ratesObject = jsonResponse.getJSONObject("rates");
        log.info("Update PLN currency rates.");
        currencyRatesService.updateCurrencyRate("PLN", ratesObject, currencyTypes);

        //Get current try currency rates from API
        log.info("Get TRY currency rates.");
        request = HttpRequest.newBuilder()
                .uri(URI.create("https://exchangerate-api.p.rapidapi.com/rapid/latest/TRY"))
                .header("X-RapidAPI-Key", "203a5ac582msh20fb09e70ef3e49p1fd4fbjsn88bcc9c6d0ec")
                .header("X-RapidAPI-Host", "exchangerate-api.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        jsonResponse = new JSONObject(response.body());
        ratesObject = jsonResponse.getJSONObject("rates");
        log.info("Update TRY currency rates.");
        currencyRatesService.updateCurrencyRate("TRY", ratesObject, currencyTypes);

        return "All currency rates updated successfully.";
    }

    @GetMapping("/getCurrencyRates")
    public String getCurrencyRates(@RequestParam("fromCurrency") String fromCurrency,
                                   @RequestParam("toCurrency") String toCurrency) {
        CurrencyRatesDto currencyRatesDto = currencyRatesService.getCurrencyRatesByFromCurrencyAndToCurrency(fromCurrency, toCurrency);

        log.info("currency exchange rate: " + currencyRatesDto.getRate());

        return currencyRatesDto != null ? currencyRatesDto.getRate().toString() : "0";
    }

    @PostMapping("/exchangeCurrency")
    public ModelAndView exchangeCurrency(@RequestParam("fromCurrency") String fromCurrency,
                                         @RequestParam("toCurrency") String toCurrency,
                                         @RequestParam("fromAccount") String fromAccount,
                                         @RequestParam("toAccount") String toAccount,
                                         @RequestParam("amount") Double amount,
                                         @RequestParam("exchangeAmount") Double exchangeAmount) {
        ModelAndView currencyExchangePage = new ModelAndView("currencyexchange");

        AccountDto accountDto = accountService.getAccountByAccountNumber(Integer.valueOf(fromAccount));

        //If fromAccount or toAccount is empty
        if (fromAccount.isEmpty()) {
            currencyExchangePage.addObject("errorCurrencyExchange", "Please select from account.");
            return currencyExchangePage;
        }

        if (toAccount.isEmpty()) {
            currencyExchangePage.addObject("errorCurrencyExchange", "Please select to account.");
            return currencyExchangePage;
        }

        //Validate account balance
        if (accountDto.getBalance() < amount) {
            currencyExchangePage.addObject("errorCurrencyExchange", "Account balance is not enough to complete transaction.");
            return currencyExchangePage;
        }

        //validate amount
        if (amount <= 0) {
            currencyExchangePage.addObject("errorCurrencyExchange", "Amount must be greater than 0.");
            return currencyExchangePage;
        }

        //amount minus from account
        accountService.updateAccountBalance(Integer.valueOf(fromAccount), amount, true);
        transactionHistoryService.createTransactionHistory(fromAccount, "EXCHANGE", "Currency Exchange (from) - " + fromCurrency, amount, "OUTGOING");

        //exchangeAmount plus to account
        accountService.updateAccountBalance(Integer.valueOf(toAccount), exchangeAmount, false);
        transactionHistoryService.createTransactionHistory(fromAccount, "EXCHANGE", "Currency Exchange (to) - " + toCurrency, exchangeAmount, "INCOMING");

        //return success message
        currencyExchangePage.addObject("successCurrencyExchange", "Currency exchange successfully completed.");
        return currencyExchangePage;
    }
}
