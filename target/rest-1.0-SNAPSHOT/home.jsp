<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>java</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/home" method="post">
        <label for="dishes">Choose a dish:</label>
        <select name="dishes" id="dishes">
            <jsp:useBean id="dishes" scope="request" type="java.util.List"/>
            <c:forEach items="${dishes}" var="dish">
                <option name="id" value="<c:out value="${dish.getId()}" />"><c:out value="${dish.getName()}" /></option>
            </c:forEach>
        </select>
        <input type="Submit">
    </form>
    <a href="${pageContext.request.contextPath}/dish">Add Dish</a><br>

    <table border="1">
        <caption>Current state:</caption>
        <tr>
            <th>name</th>
            <th>proteins</th>
            <th>fats</th>
            <th>carbohydrates</th>
        </tr>
        <c:forEach items="${events}" var="event">
            <tr><td>${event.getName()}</td><td>${event.getProteins()}</td><td>${event.getFats()}</td><td>${event.getCarbohydrates()}</td></tr>
        </c:forEach>
    </table>

</body>
</html>
