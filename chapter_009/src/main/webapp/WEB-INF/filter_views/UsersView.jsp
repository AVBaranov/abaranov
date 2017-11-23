<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 23.11.2017
  Time: 1:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>users</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/controller" method="post">
    Login : <input type="text" name="login">
    Email : <input type="text" name="email">
    <input type="submit">
</form>
<br/>
<table style = "border: 1px solid black"; border : 1;>
    <tr>
        <th>login</th>
        <th>email</th>
    </tr>

    <c:forEach items="${users}" var="user">

        <tr>
            <td><c:out value="${user.login}"></c:out></td>
            <td><c:out value="${user.email}"></c:out></td>

        </tr>

    </c:forEach>
</table>
</body>
</html>
