package com.hrs.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/addProduct")
public class ProductServlet extends HttpServlet {

   
    private static final String DB_URL = "jdbc:mysql://hrs-webapp-server.mysql.database.azure.com:3306/hrsdb?useSSL=true&requireSSL=true";
    private static final String DB_USER = "pavekzchds";
    private static final String DB_PASSWORD = "i711i9$BTUsxZJv3"; // <-- Replace with your actual password

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Add Product</title></head><body>");
        out.println("<h2>Add a New Product</h2>");
        out.println("<form method='post'>");
        out.println("Name: <input type='text' name='name'><br>");
        out.println("Price: <input type='text' name='price'><br>");
        out.println("<input type='submit' value='Add Product'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String priceStr = request.getParameter("price");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            double price = Double.parseDouble(priceStr);
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                String sql = "INSERT INTO products (name, price) VALUES (?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, name);
                    stmt.setDouble(2, price);
                    stmt.executeUpdate();

                    out.println("<html><body>");
                    out.println("<h3>✅ Product added successfully!</h3>");
                    out.println("<p><a href='addProduct'>Add another</a></p>");
                    out.println("</body></html>");
                }
            }

        } catch (NumberFormatException e) {
            out.println("<h3>❌ Invalid price format.</h3>");
        } catch (ClassNotFoundException e) {
            out.println("<h3>❌ JDBC Driver not found.</h3>");
        } catch (SQLException e) {
            out.println("<h3>❌ Database error: " + e.getMessage() + "</h3>");
        }
    }
}
