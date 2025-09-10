package com.hrs.test;

import java.sql.SQLException;

import com.hrs.dao.ProductDAO;

public class ProductDAOTest {
    public static void main(String[] args) throws SQLException {
        ProductDAO dao = new ProductDAO();

        // Sample product data
        String name = "Smart Dimmer Switch";
        String description = "Wi-Fi enabled switch with voice control";
        double price = 24.99;
        int quantity = 50;

        // Attempt to insert the product
        dao.addProduct(name, description, price, quantity);
    }
}