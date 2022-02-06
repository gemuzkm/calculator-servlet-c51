<%--
  Created by IntelliJ IDEA.
  User: gemuz
  Date: 30.01.2022
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
    <title>Edit User Page</title>
</head>
<body>
<a href="/">Home</a><br>
<h3>Edit user</h3>
<form action="/edituser" method="post">
    <label>Name</label><br>
    <input type="text" name="name" value="${sessionScope.userForEditing.getName()}" minlength="2" required> ${sessionScope.msgErrorName}<br><br>
    <label>Login</label><br>
    <input type="text" name="login" value="${sessionScope.userForEditing.getLogin()}" minlength="2" required> ${sessionScope.msgErrorLogin}<br><br>
    <label>Password</label><br>
    <input type="password" name="password" value="${sessionScope.userForEditing.getPassword()}" > ${sessionScope.msgErrorPassword}<br><br>
    <label>Role</label><br>
    <input  name="role" value="${sessionScope.userForEditing.getRole()}" > ${sessionScope.msgErrorRole}<br><br>
    <label>SessionID</label><br>
    <input name="sessionID" value="${sessionScope.userForEditing.getSessionID()}" /><br><br>
    <input type="submit" value="Save" />
</form>
</body>
</html>
