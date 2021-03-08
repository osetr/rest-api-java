<%--
  Created by IntelliJ IDEA.
  User: anton
  Date: 08.03.21
  Time: 01:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>java</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/signup" method="post">
  <label for="email">Email: </label>
  <input required type="text" name="email" id="email"><br>

  <label for="name">Name: </label>
  <input required type="text" name="name" id="name"><br>

  <label for="password">Password: </label>
  <input required type="password" name="password" id="password"><br>

  <label for="age">Age: </label>
  <input required type="number" name="age" id="age"><br>

  <label for="height">Height: </label>
  <input required type="number" name="height" id="height"><br>

  <label for="weight">Weight: </label>
  <input required type="number" name="weight" id="weight"><br>

  <input required type="submit" value="Sign Up">
</form>
</body>
</html>
