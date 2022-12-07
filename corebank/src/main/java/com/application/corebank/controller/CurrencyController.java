package com.application.corebank.controller;

import com.application.corebank.domain.Currency;
import com.application.corebank.dto.CurrencyDto;
import com.application.corebank.service.CurrencyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/currency")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/getAllCurrencyTypes")
    List<Currency> getAllCurrencyTypes() {
        log.info("Return all currencies.");

        return currencyService.getAllCurrencyTypes();
    }

    //create a new currency
    @PostMapping("/createCurrency")
    Currency createCurrency(@RequestBody CurrencyDto currencyDto) {
        log.info("Creating a new currency.");

        return currencyService.createCurrency(currencyDto);
    }
}