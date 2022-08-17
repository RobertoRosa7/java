package org.example;

import org.example.DAO.CategoryDAO;
import org.example.factory.ConnectionFactory;
import org.example.models.Category;
import org.example.models.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestListCategory {

    public static void main(String[] args) throws SQLException {
        try (Connection connection = new ConnectionFactory().restoreConnection()) {
            CategoryDAO categoryDAO = new CategoryDAO(connection);
            List<Category> listCategories = categoryDAO.readJoinProduct();
//            listCategories.forEach(System.out::println);

            listCategories.forEach(cat -> {
                for (Product product : cat.getProducts()) {
                    System.out.println(cat.getName() + " - " + product.getName());
                }
            });
        }
    }
}
