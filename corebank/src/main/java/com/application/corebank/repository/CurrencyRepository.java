package com.application.corebank.repository;

import com.application.corebank.domain.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {

    //Get type names
    @Query("SELECT c.type FROM Currency c")
    Set<String> getAllCurrencyTypes();
}
