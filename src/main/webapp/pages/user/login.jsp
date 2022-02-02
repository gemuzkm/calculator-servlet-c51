<%--
  Created by IntelliJ IDEA.
  User: gemuz
  Date: 25.01.2022
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<a href="/">Home</a><br>
<form action="/login" method="post">
    <input type="text" name="login" placeholder="Login" minlength="2" required>
    ${requestScope.msgErrorLogin}
    <br>
    <input type="password" name="password" placeholder="Password" minlength="2" required>
    ${requestScope.msgErrorPassword}
    <br>
    <button>Submit</button>
    <p> ${requestScope.msgErrorUser} ${requestScope.msgErrorLoginPassword} </p>
</form>
</body>
</html>
