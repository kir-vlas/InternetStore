<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
    <title>Edit Good</title>
    <spring:url value="/resources/css/bootstrap.css" var="bootstrap"/>
    <spring:url value="/resources/css/modern-business.css" var="startertemplate"/>
    <link href="/resources/css/style.css" rel="stylesheet"/>
    <link href="/resources/css/adminstyle.css" rel="stylesheet"/>
    <link href="${bootstrap}" rel="stylesheet" />
    <link href="${startertemplate}" rel="stylesheet" />
</head>
<body>
    <div id="main">
        <h2>Edit ${oldGood.title}</h2>
        <div id="update-good-form">
            <form:form method="post" action="/admin/updateGood" commandName="newGood">
                <form:hidden path="id" value="${oldGood.id}"/>
                <div class="edit-good-input">
                    Name:
                    <form:input cssClass="input-good" path="title" value="${oldGood.title}"/>
                </div>
                <div class="edit-good-input">
                    Price:
                    <form:input cssClass="input-good" path="price" value="${oldGood.price}"/>
                </div>
                <div class="edit-good-input">
                    Description:
                    <textarea name = "newDesc" class="input-description" rows="12" cols="70">${oldGood.description}</textarea>
                </div>
                <input type="submit" value="Ok"/>
            </form:form>
        </div>
    </div>
</body>
</html>
