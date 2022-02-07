<%--
  Created by IntelliJ IDEA.
  User: Kerus
  Date: 27.01.2022
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.*, java.text.*"  %>

<%@ page import="java.util.List, java.text.*" %>

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
                            <th>${id.count}</th>
                            <td>${item.getValue()}</td>

                            <td>
                                <form id="myForm" action="/delhistory" method="post">
                                    <input type="hidden" name="login" value="${sessionScope.user.getLogin()}">
                                    <input type="hidden" name="idItemHistory" value="${id.count}">
                                    <button type="submit" class="btn btn-primary">Delete</button>
                                </form>

<%--                                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">--%>
<%--                                    Delete--%>
<%--                                </button>--%>

<%--                                <!-- Modal -->--%>
<%--                                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">--%>
<%--                                    <div class="modal-dialog">--%>
<%--                                        <div class="modal-content">--%>
<%--                                            <div class="modal-header">--%>
<%--                                                <h5 class="modal-title" id="exampleModalLabel">Deleting an entry</h5>--%>
<%--                                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="No"></button>--%>
<%--                                            </div>--%>
<%--                                            <div class="modal-body">--%>
<%--                                                Do you want to delete the history of the operation?--%>
<%--                                                <div class="modal-footer">--%>
<%--                                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>--%>
<%--                                                    <form action="/delhistory" method="post">--%>
<%--                                                        <button type="submit" class="btn btn-primary" >Yes</button>--%>
<%--                                                        <input type='button' value='submit2' onclick='document.forms["myForm"].submit();'/>--%>
<%--                                                    </form>--%>
<%--                                                </div>--%>
<%--                                            </div>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
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
