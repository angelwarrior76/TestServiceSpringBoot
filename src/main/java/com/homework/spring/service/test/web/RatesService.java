package com.homework.spring.service.test.web;

import com.homework.spring.service.test.model.Rate;

/**
 * Created by Alex on 24.04.2018.
 */
public interface RatesService {

    Iterable<Rate> listRates(String ccy) throws NoSuchCurrencyException;

}
