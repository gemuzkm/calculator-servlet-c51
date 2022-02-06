<%--
  Created by IntelliJ IDEA.
  User: gemuz
  Date: 31.01.2022
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Recovery Password Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css"
          href="<%=application.getContextPath() %>/pages/assets/dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/pages/assets/dist/css/signin.css">
</head>
<body>

<%@ include file="/pages/fragment/headerNoLogin.html"%>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-sm-3">
            <form action="/recovery" method="post">

                <div class="mb-3">
                    <label for="inputLogin" class="form-label">Input User Login</label>
                    <input type="text" name="login" id="inputLogin" placeholder="Login" class="form-control" minlength="2" required>
                    ${requestScope.msgErrorLogin}
                </div>

                <button type="submit" class="btn btn-primary">Recovery</button> ${requestScope.result}
            </form>
        </div>
    </div>
</div>

<%@ include file="/pages/fragment/footer.html" %>
</body>
</html>
