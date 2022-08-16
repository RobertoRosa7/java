<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrance" var="routeCompanyNew"/>

<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>Form new Company</title>
    <style><%@ include file="css/style.css" %></style>
</head>
<body>
<c:import url="components/toolbar.jsp"/>
<div class="container">
    <h1 class="title">Register new company</h1>
    <form action="${routeCompanyNew}" method="post">
        <div class="form-group">
            <label for="companyName">Name Company</label>
            <input type="text" name="companyName" id="companyName"/>
            <input type="hidden" name="action" value="company-new">
        </div>

        <div class="form-group">
            <label for="companyDate">Date</label>
            <input type="text" name="companyDate" id="companyDate"/>
        </div>

        <button type="submit">Send</button>
    </form>
</div>
</body>
</html>
