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
    <link href="${bootstrap}" rel="stylesheet" />
    <link href="${startertemplate}" rel="stylesheet" />
</head>
<body>
    <h3>Add good</h3>

    <form:form method="post" action="/admin/addGood/add" commandName="good">

        <div>
            <span>Input product's name</span>
            <form:input path="title"/>
        </div>
        <div>
            <span>Input product's price</span>
            <form:input path="price"/>
        </div>
        <div>
            <span>Input product's description</span>
            <form:input path="description"/>
        </div>
        <div>
            <span>Product's category ${category.category}</span>
            </div>
        <input type="submit" value="Add Product"/>
        <a href="/admin">Return</a>
    </form:form>
</body>
</html>
