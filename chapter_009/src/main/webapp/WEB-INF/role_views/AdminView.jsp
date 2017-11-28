
<%@ page import="servlets.jsp.JspUserStorage" %>
<%@ page import="servlets.User" %>
<%@ page import="servlets.jsp.Jsp_User" %>
<%@ page import="java.util.List" %>
<%@ page import="servlets.mvc_controllers.Mvc_User" %><%--
  Created by IntelliJ IDEA.
  Mvc_User: Андрей
  Date: 15.11.2017
  Time: 4:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>admin</title>
</head>
<body>

<form action="${pageContext.servletContext.contextPath}/admin" method="post">
    Login : <input type="text" name="login">
    NewLogin : <input type="text" name="newlogin">
    NewEmail : <input type="text" name="newemail">
    NewPassword : <input type="text" name="newpassword">
    <input type="submit">
</form>
<br/>
<table style = "border: 1px solid black"; border : 1;>
    <tr>
        <th>login</th>
        <th>email</th>
        <th>password</th>
    </tr>

    <c:forEach items="${users}" var="user">

        <tr>
            <td><c:out value="${user.login}"></c:out></td>
            <td><c:out value="${user.email}"></c:out></td>
            <td><c:out value="${user.password}"></c:out></td>
        </tr>

    </c:forEach>
</table>
</body>
</html>
