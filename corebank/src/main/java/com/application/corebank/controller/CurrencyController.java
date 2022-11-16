package com.application.corebank.controller;

import com.application.corebank.domain.Currency;
import com.application.corebank.service.CurrencyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}