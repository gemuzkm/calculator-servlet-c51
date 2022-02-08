<%--
  Created by IntelliJ IDEA.
  User: Kerus
  Date: 27.01.2022
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Calculator Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css"
          href="<%=application.getContextPath() %>/pages/assets/dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css"
          href="<%=application.getContextPath() %>/pages/assets/dist/css/calc.css">
</head>
<body>

<c:if test="${sessionScope.user.getRole() == 2}">
    <%@ include file="/pages/fragment/headerLogin.html"%>
</c:if>

<c:if test="${sessionScope.user.getRole() == 1}">
    <%@ include file="/pages/fragment/headerManagerLogin.html"%>
</c:if>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-sm-4">
            <form action="/calculator" method="post">

                <div class="mb-3">
                    <input type="text" name="value1" placeholder="Value 1" class="form-control" pattern="[+-]?([0-9]*[.])?[0-9]+">
                    ${requestScope.msgErrorValueOne}
                </div>

                <select class="form-select mb-3" name="operator">
                    <option disabled selected>Choose operator</option>
                    <option value="sum">+</option>
                    <option value="dif">-</option>
                    <option value="div">/</option>
                    <option value="mult">*</option>
                </select>
                ${requestScope.msgErrorOperation}

                <div class="mb-3">
                    <input type="text" name="value2" placeholder="Value 2" class="form-control" pattern="[+-]?([0-9]*[.])?[0-9]+">
                    ${requestScope.msgErrorValueTwo}
                </div>

                <button type="submit" class="btn btn-primary">Calculation</button> ${requestScope.result}
            </form>
        </div>
    </div>
</div>

<%@ include file="/pages/fragment/footer.html"%>

<script src="<%=application.getContextPath() %>/pages/assets/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
