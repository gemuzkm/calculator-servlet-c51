<%--
  Created by IntelliJ IDEA.
  User: gemuz
  Date: 25.01.2022
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="/pages/assets/dist/css/bootstrap.min.css">

    <c:if test="${sessionScope.user.getRole() != 1}">
        <title>Main Page</title>
    </c:if>
    <c:if test="${sessionScope.user.getRole() == 1}">
        <title>Admin Page</title>
    </c:if>

</head>
<body>
<c:if test="${sessionScope.user.getRole() == null}">
    <p>${requestScope.mgsError}</p>

    <%@ include file="/pages/fragment/headerNoLogin.html" %>

</c:if>

<c:if test="${sessionScope.user.getRole() == 2}">

    <%@ include file="/pages/fragment/headerLogin.html" %>

</c:if>

<c:if test="${sessionScope.user.getRole() == 1}">

    <%@ include file="/pages/fragment/headerManagerLogin.html" %>

    <p>${requestScope.mgsError}</p>
</c:if>

<%@ include file="/pages/fragment/footer.html" %>

</body>
</html>