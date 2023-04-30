package com.application.corebank.util;

import java.util.Random;

public class AccountNumberGenerator {

    public static int generateAccountNumber() {
        Random random = new Random();
        int boundary = 1000;
        int accountNumber = boundary * random.nextInt(boundary);

        return accountNumber;
    }
}
