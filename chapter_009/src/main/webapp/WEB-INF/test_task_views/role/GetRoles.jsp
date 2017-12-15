
<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 15.12.2017
  Time: 2:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>get roles</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/chooseRoleAction" method="get">
    Choose new action <input type="submit">
</form>
<table style = "border: 1px solid black"; border : 1;>
    <tr>
        <th>id</th>
        <th>role</th>
    </tr>

    <c:forEach items="${roles}" var="role">

        <tr>
            <td><c:out value="${role.id}"></c:out></td>
            <td><c:out value="${role.role}"></c:out></td>
        </tr>

    </c:forEach>
</table>
</body>
</html>
