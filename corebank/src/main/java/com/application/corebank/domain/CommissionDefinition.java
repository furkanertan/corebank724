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
@Table(name = "commission_definition")
public class CommissionDefinition {

    @Id
    @GeneratedValue
    private Long id;
    private String code;
    private String description;
    private Double rate;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
