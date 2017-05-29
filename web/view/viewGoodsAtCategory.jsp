<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
    <title>${!(empty GoodList)?GoodList.get(0).category.category:"Not Found"}</title>
    <spring:url value="/resources/css/bootstrap.css" var="bootstrap"/>
    <spring:url value="/resources/css/modern-business.css" var="startertemplate"/>
    <link href="${bootstrap}" rel="stylesheet" />
    <link href="${startertemplate}" rel="stylesheet" />
</head>
<body>


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
            </tr>
        </c:forEach>
    </table>
</c:if>
<a href="/index">Return</a>
</body>
</html>
