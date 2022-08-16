<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>Company Created</title>
    <style>
        <%@ include file="css/style.css" %>
    </style>
</head>
<body>

<div class="container">
    <c:if test="${ not empty companyName}">
        <h1 class="title">
            Company <span class="name not-empty">${companyName}</span> registered with success!
        </h1>
    </c:if>

    <c:if test="${ empty companyName}">
        <h1 class="title">
            No <span class="name empty">company</span> was registered!
        </h1>
    </c:if>


</div>
</body>
</html>
