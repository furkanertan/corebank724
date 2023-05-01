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
@Table(name = "money_transfer")
public class MoneyTransfer {

    @Id
    @GeneratedValue
    private Long id;
    private Long fromCustomerNo;
    private Integer fromAccountNo;
    private String fromAccountCurrencyType;
    private Long toCustomerNo;
    private Integer toAccountNo;
    private String toAccountCurrencyType;
    private Double amount;
    private Double commissionAmount;
    private Double totalAmount;
    private String title;
    private LocalDateTime transferDate;
}
