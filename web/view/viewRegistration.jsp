<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
    <title>Registration</title>
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
        <div id="registration-form-container">
            <form:form method="post" action="/register" commandName="account">
                <div class="input-container">
                    First Name: 
                    <form:input cssClass="inputform" path="firstName"/>
                </div>
                <div class="input-container">
                    Last Name: 
                    <form:input cssClass="inputform" path="lastName"/>
                </div>
                <div class="input-container">
                    E-mail: 
                    <form:input cssClass="inputform" path="email"/>
                </div>
                <div class="input-container">
                    Adress:
                    <form:input cssClass="inputform" path="adress"/>
                </div>
                <div class="input-container">
                    Login:
                    <form:input cssClass="inputform" path="login"/>
                </div>
                <div class="input-container">
                    Password:
                    <form:input cssClass="inputform" type="password" path="password"/>
                </div>
                <div class="input-container">
                    Phone:
                    <form:input cssClass="inputform" path="phone"/>
                </div>
                <input type="submit" style="margin-left: 560px;" value="Register"/>
            </form:form>
        </div>
        <jsp:include page="shared/_footer.jsp"/>
    </div>
</body>
</html>