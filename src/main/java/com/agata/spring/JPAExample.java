package com.agata.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.inject.Inject;

@SpringBootApplication
public class JPAExample  implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JPAExample.class, args);
    }

    @Inject
    ClientRepository clientRepository;

    @Override
    public void run(String... args) {
        clientRepository.saveClient("Anna","Długosz");
        clientRepository.saveClient("Tom","Slide");
    }



}

