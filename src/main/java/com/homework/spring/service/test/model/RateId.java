package com.homework.spring.service.test.model;

import java.io.Serializable;

public class RateId implements Serializable {

    private static final long serialVersionUID = 8301270921007651560L;
    private int cdate;
    private int code;

    public RateId() {}

    public RateId(int cdate, int code) {
        this.cdate = cdate;
        this.code = code;
    }

}
