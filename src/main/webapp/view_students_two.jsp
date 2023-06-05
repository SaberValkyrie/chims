<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
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
<h2>Student Table Demo</h2>
<table>
  <tr>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Email</th>
  </tr>

  <c:forEach var="tempStudent" items="${student_list}">
    <tr>
      <td>${tempStudent.firstname}</td>
      <td>${tempStudent.lastname}</td>
      <td>${tempStudent.email}</td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
