<%--
  Created by IntelliJ IDEA.
  User: Kerus
  Date: 27.01.2022
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>History Page</title>
</head>
<body>
<a href="/">Home</a><br>
${requestScope.msgErrorForAnonymous}
${requestScope.msgHistoryUser}
</body>
</html>
