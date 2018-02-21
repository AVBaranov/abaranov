<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 20.02.2018
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<h1>List of cars</h1>
<br/>
<table style = "border: 1px solid black"; border : 1;>
    <tr>
        <th>model</th>
        <th>engine</th>
        <th>carbody</th>
        <th>transmission</th>
    </tr>

    <c:forEach items="${cars}" var="cars">

        <tr>
            <td><c:out value="${cars.name}"></c:out></td>
            <td><c:out value="${cars.engine.model}"></c:out></td>
            <td><c:out value="${cars.carbody.type}"></c:out></td>
            <td><c:out value="${cars.transmission.type}"></c:out></td>
        </tr>

    </c:forEach>
</table>

<br/>

<form action="addcar.do" method="get">
    <input type="submit" value="add car"/>
</form>

</body>
</html>
