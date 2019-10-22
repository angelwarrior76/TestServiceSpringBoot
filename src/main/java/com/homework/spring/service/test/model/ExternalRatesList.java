package com.homework.spring.service.test.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExternalRatesList implements Serializable {

    private static final long serialVersionUID = -4561093033531123687L;
    private List<ExternalRate> rates;

    public ExternalRatesList() {
        this.rates = new ArrayList<>(0);
    }

    public void setRates(List<ExternalRate> rates) {
        this.rates.addAll(rates);
    }

    public List<ExternalRate> getRates() {
        return rates;
    }

}
