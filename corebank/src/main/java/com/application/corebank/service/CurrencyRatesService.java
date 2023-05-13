package com.application.corebank.service;

import com.application.corebank.assembler.CurrencyRatesAssembler;
import com.application.corebank.domain.CurrencyRates;
import com.application.corebank.dto.CurrencyRatesDto;
import com.application.corebank.repository.CurrencyRatesRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Slf4j
@AllArgsConstructor
public class CurrencyRatesService {

    private CurrencyRatesRepository repository;
    private CurrencyRatesAssembler assembler;

    public void deleteAllCurrencyRates() {
        log.info("Delete all currency rates.");

        repository.deleteAll();
    }

    public void updateCurrencyRate(String currencyType, JSONObject ratesObject, Set<String> currencyTypes) throws JSONException {
        for (String currency : currencyTypes) {
            if (currency.equals(currencyType)) {
                continue;
            }

            CurrencyRates currencyRates = assembler.toEntity(currencyType, currency, ratesObject.getDouble(currency));
            repository.save(currencyRates);
        }
    }

    public List<CurrencyRatesDto> getCurrencyRatesByToCurrency(String currencyType) {
        log.info("Get currency rates by currency type.");

        List<CurrencyRates> currencyRates = repository.findByToCurrency(currencyType);

        return assembler.fromEntityListToDtoList(currencyRates);
    }

    public CurrencyRatesDto getCurrencyRatesByFromCurrencyAndToCurrency(String fromCurrency, String toCurrency) {
        log.info("Get currency rates by currency type.");

        log.info("fromCurrency: " + fromCurrency);
        log.info("toCurrency: " + toCurrency);
        CurrencyRates currencyRates = repository.findByFromCurrencyAndToCurrency(fromCurrency, toCurrency);

        return assembler.toDto(currencyRates);
    }
}
