<%--
  Created by IntelliJ IDEA.
  User: gemuz
  Date: 30.01.2022
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: gemuz
  Date: 25.01.2022
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Add User Page</title>
</head>
<body>
<a href="/">Home</a><br>
<form action="/registration" method="post">
    <input type="text" name="name" placeholder="Name">
    ${requestScope.msgErrorName}
    <br>
    <input type="text" name="login" placeholder="Login">
    ${requestScope.msgErrorLogin}
    <br>
    <input type="text" name="password" placeholder="Password">
    ${requestScope.msgErrorPassword}
    <br>
    <button>Submit</button>
    <p>${requestScope.msgErrorUser}</p>
</form>
</body>
</html>

