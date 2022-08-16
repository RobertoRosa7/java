<%--<%@ page import="java.util.List" %>--%>
<%--<%@ page import="br.com.alura.gerenciador.model.Company" %>--%>
<%--<% List<Company> companies = (List<Company>) request.getAttribute("companies");%>--%>
<%@ page pageEncoding="utf-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/entrance" var="routeCompanyEntrance"/>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>Java Standard Taglib</title>
    <style>
        <%@ include file="css/style.css" %>
    </style>
</head>
<body>
<c:import url="components/toolbar.jsp"/>
<main class="container">
    <section>
        <article>
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
                            <span>${company.name} - <fmt:formatDate value="${company.date}"
                                                                    pattern="dd/MM/yyyy"/></span>
                            <a href="${routeCompanyEntrance}?action=company-form">new</a>
                            <a href="${routeCompanyEntrance}?action=company-update&id=${company.id}">update</a>
                            <a href="${routeCompanyEntrance}?action=company-remove&id=${company.id}">remove</a>
                        </li>
                    </c:forEach>
                </ul>

            </ul>
        </article>
    </section>
</main>
</body>
</html>
