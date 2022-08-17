package org.example;

import org.example.DAO.ProductDAO;
import org.example.models.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestInsertWithProduct {
    public static void main(String[] args) throws SQLException {
        Product product = new Product("Comoda", "Cômoda vertical");

        try (Connection connection = new ConnectionFactory().restoreConnection()) {
            ProductDAO pp = new ProductDAO(connection);
            pp.save(product);
            List<Product> products = pp.read();
            products.forEach(System.out::println);
        }
    }
}
