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
    <link href="${bootstrap}" rel="stylesheet" />
    <link href="${startertemplate}" rel="stylesheet" />
</head>
<body>

<form:form method="post" action="admin/add" commandName="Category">

    <table>
        <tr>
            <td>Category</td>
            <td><form:input path="category" /></td>
        </tr>

        <td colspan="2"><input type="submit"
                               value="Add category" /></td>
        </tr>
    </table>
</form:form>
<br/>

<h2>Categories</h2>
<c:if test="${!empty CategoryList}">
    <table class="data">
        <tr>
            <th>  category</th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${CategoryList}" var="category">
            <tr>
                <td>  <a href="/admin/addGood?id=${category.id}">${category.category}</a></td>
                <td>  <a href="/admin/delete/${category.id}">  delete</a></td>
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
            <td>  <a href="/admin/deleteGood/${good.id}">delete</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>


<br/>
<form:form action="${pageContext.request.contextPath}/logout" method="POST">
    <input type="submit" value="Logout" />
</form:form>

</body>
</html>
