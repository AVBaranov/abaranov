<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 28.11.2017
  Time: 6:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>select user</title>
</head>
<body>
<h1 style = "color: green">Enter user login to change</h1>
<form action="${pageContext.servletContext.contextPath}/admin" method="get">
    Login : <input type="text" name="login">
    <input type="submit">
</form>
<br/>
</body>
</html>
