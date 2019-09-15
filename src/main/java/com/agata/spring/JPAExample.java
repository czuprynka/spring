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
        clientRepository.saveClient("Anna","Długosz", "annadlugosz@gmail.com", "23111982");
        clientRepository.saveClient("Tom","Slide", "tomaszslide@wp.pl", "11112000");
        clientRepository.saveClient("Basia","Wielicka", "topgun@interia.pl", "17062001");
        clientRepository.saveClient("Władysław","Bognacki", "stokrotka19@interia.pl", "03031981");
        clientRepository.saveClient("Basia","Wielicka", "topgun@interia.pl","29111991");
    }

    public void deleteClient() {
        clientRepository.deleteClient(3);
    }

    public void updateClient() {
        clientRepository.updateClient(3, "newemail@interia.pl");
        clientRepository.updateClient(4, "secondnewemail@onet.pl");
    }

    public void showClient() {
        clientRepository.listClient();
    }

}

