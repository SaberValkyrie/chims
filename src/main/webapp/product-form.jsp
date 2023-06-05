<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24/05/2023
  Time: 5:00 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Product Form</title>
  <style>
    table, td, th {
      border: 1px solid;
    }

    table {
      width: 100%;
      border-collapse: collapse;
    }
  </style>
</head>
<body>
<h1>Product Form</h1>
<c:choose>
    <c:when test="${empty product.id}">
        <form method="post" action="products?action=create">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name">
            <br><br>
            <label for="price">Price:</label>
            <input type="text" id="price" name="price">
            <br><br>
            <input type="submit" value="create">
            <a class="button" href="products">Cancel</a>
        </form>

    </c:when>
    <c:otherwise>
        <form method="post" action="products?action=update">
       <input type="hidden" name="id" value="${product.id}">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" value="${product.name}">
            <br>
            <br>
            <label for="price">Price:</label>
            <input type="text" id="price" name="price" value="${product.price}">
            <br>
            <br>
            <input type="submit" value="update">
            <a class="button" href="products">Cancel</a>
        </form>
    </c:otherwise>
</c:choose>
</body>
</html>
