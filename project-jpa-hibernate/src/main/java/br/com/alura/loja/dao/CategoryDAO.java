package br.com.alura.loja.dao;

import br.com.alura.loja.model.Category;

import javax.persistence.EntityManager;

public class CategoryDAO {
    private EntityManager em;

    public CategoryDAO(EntityManager em) {
        this.em = em;
    }

    public void create(Category cat) {
        this.em.persist(cat);
    }

    public void update(Category cat) {
        this.em.merge(cat);
    }

    public void remove(Category cat) {
        cat = this.em.merge(cat);
        this.em.remove(cat);
    }
}