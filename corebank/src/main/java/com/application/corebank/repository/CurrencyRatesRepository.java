package com.application.corebank.repository;

import com.application.corebank.domain.CurrencyRates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrencyRatesRepository extends JpaRepository<CurrencyRates, Long> {

    List<CurrencyRates> findByToCurrency(String toCurrency);
}
