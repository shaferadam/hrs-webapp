<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Add Product</title></head>
<body>
    <h2>Add New Product</h2>
    <form action="addProduct" method="post">
        Model: <input type="text" name="Model"><br>
        Serial: <input type="text" name="Serial"><br>
        Brand: <input type="text" name="Brand"><br>
        Description: <input type="text" name="Description"><br>
        Cost: <input type="text" name="Cost"><br>
        List_Price: <input type="text" name="List_Price"><br>
        <input type="submit" value="Add Product">
    </form>
</body>
</html>
