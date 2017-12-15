<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 15.12.2017
  Time: 1:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>delete user</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/deleteUser" method="post">
    Id : <input type="text" name="id">
    <input type="submit">
</form>
</body>
</html>
