<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 15.12.2017
  Time: 2:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update role</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/updateRole" method="post">
    Id: <input type="text" name="id">
    New id : <input type="text" name="new_id">
    New role : <input type="text" name="new_role">
    <input type="submit">
</form>
</body>
</html>
