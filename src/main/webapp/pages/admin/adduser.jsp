<%--
  Created by IntelliJ IDEA.
  User: gemuz
  Date: 30.01.2022
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: gemuz
  Date: 25.01.2022
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Add User Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css"
          href="/pages/assets/dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/pages/assets/dist/css/history.css">
</head>
<body>
<a href="/">Home</a><br>
<form action="/registration" method="post">
    <input type="text" name="name" placeholder="Name" minlength="2" required>
    ${requestScope.msgErrorName}
    <br>
    <input type="text" name="login" placeholder="Login" minlength="2" readonly>
    ${requestScope.msgErrorLogin}
    <br>
    <input type="password" name="password" placeholder="Password" minlength="2" required>
    ${requestScope.msgErrorPassword}
    <br>
    <button>Submit</button>
    <p>${requestScope.msgErrorUser}</p>
</form>

<%@ include file="/pages/fragment/footer.html" %>
</body>
</html>

