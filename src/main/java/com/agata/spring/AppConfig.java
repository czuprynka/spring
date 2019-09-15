package com.agata.spring;

import com.agata.spring.model.Account;
import com.agata.spring.model.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Account myAccount(){
        return new Account();
    }

    @Bean
    public Client client(){
        return new Client();}
}
