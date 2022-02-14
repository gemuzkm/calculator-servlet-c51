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
    <title>Registration Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" type="text/css" href="/pages/assets/dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/pages/assets/dist/css/signin.css">
</head>
<body>

<%@ include file="/pages/fragment/headerNoLogin.html"%>

<main class="form-signin">
    <form action="/registration" method="POST">
        <h1 class="h3 mb-3 fw-normal">Please sign up</h1>
        <div class="form-floating mb-3">
            <input type="text" name="name" class="form-control" id="inputName" placeholder="Name">
            <label for="inputName">Name</label>
        </div>
        <div class="form-floating mb-3">
            <input type="text" name="login" class="form-control" id="inputLogin" placeholder="Login">
            <label for="inputLogin">Login</label>
        </div>
        <div class="form-floating mb-3">
            <input type="password" name="password" class="form-control" id="inputPassword" placeholder="Password">
            <label for="inputPassword">Password</label>
        </div>
        <button class="w-100 btn btn-lg btn-primary" type="submit">Sign up</button>
    </form>
</main>

<%@ include file="/pages/fragment/footer.html"%>

<script src="/pages/assets/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
