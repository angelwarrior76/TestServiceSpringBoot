package com.homework.spring.service.test.web;

public class NoSuchCurrencyException extends Exception {

    NoSuchCurrencyException() {
        super();
    }

    NoSuchCurrencyException(String message) {
        super(message);
    }

}
