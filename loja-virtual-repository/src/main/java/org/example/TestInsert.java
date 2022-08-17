package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {
    private static final String query = "insert into produto (name, description) values ('Mouse','Mouse sem fio')";

    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.restoreConnection();

        Statement statement = connection.createStatement();
        statement.execute(query, Statement.RETURN_GENERATED_KEYS);

        ResultSet resultSet = statement.getGeneratedKeys();

        while (resultSet.next()) {
            Integer id = resultSet.getInt(1);
            System.out.println("the ID create was: " + String.valueOf(id));
        }
        connection.close();
    }
}
