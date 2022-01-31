<%--
  Created by IntelliJ IDEA.
  User: gemuz
  Date: 31.01.2022
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Recovery Password Page</title>
</head>
<body>
<a href="/">Home</a><br>
<form action="/recovery" method="post">
    <input type="text" name="login" placeholder="Login"> ${requestScope.msgErrorLogin}
    <br><br>
    <button>Submit</button>
</form>
</body>
</html>
