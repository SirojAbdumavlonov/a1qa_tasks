package com.Utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomUtils {
    public static String randomStr() {
        return RandomStringUtils.randomAlphabetic(10);
    }

    public static String randomNum() {
        return RandomStringUtils.randomNumeric(10);
    }
}