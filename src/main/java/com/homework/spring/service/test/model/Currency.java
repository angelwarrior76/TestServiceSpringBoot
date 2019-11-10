package com.homework.spring.service.test.model;

import com.homework.spring.service.test.repositories.HibernateSessionFactory;

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
        super();
    }

    public Currency(int code, String mnemonics, String description) {
        super();
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.code;
        hash = 53 * hash + (this.mnemonics != null ? this.mnemonics.hashCode() : 0);
        hash = 53 * hash + (this.description != null ? this.description.hashCode() : 0);
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
        final Currency other = (Currency) obj;
        if (this.code != other.code) {
            return false;
        }
        if (this.mnemonics != other.mnemonics && (this.mnemonics == null || !this.mnemonics.equals(other.mnemonics))) {
            return false;
        }
        if (this.description != other.description && (this.description == null || !this.description.equals(other.description))) {
            return false;
        }
        return true;
    }

    public static Currency valueOf(int code) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(Currency.class, code);
    }

}
