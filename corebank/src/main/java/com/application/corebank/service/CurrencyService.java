package com.application.corebank.service;

import com.application.corebank.domain.Currency;
import com.application.corebank.repository.CurrencyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {

    private CurrencyRepository currencyRepository;

    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    public List<Currency> getAllCurrencyTypes() {
        return currencyRepository.findAll();
    }
}
