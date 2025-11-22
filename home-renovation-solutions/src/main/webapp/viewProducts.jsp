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
            <th>ProductID</th><th>Serial</th><th>Brand</th><th>Description</th><th>Cost</th><th>List_Price</th>
        </tr>
        <%
            for (Map<String, Object> p : products) {
        %>
        <tr>
            <td><%= p.get("ProductID") %></td>
            <td><%= p.get("Serial") %></td>
            <td><%= p.get("Brand") %></td>
            <td><%= p.get("Description") %></td>
            <td><%= String.format("$%.2f", p.get("Cost")) %></td>
			<td><%= String.format("$%.2f", p.get("List_Price")) %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>