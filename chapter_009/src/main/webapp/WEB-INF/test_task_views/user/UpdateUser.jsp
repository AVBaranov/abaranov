<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 14.12.2017
  Time: 8:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update user</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/updateUser" method="post">
    Id: <input type="text" name="id">
    Name : <input type="text" name="name">
    Login : <input type="text" name="login">
    Email : <input type="text" name="email">
    Role : <input type="text" name="role">
    Address : <input type="text" name="address">
    <input type="submit">
</form>
</body>
</html>
