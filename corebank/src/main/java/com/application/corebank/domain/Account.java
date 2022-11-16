package com.application.corebank.domain;

import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue
    private Long id;
    private Integer number;
    private String currencyType;
    private String type;
    private String status;
}
