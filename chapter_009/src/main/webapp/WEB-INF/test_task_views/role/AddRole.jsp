<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 15.12.2017
  Time: 2:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add role</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/addRole" method="post">
    Id : <input type="text" name="id">
    Role : <input type="text" name="role">
    <input type="submit">
</form>
</body>
</html>
