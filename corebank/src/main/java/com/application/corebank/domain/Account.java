package com.application.corebank.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@ToString
@Getter
@Setter
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue
    private Long id;
    private Integer customerNo;
    private Integer accNumber;
    private String accCurrencyType;
    private String accType;
    private Double balance;
    private String status;
}
