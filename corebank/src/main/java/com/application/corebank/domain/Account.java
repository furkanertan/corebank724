package com.application.corebank.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@Getter
@Setter
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
