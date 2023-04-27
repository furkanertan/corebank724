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
@Table(name = "currency")
public class Currency {

    @Id
    @GeneratedValue
    private Long id;
    private String type;
    private String description;
}
