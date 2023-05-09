package com.application.corebank.controller;

import com.application.corebank.service.CurrencyRatesService;
import com.application.corebank.service.CurrencyService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
