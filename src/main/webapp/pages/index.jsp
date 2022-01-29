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
    <title>Main Page</title>
</head>
<body>
<c:if test="${sessionScope.login == null}">
    <a href="/registration">Registration</a><br>
    <a href="/login">Authorization</a><br>
</c:if>

<c:if test="${sessionScope.login != null}">
    <a href="/calculator">Calculator</a><br>
    <a href="/history">History</a><br>
    <a href="/logout">Logout</a><br>
</c:if>

</body>
</html>