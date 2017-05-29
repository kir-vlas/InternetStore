<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
    <title>Goods</title>
    <spring:url value="resources/css/bootstrap.css" var="bootstrap"/>
    <spring:url value="/resources/css/modern-business.css" var="startertemplate"/>
    <link href="${bootstrap}" rel="stylesheet" />
    <link href="${startertemplate}" rel="stylesheet" />
</head>
<body>

<h2>Categories</h2>
<c:if test="${!empty CategoryList}">
    <table class="data">
        <tr>
            <th>  category</th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${CategoryList}" var="category">
            <tr>
                <td>  <a href="goods/${category.id}">${category.category}</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<h2>Goods</h2>
<c:if test="${!empty GoodList}">
    <table class="data">
        <tr>
            <th>  Good</th>
            <th>  Category</th>
            <th>  Description</th>
            <th>  Price</th>
        </tr>
        <c:forEach items="${GoodList}" var="good">
            <tr>
                <td>  ${good.title}</td>
                <td>  ${good.category.category}</td>
                <td>  ${good.description}</td>
                <td>  ${good.price}$</td>
                <td>  <a href="/addToCart/${good.id}">Add to cart</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<div>
    <br/>
    <a href="/cart">View cart</a>
</div>
<div>
    <br/>
    <a href="/admin">Admin Panel</a>
</div>

</body>
</html>
