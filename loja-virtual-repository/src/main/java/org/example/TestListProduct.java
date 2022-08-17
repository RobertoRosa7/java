package org.example;

import org.example.factory.ConnectionFactory;
import org.example.models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TestListProduct {

    private static final String query = "select id, name, description from produto";
    private static List<Product> products;

    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.restoreConnection();

        PreparedStatement statement = connection.prepareStatement(query);
        statement.execute();
        ResultSet results = statement.getResultSet();

        while (results.next()) {
            Integer id = results.getInt("id");
            String name = results.getString("name");
            String description = results.getString("description");

            System.out.println(id + ";" + name + ";" + description);
        }

        connection.close();
    }
}
