<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
    <title>Edit Category</title>
    <spring:url value="/resources/css/bootstrap.css" var="bootstrap"/>
    <spring:url value="/resources/css/modern-business.css" var="startertemplate"/>
    <link href="/resources/css/style.css" rel="stylesheet"/>
    <link href="/resources/css/adminstyle.css" rel="stylesheet"/>
    <link href="${bootstrap}" rel="stylesheet" />
    <link href="${startertemplate}" rel="stylesheet" />
</head>
<body>
<div id="main">
        <div id="update-category-form">
            <form:form method="post" action="/admin/editCat" commandName="newCategory">
                <div>
                    New category name:
                    <form:input path="category" value="${oldCategory.category}"/>
                    <form:errors cssStyle="color: red;" path="category" class="error-message" />
                    <form:hidden path="id" value="${oldCategory.id}"/>
                    <input type="submit" value="Ok"/>
                </div>
            </form:form>
        </div>
</div>
</body>
</html>
