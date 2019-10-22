package com.homework.spring.service.test.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "currencies")
public class Currency implements Serializable {

    private static final long serialVersionUID = -2027368537338247858L;
    @Id
    @Column(name = "code")
    private int code;

    @Column(name = "mnemonics")
    @NotEmpty(message = "*Please provide currency mnemonics")
    private String mnemonics;

    @Column(name = "description")
    private String description;

    protected Currency() {
    }

    public Currency(int code, String mnemonics, String description) {
        this.code = code;
        this.mnemonics = mnemonics;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("\"Currency\": {\"code\"=%d, \"mnemonics\"='%s', \"description\"='%s'}", code, mnemonics, description);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int id) {
        this.code = code;
    }

    public String getMnemonics() {
        return mnemonics;
    }

    public void setMnemonics(String mnemonics) {
        this.mnemonics = mnemonics;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
