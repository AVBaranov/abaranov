<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 14.12.2017
  Time: 5:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>error</title>
</head>
<body>
<h1 style = "color: red">You entered incorrct value! Please try again</h1>
<form action="${pageContext.servletContext.contextPath}/choose" method="get">
    Try again <input type="submit">
</form>
</body>
</html>
