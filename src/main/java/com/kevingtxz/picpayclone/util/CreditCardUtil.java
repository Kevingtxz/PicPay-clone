package com.kevingtxz.picpayclone.util;

public class CreditCardUtil {

    public static String mask(String cardNumber) {
        return cardNumber.replaceAll("\\b(\\d{4})(\\d{8})(\\d{4})", "$1XXXXXXXX$3");
    }
}
