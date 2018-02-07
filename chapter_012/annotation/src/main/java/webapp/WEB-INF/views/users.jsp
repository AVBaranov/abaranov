<%@ page language="java" pageEncoding="UTF-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Список пользователей</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

<div>
    <h2>Список пользователей</h2>
    <form action="${pageContext.servletContext.contextPath}/users.do" method="post">
        name : <input type="text" name="name">
        <input type="submit">
    </form>
</div>

<br/>

<table style = "border: 1px solid black"; border : 1;>
    <tr>
        <td>Имя</td>
    </tr>

    <c:forEach items="${users}" var="user" varStatus="status">
        <tr valign="top">
            <td>${user.name}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
