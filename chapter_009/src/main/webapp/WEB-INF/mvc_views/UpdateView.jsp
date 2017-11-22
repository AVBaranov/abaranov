<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 20.11.2017
  Time: 4:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>mvc_update</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/mvcupdate" method="post">
    Id : <input type="text" name="id"> <br/>
    Name : <input type="text" name="name"> <br/>
    Login : <input type="text" name="login"> <br/>
    Email : <input type="text" name="email"> <br/>
    <input type="submit">
</form>
</body>
</html>
