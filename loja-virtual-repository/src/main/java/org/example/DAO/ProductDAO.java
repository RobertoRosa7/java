package org.example.DAO;

import org.example.models.Category;
import org.example.models.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    private final Connection connection;

    public ProductDAO(Connection connection) {
        this.connection = connection;
    }

    public void save(Product product) throws SQLException {
        String query = "insert into produto (name, description) values(?, ?)";
        try (PreparedStatement statement = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.execute();

            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                while (resultSet.next()) {
                    product.setId(resultSet.getInt(1));
                }
            }
        }
    }

    public List<Product> read() throws SQLException {
        List<Product> products = new ArrayList<>();
        String query = "select id, name, description from produto";

        try (PreparedStatement statement = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.execute();
            try (ResultSet resultSet = statement.getResultSet()) {
                while (resultSet.next()) {
                    Product product = new Product(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3));
                    products.add(product);
                }
            }
        }
        return products;
    }

    public List<Product> find(Category cat) throws SQLException {
        List<Product> products = new ArrayList<>();
        String query = "select id, name, description from produto where category_id = ?";

        try (PreparedStatement statement = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, String.valueOf(cat.getId()));
            statement.execute();
            try (ResultSet resultSet = statement.getResultSet()) {
                while (resultSet.next()) {
                    Product product = new Product(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3));
                    products.add(product);
                }
            }
        }
        return products;
    }
}
