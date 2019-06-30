<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<html>
<head>
    <title>Successful order</title>
    <spring:url value="resources/css/bootstrap.css" var="bootstrap"/>
    <spring:url value="/resources/css/modern-business.css" var="startertemplate"/>
    <link href="/resources/css/style.css" rel="stylesheet"/>
    <link href="${bootstrap}" rel="stylesheet"/>
    <link href="${startertemplate}" rel="stylesheet"/>
</head>
<body>
    <div id="main">
        <jsp:include page="shared/_header.jsp"/>
        <jsp:include page="shared/_menu.jsp"/>
        <div id="order-container">
            Thank you for buying. Your order id is ${orderId}.
            <button><a class="navi-item"
                       href="${pageContext.request.contextPath}/index">Return to main</a></button>
        </div>
        <jsp:include page="shared/_footer.jsp"/>
    </div>
</body>
</html>
