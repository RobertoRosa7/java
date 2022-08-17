package br.com.alura.loja.dao;

import br.com.alura.loja.model.Client;

import javax.persistence.EntityManager;

public class ClientDAO {

    private final EntityManager em;

    public ClientDAO(EntityManager em) {
        this.em = em;
    }

    public void create(Client client) {
        this.em.persist(client);
    }

    public void update(Client client) {
        this.em.merge(client);
    }

    public void remove(Client client) {
        client = this.em.merge(client);
        this.em.remove(client);
    }

    public Client findById(Long id) {
        return this.em.find(Client.class, id);
    }
}
