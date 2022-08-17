package org.example;

import org.example.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {

    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.restoreConnection();

        System.out.println("closing connection");
        connection.close();
    }
}
