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
    <input type="text" name="value1" placeholder="Value1" pattern="[\d+]" required> ${requestScope.msgErrorValueOne}<br>
    <select name="operation">
        <option disabled selected>Choose operation</option>
        <option value="sum">+</option>
        <option value="dif">-</option>
        <option value="mult">*</option>
        <option value="div">/</option>
    </select> ${requestScope.msgErrorOperation} <br>
    <input type="text" name="value2" placeholder="Value2" pattern="[\d+]" required> ${requestScope.msgErrorValueTwo}<br>
    <button>Calculate</button> ${requestScope.result}
</form>
</body>
</html>
