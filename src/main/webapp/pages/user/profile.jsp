<%--
  Created by IntelliJ IDEA.
  User: gemuz
  Date: 06.02.2022
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Profile user Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css"
          href="/pages/assets/dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/pages/assets/dist/css/signin.css">

</head>
<body>

<c:if test="${sessionScope.user.getRole() == null}">
    <%@ include file="/pages/fragment/headerNoLogin.html"%>
    ${sessionScope.msgErrorNoAccess}
</c:if>

<c:if test="${sessionScope.user.getRole() == 2}">
    <%@ include file="/pages/fragment/headerLogin.html"%>
</c:if>

<c:if test="${sessionScope.user.getRole() == 1}">
    <%@ include file="/pages/fragment/headerManagerLogin.html"%>
</c:if>

<c:if test="${sessionScope.user.getRole() != null}">
    <main class="form-signin">
        <form action="/edituser" method="POST">
            <h1 class="h3 mb-3 fw-normal">User profile</h1>
            <div class="form-floating mb-3">
                <input type="text" name="name" value="${sessionScope.user.getName()}" class="form-control"
                       id="inputName" placeholder="Name" minlength="2" required>
                <label for="inputName">Name</label>
            </div>
            <div class="form-floating mb-3">
                <input type="text" name="login" value="${sessionScope.user.getLogin()}" class="form-control"
                       id="inputLogin" placeholder="Login" minlength="2" readonly >
                <label for="inputLogin">Login</label>
            </div>
            <div class="form-floating mb-3">
                <input type="password" name="password" value="${sessionScope.user.getPassword()}"
                       class="form-control" id="inputPassword" placeholder="Password" minlength="2" required>
                <label for="inputPassword">Password</label>
            </div>
            <div class="form-floating mb-3">
                <input type="text" name="role" value="${sessionScope.user.getRole()}" class="form-control"
                       id="inputRole" placeholder="Role" required>
                <label for="inputRole">Role</label>
            </div>
            <div class="form-floating mb-3">
                <input type="text" name="sessionID" value="${sessionScope.user.getSessionID()}"
                       class="form-control" id="sessionID" placeholder="SessionID" required>
                <label for="inputRole">SessionID</label>
            </div>
            <button class="w-100 btn btn-lg btn-primary" type="submit">Save</button>
        </form>
    </main>
</c:if>

<%@ include file="/pages/fragment/footer.html"%>

<script src="/pages/assets/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
