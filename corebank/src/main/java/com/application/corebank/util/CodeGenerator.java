package com.application.corebank.util;

import java.util.Random;

public class CodeGenerator {

    public static int generateCode() {
        Random random = new Random();
        int boundary = 123;
        int code = boundary * random.nextInt(boundary);

        return code;
    }
}
