package com.homework.spring.service.test.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExternalRate implements Serializable {

    private static final long serialVersionUID = 458295551665455207L;
    private int currencyCodeA, currencyCodeB, date;
    private double rateSell, rateBuy, rateCross;

    public ExternalRate() {
    }

    public int getCurrencyCodeA() {
        return currencyCodeA;
    }

    public int getCurrencyCodeB() {
        return currencyCodeB;
    }

    public int getDate() {
        return date;
    }

    public double getRateSell() {
        return rateSell;
    }

    public double getRateBuy() {
        return rateBuy;
    }

    public double getRateCross() {
        return rateCross;
    }

    public void setCurrencyCodeA(int currencyCodeA) {
        this.currencyCodeA = currencyCodeA;
    }

    public void setCurrencyCodeB(int currencyCodeB) {
        this.currencyCodeB = currencyCodeB;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public void setRateBuy(double rateBuy) {
        this.rateBuy = rateBuy;
    }

    public void setRateSell(double rateSell) {
        this.rateSell = rateSell;
    }

    public void setRateCross(double rateCross) {
        this.rateCross = rateCross;
    }

}
