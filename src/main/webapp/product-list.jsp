<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24/05/2023
  Time: 10:38 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Product</title>
</head>
<body>
<h1>Product List</h1>
<a class="button add-button" href="products?action=new">Add new Product</a>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Action</th>

    </tr>
    <c:forEach var="product" items="${productList}">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>
                <a class="button" href="products?action=edit&id=${product.id}">Edit</a>
                <a class="button" href="products?action=delete&id=${product.id}"
                   onclick="return confirm('Bạn có chắc chắn muốn xóa sản phẩm không?')">Delete</a>
            </td>
        </tr>

    </c:forEach>
</table>
</body>
</html>
