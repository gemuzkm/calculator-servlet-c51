<%--
  Created by IntelliJ IDEA.
  User: gemuz
  Date: 25.01.2022
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Page</title>
</head>
<body>
<form action="/registration" method="post">
    <input type="text" name="name" placeholder="Name">
    <br>
    <input type="text" name="username" placeholder="Username">
    <br>
    <input type="text" name="password" placeholder="Password">
    <br>
    <button>Submit</button>
</form>
<p>${requestScope.message}</p>
</body>
</html>