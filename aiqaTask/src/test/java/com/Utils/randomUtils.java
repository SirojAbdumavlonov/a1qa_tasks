package com.Utils;

import org.apache.commons.lang3.RandomStringUtils;

public class randomUtils {
    static String randomString;
    static String randomNumbers;

    public static String randomStr() {

        randomString = RandomStringUtils.randomAlphabetic(10);
        return randomString;
    }

    public static String randomNum() {
        randomNumbers = RandomStringUtils.randomNumeric(10);
        return randomNumbers;

    }
}