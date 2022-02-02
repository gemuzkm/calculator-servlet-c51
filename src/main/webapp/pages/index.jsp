<%--
  Created by IntelliJ IDEA.
  User: gemuz
  Date: 25.01.2022
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <c:if test="${sessionScope.user.getRole() != 0}">
        <title>Main Page</title>
    </c:if>
    <c:if test="${sessionScope.user.getRole() == 0}">
        <title>Admin Page</title>
    </c:if>
</head>
<body>
<c:if test="${sessionScope.user.getRole() == null}">
    <a href="/registration">Registration</a><br>
    <a href="/login">Authorization</a><br>
    <a href="/recovery">Recovery Password</a><br>
    <p>${requestScope.mgsError}</p>
</c:if>

<c:if test="${sessionScope.user.getRole() == 1}">
    <a href="/calculator">Calculator</a><br>
    <a href="/history">History</a><br>
    <form action="/logout" method="POST">
        <input type="submit" value="Logout">
    </form>
    <p>${requestScope.mgsError}</p>
</c:if>

<c:if test="${sessionScope.user.getRole() == 0}">
    <a href="/userlist">User management</a><br>
    <a href="/createuser">Add User</a><br>
    <form action="/logout" method="POST">
        <input type="submit" value="Logout">
    </form>

    <p>${requestScope.mgsError}</p>
</c:if>

</body>
</html>