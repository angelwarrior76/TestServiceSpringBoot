package com.homework.spring.service.test.web;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.homework.spring.service.test.model.Currency;
import com.homework.spring.service.test.model.ExternalRatesList;
import com.homework.spring.service.test.model.Rate;

import com.homework.spring.service.test.repositories.CurrenciesRepository;
import com.homework.spring.service.test.repositories.RatesRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

/**
 * Created by Alex on 24.04.2018.
 */
@Service
public class RatesServiceImpl implements RatesService {

    @Autowired
    private RatesRepository rates;
    @Autowired
    private CurrenciesRepository currencies;

    public Iterable<Rate> listRates(String ccy) throws NoSuchCurrencyException {
        if (!currencies.existByMnemonics(ccy)) {
            throw new NoSuchCurrencyException("Not found currency [" + ccy + "] in reference book.");
        }
        Calendar cld = GregorianCalendar.getInstance();
        cld.setTimeInMillis(System.currentTimeMillis());
        cld.set(Calendar.HOUR_OF_DAY, 0);
        cld.set(Calendar.MINUTE, 0);
        cld.set(Calendar.SECOND, 0);
        cld.set(Calendar.MILLISECOND, 0);
        long cdate = cld.getTime().toInstant().getEpochSecond();
        if (!rates.existsByDateAndCurrency(ccy, cdate)) {
            Iterable<Currency> ccys = currencies.findByMnemonics(ccy);
            RestTemplate restTemplate = new RestTemplate();
            ExternalRatesList list = restTemplate.getForObject("https://api.monobank.ua/bank/currency", ExternalRatesList.class);
            ccys.forEach((c) -> list.getRates().stream().filter((r) -> (r.getCurrencyCodeA() == c.getCode() && r.getCurrencyCodeB() == 980)).forEach((r) -> rates.save(new Rate(r.getDate(), c, r.getRateBuy(), r.getRateSell()))));
        }
        return rates.listRates(ccy, cdate);
    }
}
