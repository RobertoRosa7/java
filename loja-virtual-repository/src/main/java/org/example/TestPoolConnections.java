package org.example;

import java.sql.Connection;
import java.sql.SQLException;

public class TestPoolConnections {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        for (int i = 0; i < 20; i++) {
            Connection connection = connectionFactory.restoreConnection();
            System.out.println("connection number: " + String.valueOf(i));
        }

    }
}
