package br.com.alura.loja.tests;

import br.com.alura.loja.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class ProductNew {
    public static void main(String[] args) {
        Product mobile = new Product();

        mobile.setName("Xiaomi Redmi");
        mobile.setDescription("120G Storage");
        mobile.setPrice(new BigDecimal("800"));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("loja");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(mobile);
        em.getTransaction().commit();
        em.close();
    }
}
