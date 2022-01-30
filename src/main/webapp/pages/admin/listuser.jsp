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
    <title>User list Page</title>
</head>
<body>
<p><a href='<c:url value="/createuser" />'>Create new User</a></p>

<table>
    <tr><th>Name</th><th>Login</th><th>Password</th><th>Role</th><th>SessionID</th><th></th></tr>
    <c:forEach var="user" items="${listUser}">
        <tr><td>${user.getName()}</td>
            <td>${user.getLogin()}</td>
            <td>${user.getPassword()}</td>
            <td>${user.getRole()}</td>
            <td>${user.getSessionID()}</td>
            <td>
                <a href='<c:url value="/useredit?login=${user.getLogin()}" />'>Edit</a> |
                <form method="post" action='<c:url value="/userdel" />' style="display:inline;">
                    <input type="hidden" name="login" value="${user.getLogin()}">
                    <input type="submit" value="Delete">
                </form>
            </td></tr>
    </c:forEach>
</table>
</body>
</html>
