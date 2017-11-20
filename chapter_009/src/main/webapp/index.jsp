<%@ page import="servlets.TestUser" %>
<%@ page import="servlets.UserStorage" %>
<%@ page import="servlets.jsp.JspUserStorage" %>
<%@ page import="servlets.User" %>
<%@ page import="servlets.jsp.Jsp_User" %><%--
  Created by IntelliJ IDEA.
  Jsp_User: Андрей
  Date: 15.11.2017
  Time: 4:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add</title>
    <%--<style>
        td, th {
            border: 1px solid black;
        }
        table {
            border-collapse: collapse;
        }
    </style>--%>
</head>
<body>

<form action="<%=request.getContextPath()%>/jspadd" method="post">
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
    <% for (Jsp_User user : JspUserStorage.getInstance().getUsers()) {%>
    <tr>
        <td><%=user.getName()%></td>
        <td><%=user.getLogin()%></td>
        <td><%=user.getEmail()%></td>
        <td><%=user.getCreateDate()%></td>
    </tr>
    <% } %>
</table>
</body>
</html>
