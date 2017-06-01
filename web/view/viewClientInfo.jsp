<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
    <title>Account details</title>
    <spring:url value="/resources/css/bootstrap.css" var="bootstrap"/>
    <spring:url value="/resources/css/modern-business.css" var="startertemplate"/>
    <link href="/resources/css/style.css" rel="stylesheet"/>
    <link href="${bootstrap}" rel="stylesheet" />
    <link href="${startertemplate}" rel="stylesheet" />
</head>
<body>
    <div id="main">
        <jsp:include page="shared/_header.jsp"/>
        <jsp:include page="shared/_menu.jsp"/>
        <div id="order-button">
            <a href="/orders?client=${client.login}">Orders</a>
        </div>
        <div id="client-container">
            <div class="client-field">
                First name:
                <span>${client.firstName}</span>
            </div>
            <div class="client-field">
                Last name:
                <span>${client.lastName}</span>
            </div>
            <div class="client-field">
                E-mail:
                <span>${client.email}</span>
            </div>
            <div class="client-field">
                Phone:
                <span>${client.phone}</span>
            </div>
            <div class="client-field">
                Address:
                <span>${client.address}</span>
            </div>
        </div>
        <jsp:include page="shared/_footer.jsp"/>
    </div>
</body>
</html>
