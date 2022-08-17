package br.com.alura.loja.dao;

import br.com.alura.loja.model.Product;

import javax.persistence.EntityManager;
import java.util.List;

public class ProductDAO {

    private EntityManager em;

    public ProductDAO(EntityManager em) {
        this.em = em;
    }

    public void create(Product product) {
        this.em.persist(product);
    }

    public void update(Product prod) {
        this.em.merge(prod);
    }

    public void remove(Product prod) {
        prod = this.em.merge(prod);
        this.em.remove(prod);
    }

    public Product findById(Long id) {
        return this.em.find(Product.class, id);
    }

    public List<Product> findAll() {
        String query = "select p from Product as p";
        return this.em.createQuery(query, Product.class).getResultList();
    }

    public List<Product> findByName(String name) {
        String query = "select p from Product as p where p.name = :name";
        return this.em.createQuery(query, Product.class).setParameter("name", name).getResultList();
    }

    public List<Product> findByCategory(String name) {
        String query = "select p from Product as p where p.category.name = :name";
        return this.em.createQuery(query, Product.class).setParameter("name", name).getResultList();
    }
}
