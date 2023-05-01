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
@Table(name = "transaction_history")
public class TransactionHistory {

    @Id
    @GeneratedValue
    private Long id;
    private String accountNumber;
    private String transactionType;
    private String message;
    private Double amount;
    private String reasonCode;
    private LocalDateTime transactionTime;
}
