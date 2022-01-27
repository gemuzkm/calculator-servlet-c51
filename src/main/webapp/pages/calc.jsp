<%--
  Created by IntelliJ IDEA.
  User: Kerus
  Date: 27.01.2022
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator Page</title>
</head>
<body>
<a href="/">Home</a><br>
<form action="/calculator" method="post">
    <input type="text" name="value1" placeholder="Value1">
    ${requestScope.msgErrorValueOne}<br>
    <input type="text" name="operation" placeholder="Operation">
    ${requestScope.msgErrorOperation}<br>
    <input type="text" name="value2" placeholder="Value2">
    ${requestScope.msgErrorValueTwo}<br>
    <button>Calculate</button> ${requestScope.result}
</form>
</body>
</html>
