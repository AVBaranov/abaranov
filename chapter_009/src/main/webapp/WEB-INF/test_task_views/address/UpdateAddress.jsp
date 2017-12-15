<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 15.12.2017
  Time: 3:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update address</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/updateAddress" method="post">
    Id: <input type="text" name="id">
    New id : <input type="text" name="new_id">
    New address : <input type="text" name="new_address">
    <input type="submit">
</form>
</body>
</html>
