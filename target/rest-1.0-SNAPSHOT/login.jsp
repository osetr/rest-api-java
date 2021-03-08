<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>java</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    <label for="email">Email: </label>
    <input required type="text" name="email" id="email"><br>

    <label for="password">Password: </label>
    <input required type="password" name="password" id="password"><br>

    <input required type="submit" name="login" value="LogIn">
</form>
</body>
</html>
