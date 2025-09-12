package com.hrs.dao;
import java.sql.*;
import java.util.*;

public class ProductDAO {
    private static final String DB_URL = "jdbc:sqlserver://hrs-db-server.database.windows.net:1433;"
            + "database=hrs-db;"
            + "encrypt=true;"
            + "trustServerCertificate=false;"
            + "hostNameInCertificate=*.database.windows.net;"
            + "loginTimeout=30;"
            + "authentication=ActiveDirectoryIntegrated;";

    public void addProduct(String name, String description, double price, int quantity) throws SQLException {
        String sql = "INSERT INTO products (ProductName, ProductDescription, ProductPrice, ProductQuantity) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, description);
            stmt.setDouble(3, price);
            stmt.setInt(4, quantity);
            stmt.executeUpdate();
        }
    }

    public List<Map<String, Object>> getAllProducts() throws SQLException {
        List<Map<String, Object>> products = new ArrayList<>();
        String sql = "SELECT * FROM products";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Map<String, Object> product = new HashMap<>();
                product.put("ProductID", rs.getInt("ProductID"));
                product.put("ProductName", rs.getString("ProductName"));
                product.put("ProductDescription", rs.getString("ProductDescription"));
                product.put("ProductPrice", rs.getDouble("ProductPrice"));
                product.put("ProductQuantity", rs.getInt("ProductQuantity"));
                products.add(product);
            }
        }
        return products;
    }
}
