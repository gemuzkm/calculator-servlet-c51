<%--
  Created by IntelliJ IDEA.
  User: Kerus
  Date: 27.01.2022
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>


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

<%@ include file="/pages/fragment/headerLogin.html"%>

<div class="history">
        <div class="container">
            ${requestScope.msgErrorForAnonymous}
            ${requestScope.msgHistoryUser}
        </div>
</div>

<%@ include file="/pages/fragment/footer.html"%>

<script src="<%=application.getContextPath() %>/pages/assets/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
