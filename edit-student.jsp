<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Student Tracker App</title>
  <link type="text/css" rel="stylesheet" href="css/add-student-style.css">
</head>
<body>
<div id="wrapper">
  <header id="header">
    <h1>Codelearn Academy</h1>
  </header>
</div>

<div id="container">
  <h3>Edit Student</h3>
  <form action="StudentControllerServlet" method="POST">
    <input type="hidden" name="command" value="UPDATE" />
    <input type="hidden" name="studentId" value="${student.id}" />
    <table>
      <tbody>
      <tr>
        <td><label>First Name:</label></td>
        <td><input type="text" name="firstName" value="${student.firstName}" /></td>
      </tr>
      <tr>
        <td><label>Last Name:</label></td>
        <td><input type="text" name="lastName" value="${student.lastName}" /></td>
      </tr>
      <tr>
        <td><label>Email:</label></td>
        <td><input type="text" name="email" value="${student.email}" /></td>
      </tr>
      <tr>
        <td><label></label></td>
        <td><input type="submit" value="Save" class="save" /></td>
      </tr>
      </tbody>
    </table>
  </form>
  <div style="clear: both;"></div>
  <p>
    <a href="StudentControllerServlet">Back to list</a>
  </p>
</div>
</body>
</html>