package com.hrs.servlet;

import com.hrs.dao.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


public class ProductServlet extends HttpServlet {

    private ProductDAO productDAO = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Add Product</title></head><body>");
        out.println("<h2>Add a New Product</h2>");
        out.println("<form method='post'>");
        out.println("Name: <input type='text' name='name'><br>");
        out.println("Description: <input type='text' name='description'><br>");
        out.println("Price: <input type='text' name='price'><br>");
        out.println("Quantity: <input type='text' name='quantity'><br>");
        out.println("<input type='submit' value='Add Product'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String priceStr = request.getParameter("price");
        String quantityStr = request.getParameter("quantity");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            double price = Double.parseDouble(priceStr);
            int quantity = Integer.parseInt(quantityStr);

            productDAO.addProduct(name, description, price, quantity);

            out.println("<html><body>");
            out.println("<h3>✅ Product added successfully!</h3>");
            out.println("<p><a href='addProduct'>Add another</a></p>");
            out.println("</body></html>");

        } catch (NumberFormatException e) {
            out.println("<h3>❌ Invalid price or quantity format.</h3>");
        } catch (Exception e) {
            out.println("<h3>❌ Error: " + e.getMessage() + "</h3>");
        }
    }
}
