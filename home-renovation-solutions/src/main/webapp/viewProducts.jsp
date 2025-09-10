<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.hrs.dao.ProductDAO" %>
<%@ page import="java.util.*" %>
<%
    ProductDAO dao = new ProductDAO();
    List<Map<String, Object>> products = dao.getAllProducts();
%>
<!DOCTYPE html>
<html>
<head><title>Product List</title></head>
<body>
    <h2>All Products</h2>
    <table border="1">
        <tr>
            <th>ID</th><th>Name</th><th>Description</th><th>Price</th><th>Quantity</th>
        </tr>
        <%
            for (Map<String, Object> p : products) {
        %>
        <tr>
            <td><%= p.get("ProductID") %></td>
            <td><%= p.get("ProductName") %></td>
            <td><%= p.get("ProductDescription") %></td>
            <td><%= p.get("ProductPrice") %></td>
            <td><%= p.get("ProductQuantity") %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>