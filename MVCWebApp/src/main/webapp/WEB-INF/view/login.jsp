<%--
  Created by IntelliJ IDEA.
  User: Компас
  Date: 1/7/2023
  Time: 4:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    Login
    <form action="/login/loginCheck" method="GET">
        <br/>
        <input type="text" name="email" placeholder="Email" value="${user.email}">
        <div style="color:red">${emailError}</div>
        <br/>
        <input type="text" name="password" placeholder="Password" value="${user.password}"/>
        <div style="color:red">${passwordError}</div>
        <br/>
        <input type="submit" value="Submit"/>
        <br/>
    </form>
    <a href="/registration">Registry</a>
    <br/>
    <div style="color:red">${ErrorInvalidUser}</div>
</center>

</body>
</html>
