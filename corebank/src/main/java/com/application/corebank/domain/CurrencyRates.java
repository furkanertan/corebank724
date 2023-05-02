package com.application.corebank.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@ToString
@Getter
@Setter
@Table(name = "currency_rates")
public class CurrencyRates {

    @Id
    @GeneratedValue
    private Long id;
    private String fromCurrency;
    private String toCurrency;
    private Double rate;
    private LocalDateTime updatedAt;
}
