package com.agata.spring.model;

import com.agata.spring.model.Client;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer accountNo;
    private String accountName;
    private String currency;
    private BigDecimal amount;

    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id")
    private Client client;


    public Account() {
    }

    public Account(Integer accountNo, String accountName, String currency, BigDecimal amount) {
        this.accountNo = accountNo;
        this.accountName = accountName;
        this.currency = currency;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Integer accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountNo=" + accountNo +
                ", accountName='" + accountName + '\'' +
                ", currency='" + currency + '\'' +
                ", amount=" + amount +
                ", client=" + client +
                '}';
    }
}
