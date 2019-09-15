package com.agata.spring.repository;

import com.agata.spring.model.Account;
import com.agata.spring.model.Client;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

@org.springframework.stereotype.Repository
@Transactional
public class ClientRepository {

    @Inject
    private EntityManager entityManager;

    public void saveClient(String name, String surname, String email, String birthDate) {
        Client client = new Client();
        client.setName(name);
        client.setSurname(surname);
        client.setEmail(email);
        client.setBirthDate(birthDate);
        entityManager.persist(client);
    }

    public void updateClient(Integer id, String email) {
        Client client = (Client) entityManager.find(Client.class, id);
        client.setEmail(email);
        entityManager.merge(client);
    }

    public void deleteClient(Integer id) {
        Client client = (Client) entityManager.find(Client.class, id);
        entityManager.remove(client);
    }

    public List listClient() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Client> criteriaQuery = criteriaBuilder.createQuery(Client.class);
        Root<Client> root =criteriaQuery.from(Client.class);
        criteriaQuery.select(root);
        TypedQuery<Client> query = entityManager.createQuery(criteriaQuery);

        return query.getResultList();
    }
}

