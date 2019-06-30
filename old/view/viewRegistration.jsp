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
            <form:form method="post" action="/register" modelAttribute="clientR">
                <div class="input-container">
                    First Name*:
                    <form:input cssClass="inputform" path="firstName"/>
                    <form:errors cssStyle="color: red;" path="firstName" class="error-message" />
                </div>
                <div class="input-container">
                    Last Name*:
                    <form:input cssClass="inputform" path="lastName"/>
                    <form:errors cssStyle="color: red;" path="lastName" class="error-message" />
                </div>
                <div class="input-container">
                    E-mail*:
                    <form:input cssClass="inputform" path="email"/>
                    <form:errors cssStyle="color: red;" path="email" class="error-message" />
                </div>
                <div class="input-container">
                    Address*:
                    <form:input cssClass="inputform" path="address"/>
                    <form:errors cssStyle="color: red;" path="address" class="error-message" />
                </div>
                <div class="input-container">
                    Login*:
                    <form:input cssClass="inputform" path="login"/>
                    <form:errors cssStyle="color: red;" path="login" class="error-message" />
                </div>
                <div class="input-container">
                    Password*:
                    <form:input cssClass="inputform" type="password" path="password"/>
                    <form:errors cssStyle="color: red;" path="password" class="error-message" />
                </div>
                <div class="input-container">
                    Confirm Password*:
                    <form:input cssStyle="color: red;" cssClass="inputform" type="password" path="passwordConfirm"/>

                </div>
                <div class="input-container">
                    Phone*:
                    <form:input cssClass="inputform" path="phone"/>
                    <form:errors cssStyle="color: red;" path="phone" class="error-message" />
                </div>
                <input type="submit" style="margin-left: 560px;" value="Register"/>
            </form:form>
        </div>
        <jsp:include page="shared/_footer.jsp"/>
    </div>
</body>
</html>
