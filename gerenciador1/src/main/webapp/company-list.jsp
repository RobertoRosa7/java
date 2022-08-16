<%--<%@ page import="java.util.List" %>--%>
<%--<%@ page import="com.example.gerenciador1.Company" %>--%>
<%--<% List<Company> companies = (List<Company>) request.getAttribute("companies");%>--%>
<%@ page pageEncoding="utf-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/company-remove" var="routeCompanyRemove"/>
<c:url value="/company-update" var="routeCompanyUpdate"/>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>Java Standard Taglib</title>
</head>
<body>
<ul>
    <h1>Company List</h1>

    <c:if test="${ not empty companyName}">
        <h1 class="title">
            Company <span class="name not-empty">${companyName}</span> registered with success!
        </h1>
    </c:if>

    <ul>
        <c:forEach items="${companies}" var="company">
            <li>
                    ${company.name} - <fmt:formatDate value="${company.date}" pattern="dd/MM/yyyy"/>
                <a href="${routeCompanyUpdate}?id=${company.id}">update</a>
                <a href="${routeCompanyRemove}?id=${company.id}">remove</a>
            </li>
        </c:forEach>
    </ul>

</ul>
</body>
</html>
