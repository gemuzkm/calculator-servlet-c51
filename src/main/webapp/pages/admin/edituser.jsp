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
<form action="/useredit" method="post">
    <label>Name</label><br>
    <input name="name" value="${sessionScope.userForEditing.getName()}" /><br><br>
    <label>Login</label><br>
    <input name="login" value="${sessionScope.userForEditing.getLogin()}" /><br><br>
    <label>Password</label><br>
    <input name="password" value="${sessionScope.userForEditing.getPassword()}" /><br><br>
    <label>Role</label><br>
    <input name="role" value="${sessionScope.userForEditing.getRole()}" /><br><br>
    <label>SessionID</label><br>
    <input name="sessionID" value="${sessionScope.userForEditing.getSessionID()}" /><br><br>
    <input type="submit" value="Save" />
</form>
</body>
</html>
