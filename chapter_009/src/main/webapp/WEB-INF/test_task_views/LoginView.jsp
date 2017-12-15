<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 14.12.2017
  Time: 4:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<h1 style = "color: green">Choose essence (user, role, address, musicType)</h1>
<form action="${pageContext.servletContext.contextPath}/choose" method="post">
    Enter your choice : <input type="text" name="choice">
    <input type="submit">
</form>

</body>
</html>
