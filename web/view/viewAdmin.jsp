<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
    <title>Admin Panel</title>
    <spring:url value="/resources/css/bootstrap.css" var="bootstrap"/>
    <spring:url value="/resources/css/modern-business.css" var="startertemplate"/>
    <link href="/resources/css/style.css" rel="stylesheet"/>
    <link href="/resources/css/adminstyle.css" rel="stylesheet"/>
    <link href="${bootstrap}" rel="stylesheet" />
    <link href="${startertemplate}" rel="stylesheet" />
</head>
<body>
<div id="main">
    <h2>Categories</h2>
<form:form method="post" action="/admin/addCategory" commandName="category">

    <div id="category-add-container">
            Add category:
            <form:input path="category" />
            <c:if test="${param.error == 'true'}">
                <span style="color:red;">Category must not be empty.</span>
            </c:if>
       <input type="submit" value="Add category"/>
    </div>
</form:form>
<br/>

<c:if test="${!empty CategoryList}">
    <div id="category-container">
    <table class="data">
        <tr>
            <th width="300">  Add Product in Category</th>
            <th>&nbsp;</th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${CategoryList}" var="category">
            <tr>
                <td width="300">  <a href="/admin/addGood?id=${category.id}">${category.category}</a></td>
                <td width="140">  <a href="/admin/editCategory/${category.id}">  edit category</a></td>
                <td width="150">     <a href="/admin/delete/${category.id}">  delete category</a></td>
            </tr>
        </c:forEach>
    </table>
    </div>
</c:if>


<h2>Goods</h2>
<c:if test="${!empty GoodList}">
    <table class="data">
    <tr>
        <th>  Good</th>
        <th>  Category</th>
        <th>  Price</th>
        <th>&nbsp;</th>
        <th>&nbsp;</th>
    </tr>
    <c:forEach items="${GoodList}" var="good">
        <tr>
            <td width="300">  ${good.title}</td>
            <td width="120">  ${good.category.category}</td>
            <td width="50">  ${good.price}$</td>
            <td width="40">  <a href="/admin/editGood/${good.id}">edit</a></td>
            <td width="40">  <a href="/admin/deleteGood/${good.id}">delete</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>


<br/>
<form:form action="${pageContext.request.contextPath}/logout" method="POST">
    <input type="submit" value="Logout" />
</form:form>
</div>
</body>
</html>
