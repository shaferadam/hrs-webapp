package com.hrs.servlet;

import com.hrs.dao.ProductDAO;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        try {
            new ProductDAO().addProduct(name, description, price, quantity);
            response.sendRedirect("viewProducts.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error adding product.");
        }
    }
}
