<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 15.12.2017
  Time: 3:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add address</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/addAddress" method="post">
    Id : <input type="text" name="id">
    Address : <input type="text" name="address">
    <input type="submit">
</form>
</body>
</html>
