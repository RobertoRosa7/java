package br.com.alura.loja.tests;

import br.com.alura.loja.dao.CategoryDAO;
import br.com.alura.loja.dao.ClientDAO;
import br.com.alura.loja.dao.OrderDAO;
import br.com.alura.loja.dao.ProductDAO;
import br.com.alura.loja.model.*;
import br.com.alura.loja.utils.Utils;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class NewOrder {

    public static void main(String[] args) {
        EntityManager entityManager = Utils.getEntityManager();

        Category category = new Category("Mobile");
        Product mobile = new Product("Xiaomi Redmi", "Very nice", new BigDecimal(1200), category);
        Client client = new Client("Roberto", "36212891869");

        CategoryDAO categorydao = new CategoryDAO(entityManager);
        ProductDAO productdao = new ProductDAO(entityManager);
        ClientDAO clientdao = new ClientDAO(entityManager);
        OrderDAO orderdao = new OrderDAO(entityManager);

        entityManager.getTransaction().begin();

        categorydao.create(category);
        productdao.create(mobile);
        clientdao.create(client);

        Product product = productdao.findById(1L);
        Client costumer = clientdao.findById(1L);

        Order order = new Order(costumer);
        OrderItem item = new OrderItem(10, order, product);

        order.addOrderItem(item);
        orderdao.create(order);

        entityManager.getTransaction().commit();

        BigDecimal valueTotal = orderdao.valueTotalSold();
        System.out.println("Total sold: " + valueTotal);
        entityManager.close();
    }
}
