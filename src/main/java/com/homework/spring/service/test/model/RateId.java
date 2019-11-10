package com.homework.spring.service.test.model;

import java.io.Serializable;

public class RateId implements Serializable {

    private static final long serialVersionUID = 8301270921007651560L;
    private int cdate;
    private Currency currency;

    public RateId() {
        super();
    }

    public RateId(int cdate, int code) {
        super();
        this.cdate = cdate;
        this.currency = Currency.valueOf(code);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.cdate;
        hash = 67 * hash + (this.currency != null ? this.currency.hashCode() : 0);
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
        final RateId other = (RateId) obj;
        if (this.cdate != other.cdate) {
            return false;
        }
        if (this.currency != other.currency && (this.currency == null || !this.currency.equals(other.currency))) {
            return false;
        }
        return true;
    }

}
