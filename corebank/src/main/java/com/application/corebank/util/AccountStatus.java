package com.application.corebank.util;

import lombok.Getter;

@Getter
public enum AccountStatus {
    ACTIVE("A", "Active"),
    PASSIVE("P", "Passive"),
    DELETED("D", "Deleted");

    private final String code;
    private final String description;

    AccountStatus(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
