package com.hrs.servlet;

import com.hrs.dao.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

// @WebServlet("/addProduct")  - Can use annotations like this instead of web.xml.  Just make sure to remove the servlet from web.xml
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
        out.println("Model: <input type='text' name='Model'><br>");
        out.println("Serial: <input type='text' name='Serial'><br>");
        out.println("Brand: <input type='text' name='Brand'><br>");
        out.println("Description: <input type='text' name='Description'><br>");
        out.println("Cost: <input type='text' name='Cost'><br>");
        out.println("List_Price: <input type='text' name='List_Price'><br>");
        out.println("<input type='submit' value='Add Product'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String Model = request.getParameter("Model");
        String Serial = request.getParameter("Serial");
        String Brand = request.getParameter("Brand");
        String Description = request.getParameter("Description");
        String CostStr = request.getParameter("Cost");
        String List_Price_Str = request.getParameter("List_Price");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            double Cost = Double.parseDouble(CostStr);
            double List_Price = Double.parseDouble(List_Price_Str);

            productDAO.addProduct(Model,Serial,Brand,Description,Cost,List_Price);

            out.println("<html><body>");
            out.println("<h3>Product added successfully!</h3>");
            out.println("<p><a href='addProduct'>Add another</a></p>");
            out.println("</body></html>");

        } catch (NumberFormatException e) {
            out.println("<h3>Invalid price or quantity format.</h3>");
        } catch (Exception e) {
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        }
    }
}
