<%--
  Created by IntelliJ IDEA.
  User: Kerus
  Date: 27.01.2022
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>History Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css"
          href="<%=application.getContextPath() %>/pages/assets/dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/pages/assets/dist/css/history.css">
</head>
<body>

<c:if test="${sessionScope.user.getRole() == 1}">
    <%@ include file="/pages/fragment/headerLogin.html" %>
</c:if>

<c:if test="${sessionScope.user.getRole() == 0}">
    <%@ include file="/pages/fragment/headerManagerLogin.html" %>
</c:if>

<div class="history">
    <div class="container">
        ${requestScope.msgErrorForAnonymous}
        <div class="row justify-content-center">
            <div class="col-sm-8">
                <table class="table table-striped table-bordered table-hover">
                    <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Operation</th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${requestScope.msgListHistoryUser}" var="item" varStatus="id">
                        <tr>
                            <th scope="row">${id.count})</th>
                            <td>${item.getValue()}</td>
                            <td>
                                <form method="post" action='<c:url value="/historydel" />' style="display:inline;">
                                    <input type="hidden" name="login" value="${sessionScope.user.getLogin()}">
                                    <input type="hidden" name="idItemHistory" value="${id.count}">
                                    <input type="submit" value="Delete">
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

<%@ include file="/pages/fragment/footer.html" %>

</body>
</html>
