package br.com.alura.loja.dao;

import br.com.alura.loja.model.Order;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class OrderDAO {
    private EntityManager em;

    public OrderDAO(EntityManager em) {
        this.em = em;
    }

    public void create(Order order) {
        this.em.persist(order);
    }

    public void update(Order order) {
        this.em.merge(order);
    }

    public void remove(Order order) {
        order = this.em.merge(order);
        this.em.remove(order);
    }

    public Order findById(Long id) {
        return this.em.find(Order.class, id);
    }

    public BigDecimal valueTotalSold() {
        String query = "select sum(p.valueTotal) from Order as p";
        return this.em.createQuery(query, BigDecimal.class).getSingleResult();
    }
//
//    public List<Order> findByName(String name) {
//        String query = "select p from Order as p where p.name = :name";
//        return this.em.createQuery(query, Order.class).setParameter("name", name).getResultList();
//    }
//
//    public List<Order> findByCategory(String name) {
//        String query = "select p from Order as p where p.category.name = :name";
//        return this.em.createQuery(query, Order.class).setParameter("name", name).getResultList();
//    }
//
//    public BigDecimal getPriceOrderByName(String name) {
//        String query = "select p.price from Order as p where p.name = :name";
//        return this.em.createQuery(query, BigDecimal.class).setParameter("name", name).getSingleResult();
//    }
}
