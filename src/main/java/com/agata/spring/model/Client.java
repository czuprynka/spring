package com.agata.spring.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "client")
public class Client {

    String isoDatePattern = "dd-MM-yyyy";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    @Email
    private String email;
    private SimpleDateFormat birthDate = new SimpleDateFormat(isoDatePattern);
    @Max(100)
    private double scoring;

//    @OneToMany(mappedBy="client")
//    private Set<Account> account;


    public Client() {
    }

    public Client(Long id, String name, String surname, String email, SimpleDateFormat birthDate, double scoring) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthDate = birthDate;
        this.scoring = scoring;
//        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public SimpleDateFormat getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(SimpleDateFormat birthDate) {
        this.birthDate = birthDate;
    }

    public double getScoring() {
        return scoring;
    }

    public void setScoring(double scoring) {
        this.scoring = scoring;
    }

//    public Set<Account> getAccount() {
//        return account;
//    }
//
//    public void setAccount(Set<Account> account) {
//        this.account = account;
//    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", scoring=" + scoring +
//                ", account=" + account +
                '}';
    }
}
