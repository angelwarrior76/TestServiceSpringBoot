package com.homework.spring.service.test.web;

public class NoSuchCurrencyException extends Exception {

    private String code;

    NoSuchCurrencyException() {
        super();
        this.code = null;
    }

    NoSuchCurrencyException(String message) {
        super(message);
        this.code = null;
    }

    NoSuchCurrencyException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
