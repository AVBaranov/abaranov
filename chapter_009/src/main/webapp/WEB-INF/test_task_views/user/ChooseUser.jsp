<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 14.12.2017
  Time: 5:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>choose user</title>
</head>
<body>
<h3 style = "color: green">Choose CRUD operation for user (add, get, update, delete)</h3>
<form action="${pageContext.servletContext.contextPath}/chooseUserAction" method="post">
    Enter your choice : <input type="text" name="choice">
    <input type="submit">
</form>
</body>
</html>
