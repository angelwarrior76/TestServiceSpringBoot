package com.homework.spring.service.test.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "rates")
@IdClass(RateId.class)
public class Rate implements Serializable {

    private static final long serialVersionUID = -8301913051356847330L;
    @Id
    @Column(name = "cdate")
    private int cdate;

    @Id
    @Column(name = "code", insertable = false, updatable = false)
    private int code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code")
    private Currency currency;

    @Column(name = "buy")
    @NotEmpty(message = "*Please provide buy rate")
    private double buy;

    @Column(name = "sell")
    @NotEmpty(message = "*Please provide sell rate")
    private double sell;

    protected Rate() {
    }

    public Rate(int cdate, Currency currency, double buy, double sell) {
        this.cdate = cdate;
        this.currency = currency;
        this.buy = buy;
        this.sell = sell;
    }

    @Override
    public String toString() {
        return String.format("\"Rate\": {\"cdate\"=%d, \"code\"=%d, \"buy\"=%d, \"sell\"=%d}", cdate, currency.getCode(), buy, sell);
    }

    public int getCdate() {
        return cdate;
    }

    public void setCdate(int cdate) {
        this.cdate = cdate;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getBuy() {
        return buy;
    }

    public void setBuy(double buy) {
        this.buy = buy;
    }

    public double getSell() {
        return sell;
    }

    public void setSell(double sell) {
        this.sell = sell;
    }

}
