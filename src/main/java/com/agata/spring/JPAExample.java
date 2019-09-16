package com.agata.spring;

import com.agata.spring.model.Account;
import com.agata.spring.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

//        updateClient();
//        showClient();
//
//        deleteClient();
//        showClient();
    }

    public void saveClient() {
        clientRepository.saveClient("Anna","Długosz", "annadlugosz@gmail.com", "23111982", addAccounts());
        clientRepository.saveClient("Tom","Slide", "tomaszslide@wp.pl", "11112000", addAccounts());
        clientRepository.saveClient("Basia","Wielicka", "topgun@interia.pl", "17062001", addAccounts());
        clientRepository.saveClient("Władysław","Bognacki", "stokrotka19@interia.pl", "03031981", addAccounts());
        clientRepository.saveClient("Basia","Wielicka", "topgun@interia.pl","29111991", addAccounts());
    }

    public void deleteClient() {
        clientRepository.deleteClient(2);
    }

    public void updateClient() {
        clientRepository.updateClient(1, "newemail@interia.pl");
        clientRepository.updateClient(3, "secondnewemail@onet.pl");
    }

    public void showClient() {
        clientRepository.listClient();
    }

    public List<Account> addAccounts(){
        ArrayList<Account> accounts = new ArrayList<>();
        Account account1 = clientRepository.addAccount(12,"name1","PLN", new BigDecimal(10000));
        Account account2 = clientRepository.addAccount(34,"name2","EUR", new BigDecimal(2345));
        Account account3 = clientRepository.addAccount(95,"name3","PLN", new BigDecimal(222222));
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        return accounts;
    }
}

