<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title></title>
    <spring:url value="/resources/css/bootstrap.css" var="bootstrap"/>
    <spring:url value="/resources/css/modern-business.css" var="startertemplate"/>
    <link href="${bootstrap}" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet"/>
    <link href="${startertemplate}" rel="stylesheet"/>
</head>
<body>
    <div id="main">
        <jsp:include page="shared/_header.jsp"/>
        <jsp:include page="shared/_menu.jsp"/>
        <div id="good-page">
            <span id="good-name">${good.title}</span>
            <span id="good-category">${good.category.category}</span>
            <div id="good-description">${good.description}</div>
            <span id="good-price">${good.price} $</span>
            <a href="${pageContext.request.contextPath}/addToCart/${good.id}">Add to cart</a>
        </div>
        <jsp:include page="shared/_footer.jsp"/>
    </div>
</body>
</html>
