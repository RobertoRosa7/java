package org.example;

import java.sql.*;

public class TestInsertWithParams {
    private static final String name = "Mouse";
    private static final String description = "Mouse sem fio";
    private static final String query = "insert into produto (name, description) values (?, ?)";

    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        try (Connection connection = connectionFactory.restoreConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                addVariables(statement, "Smart TV", "45 polegadas");
                addVariables(statement, "Radio", "Radio de bateria");

                connection.commit();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("ROLLBACK EXECUTED");
                connection.rollback();
            }
        }
    }

    private static void addVariables(PreparedStatement statement, String name, String description) throws SQLException {
        statement.setString(1, name);
        statement.setString(2, description);
        statement.execute();

        try (ResultSet resultSet = statement.getGeneratedKeys()) {
            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                System.out.println("the ID create was: " + String.valueOf(id));
            }
        }
    }
}
