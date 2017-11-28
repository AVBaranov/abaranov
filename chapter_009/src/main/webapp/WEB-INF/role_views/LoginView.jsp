<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 22.11.2017
  Time: 8:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
</head>
<body>

<h1 style = "color: green">You need to log in</h1>

<c:if test="${error != ''}">
    <div style="background-color: yellow">
        <c:out value="${error}"/>
    </div>
</c:if>

<form action="${pageContext.servletContext.contextPath}/signin" method="post">
    Login : <input type="text" name="login">
    Password : <input type="password" name="password">
    <input type="submit">
</form>



</body>
</html>
