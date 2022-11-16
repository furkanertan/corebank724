package com.application.corebank.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private Integer accountNumber;
    @Column
    private String accountType;
    @Column
    private String status;
}
