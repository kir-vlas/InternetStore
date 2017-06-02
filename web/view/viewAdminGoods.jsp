<%@ page import="org.nc.edu.internet_store.mvc.util.Utils" %>
<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
    <title>Add product</title>
    <spring:url value="/resources/css/bootstrap.css" var="bootstrap"/>
    <spring:url value="/resources/css/modern-business.css" var="startertemplate"/>
    <link href="/resources/css/style.css" rel="stylesheet"/>
    <link href="/resources/css/adminstyle.css" rel="stylesheet"/>
    <link href="${bootstrap}" rel="stylesheet" />
    <link href="${startertemplate}" rel="stylesheet" />
</head>
<body>
<div id="main">
    <%
        String categoryS = Utils.getSavedCategory(request).getCategory();
        request.getSession().setAttribute("categoryS", categoryS);
    %>
    <h3>Add good in category: ${categoryS}</h3>
    <div id="update-good-form">
    <form:form method="post" action="/admin/addGood/add" commandName="good">

        <div class="edit-good-input">
            <span>Input product's name</span>
            <form:input cssClass="input-good" path="title"/>
            <form:errors cssStyle="color: red;" path="title" class="error-message" />
        </div>
        <div class="edit-good-input">
            <span>Input product's price</span>
            <form:input cssClass="input-good" path="price"/>
            <form:errors cssStyle="color: red;" path="price" class="error-message" />
        </div>
        <div class="edit-good-input">
            <span>Input product's description</span>
            <form:textarea cssClass="input-description" path="description" rows="12" cols="70"></form:textarea>
            <form:errors cssStyle="color: red;" path="description" class="error-message" />
        </div>
        <input type="submit" value="Add Product"/>
        <a href="/admin">Return</a>
    </form:form>
    </div>
</div>
</body>
</html>
