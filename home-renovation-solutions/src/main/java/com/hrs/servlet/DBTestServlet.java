package com.hrs.servlet;

import com.hrs.dao.ProductDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/dbtest")
public class DBTestServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO dao = new ProductDAO();
        String result = dao.verifyConnection();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<div style='margin:20px; font-family:sans-serif;'>");
        out.println("<h2>🔍 DB Connection Test</h2>");
        out.println("<p>" + result + "</p>");
        out.println("</div>");
    }
}
