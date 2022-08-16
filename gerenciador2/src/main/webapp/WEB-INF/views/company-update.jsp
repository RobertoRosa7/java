<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="/entrance" var="routeCompanyChange"/>
<fmt:formatDate value="${company.date}" pattern="dd/MM/yyyy" var="date"/>

<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>Form update Company</title>
</head>
<body>

<div class="container">
    <h1 class="title">Update company</h1>
    <form action="${routeCompanyChange}" method="post">
        <div class="form-group">
            <label for="companyName">Name Company</label>
            <input value="${company.name}" type="text" name="companyName" id="companyName"/>
        </div>

        <div class="form-group">
            <label for="companyDate">Date</label>
            <input value="${date}" type="text" name="companyDate" id="companyDate"/>
            <input type="hidden" value="${company.id}" name="companyId">
            <input type="hidden" value="company-change" name="action">
        </div>

        <button type="submit">Send</button>
    </form>
</div>
</body>
</html>