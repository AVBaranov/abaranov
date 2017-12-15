<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 14.12.2017
  Time: 5:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add user</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/addUser" method="post">
    Name : <input type="text" name="name">
    Login : <input type="text" name="login">
    Email : <input type="text" name="email">
    Role : <input type="text" name="role">
    Address : <input type="text" name="address">
    <input type="submit">
</form>
</body>
</html>
