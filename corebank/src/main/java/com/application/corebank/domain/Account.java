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
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue
    private Long id;
    private Long userId;
    private Integer accNumber;
    private String accCurrencyType;
    private String accType;
    private String accName;
    private Double balance;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
