package com.application.corebank.controller;

import com.application.corebank.domain.Currency;
import com.application.corebank.dto.CurrencyDto;
import com.application.corebank.service.CurrencyService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/currency")
@AllArgsConstructor
public class CurrencyController {

    private CurrencyService currencyService;

    @GetMapping("/getAllCurrencies")
    List<CurrencyDto> getAllCurrencies() {
        log.info("Return all currencies.");

        return currencyService.getAllCurrencies();
    }

    //create a new currency
    @PostMapping("/createCurrency")
    Currency createCurrency(@RequestBody CurrencyDto currencyDto) {
        log.info("Creating a new currency.");

        return currencyService.createCurrency(currencyDto);
    }
}