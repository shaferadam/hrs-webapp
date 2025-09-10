<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Add Product</title></head>
<body>
    <h2>Add New Product</h2>
    <form action="addProduct" method="post">
        Name: <input type="text" name="name"><br>
        Description: <input type="text" name="description"><br>
        Price: <input type="text" name="price"><br>
        Quantity: <input type="text" name="quantity"><br>
        <input type="submit" value="Add Product">
    </form>
</body>
</html>
