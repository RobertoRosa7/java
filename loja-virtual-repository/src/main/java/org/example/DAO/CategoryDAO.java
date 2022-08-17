package org.example.DAO;

import org.example.models.Category;
import org.example.models.Product;

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

    public List<Category> readJoinProduct() throws SQLException {
        Category last = null;
        List<Category> categories = new ArrayList<>();
        String query = "select c.id, c.name, p.id, p.name, p.description from category c inner join produto p on c.id = p.category_id";

        try (PreparedStatement statement = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.execute();
            try (ResultSet resultSet = statement.getResultSet()) {
                while (resultSet.next()) {
                    if (last == null || !last.getName().equals(resultSet.getString(2))) {
                        Category category = new Category(
                                resultSet.getInt(1),
                                resultSet.getString(2)
                        );
                        last = category;
                        categories.add(category);
                    }
                    Product product = new Product(
                            resultSet.getInt(3),
                            resultSet.getString(4),
                            resultSet.getString(5)
                    );
                    last.add(product);
                }
            }
        }
        return categories;
    }
}
