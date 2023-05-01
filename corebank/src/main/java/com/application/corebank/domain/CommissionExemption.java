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
@Table(name = "commission_exemption")
public class CommissionExemption {

    @Id
    @GeneratedValue
    private Long id;
    private String accountNo;
    private String accountCurrencyType;
    private Long userId;
    private String commissionCode;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
