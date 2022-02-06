<%--
  Created by IntelliJ IDEA.
  User: gemuz
  Date: 30.01.2022
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Create User Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css"
          href="<%=application.getContextPath() %>/pages/assets/dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/pages/assets/dist/css/signin.css">
</head>
<body>

<%@ include file="/pages/fragment/headerManagerLogin.html"%>

<main class="form-signin">
    <form action="/createuser" method="POST">
        <h1 class="h3 mb-3 fw-normal">Add new User</h1>
        <div class="form-floating mb-3">
            <input type="text" name="name" class="form-control" id="inputName" placeholder="Name" minlength="2" required>
            <label for="inputName">Name</label>
            ${requestScope.msgErrorName}
        </div>
        <div class="form-floating mb-3">
            <input type="text" name="login" class="form-control" id="inputLogin" placeholder="Login" minlength="2" required>
            <label for="inputLogin">Login</label>
            ${requestScope.msgErrorLogin}
        </div>
        <div class="form-floating mb-3">
            <input type="password" name="password" class="form-control" id="inputPassword" placeholder="Password" minlength="2" required>
            <label for="inputPassword">Password</label>
            ${requestScope.msgErrorPassword}
        </div>
        <button class="w-100 btn btn-lg btn-primary" type="submit">Create</button>
        ${requestScope.msgErrorUser}
    </form>
</main>

<%@ include file="/pages/fragment/footer.html"%>

</body>
</html>
