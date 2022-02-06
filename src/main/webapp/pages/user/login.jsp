<%--
  Created by IntelliJ IDEA.
  User: gemuz
  Date: 25.01.2022
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css"
          href="<%=application.getContextPath() %>/pages/assets/dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/pages/assets/dist/css/signin.css">
</head>
<body>

<%@ include file="/pages/fragment/headerNoLogin.html"%>

<div class="container">

        <main class="form-signin">
            <form action="/login" method="POST">
                <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
                <div class="form-floating mb-3">
                    <input type="text" name="login" class="form-control" id="inputLogin" placeholder="Login">
                    <label for="inputLogin">Login</label>
                </div>
                <div class="form-floating mb-3">
                    <input type="password" name="password" class="form-control" id="inputPassword"
                           placeholder="Password">
                    <label for="inputPassword">Password</label>
                </div>
                <a href="/recovery" class="link-dark mb-3">Forget</a>
                <button class="w-100 btn btn-lg btn-primary" type="submit">Login</button>
            </form>
        </main>
</div>

<%@ include file="/pages/fragment/footer.html"%>

</body>
</html>
