<%--
  Created by IntelliJ IDEA.
  User: gemuz
  Date: 31.01.2022
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Password Page</title>
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
        <form action="/updatepassword" method="POST">
            <div class="form-floating mb-3">
                <input type="text" name="newpassword" class="form-control" id="inputNewPassword" placeholder="New Password" minlength="2" required>
                ${requestScope.msgErrorPassword}
                <label for="inputNewPassword">New Password</label>
            </div>
            <div class="form-floating mb-3">
                <input type="password" name="recword" class="form-control" id="inputRecoveryWord" placeholder="Recovery Word" minlength="2" required>
                ${requestScope.msgErrorRecoveryWord}
                <label for="inputRecoveryWord">Recovery Word</label>
                <input type="hidden" name="recoveryword" value="${sessionScope.recoveryword}">
            </div>
            RECOVERY WORD: ${sessionScope.recoveryword}
            <br>
            <button class="w-100 btn btn-lg btn-primary" type="submit">Recovery</button>
        </form>
    </main>
</div>

<%@ include file="/pages/fragment/footer.html"%>

</body>
</html>
