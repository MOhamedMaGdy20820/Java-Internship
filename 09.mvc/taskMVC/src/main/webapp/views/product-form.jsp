<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <title>Product Creation Page</title>
</head>

<body>
    <h1>This is the Product home page</h1>
    <hr>
    <div class="container" align="center">
        <h1 class="my-4">Create Product</h1>
        <form action="${pageContext.request.contextPath}/saveproduct" method="post">
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" class="form-control" id="name" name="name" required><br><br>
            </div>
            <div class="form-group">
                <label for="brand">Brand:</label>
                <input type="text" class="form-control" id="brand" name="brand" required><br><br>
            </div>
            <div class="form-group">
                <label for="category">Category:</label>
                <input type="text" class="form-control" id="category" name="category" required><br><br>
            </div>
            <div class="form-group">
                <label for="price">Price:</label>
                <input type="number" step="0.01" class="form-control" id="price" name="price" required><br><br>
            </div>
            <button type="submit" class="btn btn-primary">Create</button> 
            <a href="${pageContext.request.contextPath}/list" class="btn btn-secondary">Cancel</a>
        </form>
    </div>
</body>
</html>