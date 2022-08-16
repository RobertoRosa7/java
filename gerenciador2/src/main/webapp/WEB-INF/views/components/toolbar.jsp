<%@ page pageEncoding="utf-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/entrance" var="routeCompanyEntrance"/>

<header>
    <c:if test="${not empty userLogged}">
        <h1 class="userLogged">User: <span class="name">${userLogged.login}</span> logged with success!</h1>
    </c:if>
    <a href="${routeCompanyEntrance}?action=company-logout">Logout</a>
</header>