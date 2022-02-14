<%--
  Created by IntelliJ IDEA.
  User: gemuz
  Date: 06.02.2022
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Profile user Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css"
          href="/pages/assets/dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/pages/assets/dist/css/profile.css">
</head>
<body>
<div class="fixed-top">
    <div class="container">
        <header class="d-flex justify-content-center py-3">
            <ul class="nav nav-pills">
                <li class="nav-item"><a href="/calculator" class="nav-link" aria-current="page">Home</a></li>
                <li class="nav-item"><a href="/history" class="nav-link">History</a></li>
                <li class="nav-item"><a href="/profile" class="nav-link active">Profile</a></li>
                <form action="/logout" method="POST">
                    <button type="button" class="btn btn-link">Logout</button>
                </form>
            </ul>
        </header>
    </div>
</div>

<div class="container">
    asdasdasd
</div>

<%@ include file="/pages/fragment/footer.html"%>

<script src="/pages/assets/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
