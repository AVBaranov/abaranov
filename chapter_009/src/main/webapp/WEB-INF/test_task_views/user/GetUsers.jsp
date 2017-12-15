<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 14.12.2017
  Time: 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>get users</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/chooseUserAction" method="get">
   Choose new action <input type="submit">
</form>
<table style = "border: 1px solid black"; border : 1;>
    <tr>
        <th>login</th>
        <th>password</th>
        <th>email</th>
        <th>role</th>
        <th>address</th>
    </tr>

    <c:forEach items="${users}" var="user">

        <tr>
            <td><c:out value="${user.login}"></c:out></td>
            <td><c:out value="${user.password}"></c:out></td>
            <td><c:out value="${user.email}"></c:out></td>
            <td><c:out value="${user.role}"></c:out></td>
            <td><c:out value="${user.address}"></c:out></td>
        </tr>

    </c:forEach>
</table>
</body>
</html>
