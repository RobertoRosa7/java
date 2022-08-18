package br.com.alura.loja.dao;

import br.com.alura.loja.model.Order;
import br.com.alura.loja.vo.SalesReport;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class OrderDAO {
    private EntityManager em;

    public OrderDAO(EntityManager em) {
        this.em = em;
    }

    public List<SalesReport> salesReport() {
        String query = "select new br.com.alura.loja.vo.SalesReport(" + "p.name, " + "sum(i.quantity), " + "max(o.date)) " + "from Order as o " + "join o.orderItems i " + "join i.product p " + "group by p.name " + "order by i.quantity desc";
        return this.em.createQuery(query, SalesReport.class).getResultList();
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

    public Order findOrderByClient(Long id) {
        String query = "select o from Order as o join fetch o.client where o.id = :id";
        return this.em.createQuery(query, Order.class).setParameter("id", id).getSingleResult();
    }
}
