<%--
  Created by IntelliJ IDEA.
  User: anton
  Date: 08.03.21
  Time: 02:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>java</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/dish" method="post">
  <label for="name">Name: </label>
  <input required type="text" name="name" id="name"><br>

  <label for="proteins">Proteins: </label>
  <input required type="number" name="proteins" id="proteins"><br>

  <label for="fats">Fats: </label>
  <input required type="number" name="fats" id="fats"><br>

  <label for="carbohydrates">Carbohydrates: </label>
  <input required type="number" name="carbohydrates" id="carbohydrates"><br>

  <input required type="submit" value="Save">
</form>
</body>
</html>
