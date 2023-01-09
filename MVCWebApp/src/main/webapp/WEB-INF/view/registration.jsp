<%--
  Created by IntelliJ IDEA.
  User: Компас
  Date: 1/7/2023
  Time: 4:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>Registration

    <form action="/registration" method="POST">
        <br/>
        <input type="text" name="email" placeholder="Email" value="${email}" >
        <div style="color:red">${emailError}</div>
        <br/>
        <input type="text" name="password" placeholder="Password" value="${password}"/>
        <div style="color:red">${passwordError}</div>
        <br/>
        <input type="text" name="name" placeholder="Name" value="${name}" />
        <div style="color:red">${nameError}</div>
        <br/>
        <input type="submit" value="Submit"/>
        <br/>
    </form>
    <a href="/login">Log In</a>
</center>
</body>
</html>
