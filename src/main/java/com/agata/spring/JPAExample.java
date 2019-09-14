package com.agata.spring;

import com.agata.spring.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.inject.Inject;
import java.text.SimpleDateFormat;

@SpringBootApplication
public class JPAExample  implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JPAExample.class, args);
    }

    @Inject
    ClientRepository clientRepository;

    @Override
    public void run(String... args) {
        saveClient();
        showClient();

        updateClient();
        showClient();

        deleteClient();
        showClient();
    }

    public void saveClient() {
        clientRepository.saveClient("Anna","Długosz", "annadlugosz@gmail.com", new SimpleDateFormat("23-11-1982"), 76);
        clientRepository.saveClient("Tom","Slide", "tomaszslide@wp.pl", new SimpleDateFormat("11-11-2000"), 52);
        clientRepository.saveClient("Basia","Wielicka", "topgun@interia.pl", new SimpleDateFormat("17-06-2001"), 78);
        clientRepository.saveClient("Władysław","Bognacki", "stokrotka19@interia.pl", new SimpleDateFormat("03-03-1981"), 13);
        clientRepository.saveClient("Basia","Wielicka", "topgun@interia.pl", new SimpleDateFormat("29-11-1991"), 45);
    }

    public void deleteClient() {
        clientRepository.deleteClient("Slide");
    }

    public void updateClient() {
        clientRepository.updateClient("Slide", 45);
        clientRepository.updateClient("Sługosz", 99);
    }

    public void showClient() {
        clientRepository.listClient();
    }

}

