package com.hrs.dao;

import java.sql.*;
import java.util.*;

public class ProductDAO {
    private static final String DB_URL = "jdbc:sqlserver://hrs-db-server.database.windows.net:1433;"
        + "database=hrs-db;"
        + "encrypt=true;"
        + "trustServerCertificate=false;"
        + "hostNameInCertificate=*.database.windows.net;"
        + "loginTimeout=30;";
    private static final String DB_USER = "CloudSA6f89355b";
    private static final String DB_PASSWORD = "VB30EJhD58ZtZ9";

    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("SQL Server JDBC Driver not found", e);
        }
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public void addProduct(String Model, String Serial, String Brand, String Description, double Cost, double List_Price) throws SQLException {
        String sql = "INSERT INTO products_new (Model,Serial,Brand,Description,Cost,List_Price) VALUES (?, ?, ?, ?,?,?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, Model);
            stmt.setString(2, Serial);
            stmt.setString(3, Brand);
            stmt.setString(4, Description);
            stmt.setDouble(5, Cost);
            stmt.setDouble(6, List_Price);
            stmt.executeUpdate();
        }
    }

    public List<Map<String, Object>> getAllProducts() throws SQLException {
        List<Map<String, Object>> products = new ArrayList<>();
        String sql = "SELECT * FROM products_new";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Map<String, Object> product = new HashMap<>();
                product.put("ProductID", rs.getInt("ProductID"));
                product.put("Model", rs.getString("Model"));
                product.put("Serial", rs.getString("Serial"));
                product.put("Brand", rs.getString("Brand"));
                product.put("Description", rs.getString("Description"));
                product.put("Cost", rs.getDouble("Cost"));
                product.put("List_Price", rs.getDouble("List_Price"));
                products.add(product);
            }
        }
        return products;
    }
    
    public String verifyConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                return "Connection successful to hrs-db.";
            }
        } catch (ClassNotFoundException e) {
            return "JDBC Driver not found: " + e.getMessage();
        } catch (SQLException e) {
            return "Connection failed: " + e.getMessage();
        }
    }

}


