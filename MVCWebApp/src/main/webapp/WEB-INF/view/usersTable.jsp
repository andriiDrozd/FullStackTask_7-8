<%--
  Created by IntelliJ IDEA.
  User: Компас
  Date: 1/7/2023
  Time: 5:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of users</h2></caption>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
    </tr>
    <c:forEach var="user" items="${usersList}">
        <tr>
            <th>${user.id}</th>
            <th>${user.name}</th>
            <th>${user.email}</th>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>
