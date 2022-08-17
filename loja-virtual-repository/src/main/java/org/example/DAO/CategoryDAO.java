package org.example.DAO;

import org.example.models.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    private final Connection connection;

    public CategoryDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Category> read() throws SQLException {
        List<Category> categories = new ArrayList<>();
        String query = "select id, name from category";

        try (PreparedStatement statement = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.execute();
            try (ResultSet resultSet = statement.getResultSet()) {
                while (resultSet.next()) {
                    Category category = new Category(resultSet.getInt(1), resultSet.getString(2));
                    categories.add(category);
                }
            }
        }
        return categories;
    }
}
