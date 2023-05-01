package com.application.corebank.util;

import java.util.Random;

public class AccountNumberGenerator {

    public static int generateAccountNumber() {
        Random random = new Random();
        return random.nextInt(900000000) + 100000000;
    }
}
