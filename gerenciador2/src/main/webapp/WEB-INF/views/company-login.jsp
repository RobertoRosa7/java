<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrance" var="routeCompanyNew"/>

<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>Login</title>
</head>
<body>

<div class="container">
    <h1 class="title">Company Login</h1>
    <form action="${routeCompanyNew}" method="post">
        <div class="form-group">
            <label for="login">Login</label>
            <input type="text" name="login" id="login"/>
            <input type="hidden" name="action" value="company-login">
        </div>

        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" name="password" id="password"/>
        </div>

        <button type="submit">Sign in</button>
    </form>
</div>
</body>
</html>
