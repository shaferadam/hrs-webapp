<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Renovation Solutions</title>
    <style>
        body { font-family: Arial; padding: 40px; background-color: #f4f4f4; }
        h2 { color: #333; }
        .button-container { margin-top: 20px; }
        .nav-button {
            padding: 10px 20px;
            margin-right: 15px;
            font-size: 16px;
            background-color: #0078D7;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .nav-button:hover {
            background-color: #005fa3;
        }
    </style>
</head>
<body>
    <h2>Welcome to Home Renovation Solutions</h2>
    <p>Select an action below:</p>

    <div class="button-container">
        <form action="viewProducts.jsp" method="get" style="display:inline;">
            <button class="nav-button">Display Products</button>
        </form>

        <form action="addProduct.jsp" method="get" style="display:inline;">
            <button class="nav-button">Add Product</button>
        </form>
    </div>
</body>
</html>
