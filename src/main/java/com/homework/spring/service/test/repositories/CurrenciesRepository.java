package com.homework.spring.service.test.repositories;

import com.homework.spring.service.test.model.Currency;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;

/**
 * Created by Alex on 24.04.2018.
 */
public interface CurrenciesRepository extends CrudRepository<Currency, Integer> {

    @Query(nativeQuery = true, value = "select exists(select 1 from currencies where mnemonics like :ccy)")
    boolean existByMnemonics(@Param("ccy") String ccy);

    @Query(nativeQuery = true, value = "select code, mnemonics, description from currencies where mnemonics like :ccy")
    Iterable<Currency> findByMnemonics(@Param("ccy") String ccy);

}
