package org.example;

import org.example.DAO.CategoryDAO;
import org.example.factory.ConnectionFactory;
import org.example.models.Category;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestListCategory {

    public static void main(String[] args) throws SQLException {
        try (Connection connection = new ConnectionFactory().restoreConnection()) {
            CategoryDAO categoryDAO = new CategoryDAO(connection);
            List<Category> listCategory = categoryDAO.read();
            listCategory.forEach(System.out::println);
        }
    }
}
