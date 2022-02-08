<%--
  Created by IntelliJ IDEA.
  User: gemuz
  Date: 30.01.2022
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User list Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css"
          href="<%=application.getContextPath() %>/pages/assets/dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/pages/assets/dist/css/history.css">
</head>
<body>

<%@ include file="/pages/fragment/headerManagerLogin.html" %>

<div class="listUser">
    <div class="container">
        ${requestScope.msgErrorForAnonymous}
        <div class="row justify-content-center">
            <div class="col-sm-8">
                <table class="table table-striped table-bordered table-hover">
                    <thead>
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Login</th>
                        <th scope="col">Password</th>
                        <th scope="col">Role</th>
                        <th scope="col">SessionID</th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${listUser}">
                        <tr>
                            <td>${item.getName()}</td>
                            <td>${item.getLogin()}</td>
                            <td>${item.getPassword()}</td>
                            <td>${item.getRole()}</td>
                            <td>${item.getSessionID()}</td>
                            <td><a href='<c:url value="/edituser?login=${item.getLogin()}" />'>Edit</a></td>
                            <td>
                                <form method="post" action='<c:url value="/deluser" />' style="display:inline;">
                                    <input type="hidden" name="login" value="${item.getLogin()}">
                                    <input type="submit" class="btn btn-primary" value="Delete">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<p>${sessionScope.msgError}</p>

<%@ include file="/pages/fragment/footer.html" %>

</body>
</html>
