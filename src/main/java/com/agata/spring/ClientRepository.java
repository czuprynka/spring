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

    public Client saveClient(String clientName, String clientSurname) {
        Client client = new Client();
        client.setClientName(clientName);
        client.setClientSurname(clientSurname);
        client = entityManager.merge(client);
        return client;
    }

    public void updateClient(String clientName, String clientSurname) {
        Client client = (Client) entityManager.find(Client.class, clientSurname);
        client.setClientName(clientName);
        client.setClientSurname(clientSurname);
    }

    public void deleteClient(String clientSurname) {
        Client client = (Client) entityManager.find(Client.class, clientSurname);
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

