
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
    <title>mvc_add</title>
</head>
<body>

<form action="${pageContext.servletContext.contextPath}/mvcadd" method="post">
    Name : <input type="text" name="name">
    Login : <input type="text" name="login">
    Email : <input type="text" name="email">
    <input type="submit">
</form>
<br/>

<table style = "border: 1px solid black"; border : 1;>
    <tr>
        <th>name</th>
        <th>login</th>
        <th>email</th>
        <th>date</th>
    </tr>

    <c:forEach items="${users}" var="user">

        <tr>
            <td><c:out value="${user.name}"></c:out></td>
            <td><a href="${pageContext.servletContext.contextPath}/Items.html"><c:out value="${user.login}"></a></c:out></td>
            <td><c:out value="${user.email}"></c:out></td>
            <td><c:out value="${user.createDate}"></c:out></td>
        </tr>

    </c:forEach>
</table>
</body>
</html>
