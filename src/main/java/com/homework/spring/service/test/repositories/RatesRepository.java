package com.homework.spring.service.test.repositories;

import com.homework.spring.service.test.model.Rate;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;

/**
 * Created by Alex on 24.04.2018.
 */
public interface RatesRepository extends CrudRepository<Rate, Integer> {

    @Query(nativeQuery = true, value = "select exists(select 1 from currencies c, rates r where c.mnemonics like :ccy and r.cdate=:cdate and c.code=r.code)")
    boolean existsByDateAndCurrency(@Param("ccy") String ccy, @Param("cdate") long cdate);

    @Query(nativeQuery = true, value = "select r.cdate, c.code, r.buy, r.sell from currencies c, rates r where c.mnemonics like :ccy and r.cdate=:cdate and c.code=r.code")
    Iterable<Rate> listRates(@Param("ccy") String ccy, @Param("cdate") long cdate);

}
