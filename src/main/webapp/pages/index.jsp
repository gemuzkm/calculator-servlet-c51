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
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css"
          href="<%=application.getContextPath() %>/pages/assets/dist/css/bootstrap.min.css">

    <c:if test="${sessionScope.user.getRole() != 0}">
        <title>Main Page</title>
    </c:if>
    <c:if test="${sessionScope.user.getRole() == 0}">
        <title>Admin Page</title>
    </c:if>

</head>
<body>
<c:if test="${sessionScope.user.getRole() == null}">
    <p>${requestScope.mgsError}</p>

    <div class="fixed-top">
        <div class="container">
            <header class="d-flex justify-content-center py-3">
                <ul class="nav nav-pills">
                    <li class="nav-item"><a href="/" class="nav-link active" aria-current="page">Home</a></li>
                    <li class="nav-item"><a href="/login" class="nav-link">Login</a></li>
                    <li class="nav-item"><a href="/registration" class="nav-link">Sing Up</a></li>
                </ul>
            </header>
        </div>
        <div class="b-example-divider"></div>
    </div>

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

<div class="fixed-bottom">
    <footer class="bg-light text-center text-lg-start">
        <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
            © 2022 Copyright:
            <a class="text-dark" href="/">servlet-c51</a>
        </div>
    </footer>
</div>

<script src="<%=application.getContextPath() %>/pages/assets/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>