package com.agata.spring;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@org.springframework.stereotype.Repository
@Transactional
public class ClientRepository {

    @Inject
    private EntityManager entityManager;

    public Client saveClient(int clientId, String clientName) {
        Client client = new Client();
        try {
//            entityManager.getTransaction().begin();
            client.setClientName(clientName);
            client.setClientId(clientId);
            client = entityManager.merge(client);
//            entityManager.getTransaction().commit();
        } catch (Exception e) {
//            entityManager.getTransaction().rollback();
        }
        return client;
    }


    public void updateClient(int clientId, String clientName) {
        try {
//            entityManager.getTransaction().begin();
            Client client = (Client) entityManager.find(Client.class, clientId);
            client.setClientName(clientName);
//            entityManager.getTransaction().commit();
        } catch (Exception e) {
//            entityManager.getTransaction().rollback();
        }
    }

    public void deleteClient(int clientId) {
        try {
//            entityManager.getTransaction().begin();
            Client client = (Client) entityManager.find(Client.class, clientId);
            entityManager.remove(client);
//            entityManager.getTransaction().commit();
        } catch (Exception e) {
//            entityManager.getTransaction().rollback();
        }
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

