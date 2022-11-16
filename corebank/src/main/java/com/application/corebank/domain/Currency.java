package com.application.corebank.domain;

import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@Table(name = "currency")
public class Currency {

    @Id
    @GeneratedValue
    private Long id;
    private String type;
    private String description;
}
