<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 15.12.2017
  Time: 1:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>choose role</title>
</head>
<body>
<h3 style = "color: darkorange">Choose CRUD operation for role (add, get, update, delete)</h3>
<form action="${pageContext.servletContext.contextPath}/chooseRoleAction" method="post">
    Enter your choice : <input type="text" name="choice">
    <input type="submit">
</form>
</body>
</html>
