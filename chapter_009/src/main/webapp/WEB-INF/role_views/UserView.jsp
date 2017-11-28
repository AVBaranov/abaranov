<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 28.11.2017
  Time: 12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>user</title>
</head>
<body>
<h3 style = "color: green">Enter new login data</h3>
<form action="${pageContext.servletContext.contextPath}/userrole" method="post">
    Login : <input type="text" name="login">
    Email : <input type="text" name="email">
    Password : <input type="text" name="password">
    <input type="submit">
</form>

<br/>

</body>
</html>
