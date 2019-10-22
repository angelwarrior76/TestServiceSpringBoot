package com.homework.spring.service.test.web;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

import java.sql.SQLException;

@JsonAutoDetect(creatorVisibility = JsonAutoDetect.Visibility.NONE,
        fieldVisibility = JsonAutoDetect.Visibility.NONE,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE)
public class ErrorSimpleView implements Serializable {

    @JsonProperty
    private String code;
    @JsonProperty
    private String message;

    ErrorSimpleView(Exception e) {
        this.code = e instanceof SQLException ? ((SQLException) e).getSQLState() : null;
        this.message = e.getMessage();
    }

    @Override
    public String toString() {
        return String.format("\"Error\": {\"code\"='%s', \"message\"='%s'}", code, message);
    }

}
