<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 20.11.2017
  Time: 4:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>mvc_delete</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/mvcdelete" method="post">
    Id : <input type="text" name="id">
    <input type="submit">
</form>

<br/>
</body>
</html>
