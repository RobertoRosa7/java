package org.example;

import org.example.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestRemove {
    private static final String query = "delete from produto where id > ?";

    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.restoreConnection();

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, String.valueOf(2));
        statement.execute();
        Integer lineChanges = statement.getUpdateCount();

        System.out.println("Quantity lines was deleted: " + String.valueOf(lineChanges));
        connection.close();
    }
}
