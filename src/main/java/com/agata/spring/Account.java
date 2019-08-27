package com.agata.spring;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int accountNo;
    private String accountName;
    private String currency;
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name="client_id", nullable=false)
    private Client client;










}
