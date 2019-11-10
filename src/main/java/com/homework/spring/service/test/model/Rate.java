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

@Entity
@Table(name = "rates")
@IdClass(RateId.class)
public class Rate implements Serializable {

    private static final long serialVersionUID = -8301913051356847330L;
    @Id
    @Column(name = "cdate")
    private int cdate;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code")
    private Currency currency;

    @Column(name = "buy")
    private double buy;

    @Column(name = "sell")
    private double sell;

    protected Rate() {
        super();
    }

    public Rate(int cdate, int code, double buy, double sell) {
        super();
        this.cdate = cdate;
        this.currency = Currency.valueOf(code);
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

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(int code) {
        this.currency = Currency.valueOf(code);
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.cdate;
        hash = 37 * hash + (this.currency != null ? this.currency.hashCode() : 0);
        hash = 37 * hash + Double.valueOf(this.buy).hashCode();
        hash = 37 * hash + Double.valueOf(this.sell).hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Rate other = (Rate) obj;
        if (this.cdate != other.cdate) {
            return false;
        }
        if (this.currency != other.currency && (this.currency == null || !this.currency.equals(other.currency))) {
            return false;
        }
        if (this.buy != other.buy) {
            return false;
        }
        if (this.sell != other.sell) {
            return false;
        }
        return true;
    }

}
