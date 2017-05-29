<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<html>
<head>
    <title>Cart</title>
    <spring:url value="resources/css/bootstrap.css" var="bootstrap"/>
    <spring:url value="/resources/css/modern-business.css" var="startertemplate"/>
    <link href="${bootstrap}" rel="stylesheet" />
    <link href="${startertemplate}" rel="stylesheet" />
</head>
<body>

<form:form method="POST" modelAttribute="cartForm"
           action="${pageContext.request.contextPath}/shoppingCart">

    <c:forEach items="${cartForm.goodsList}" var="goodsList"
               varStatus="varStatus">
        <div class="good-preview-container">
            <ul>

                <li>Id: ${goodsList.good.id} <form:hidden
                        path="goodsList[0].good.id" />

                </li>
                <li>Name: ${goodsList.good.title}</li>
                <li>Price: <span class="price">

                         ${goodsList.good.price} $

                       </span></li>
                <li>Quantity: <form:input
                        path="goodsList[0].quantity" /></li>
                <li>Subtotal:
                    <span class="subtotal">

                            ${goodsList.amount} $

                         </span>
                </li>
                <li><a
                        href="${pageContext.request.contextPath}/cart/removegood?id=${goodsList.good.id}">
                    Delete </a></li>
            </ul>
        </div>
    </c:forEach>
    <div style="clear: both"></div>
    <input class="button-update-sc" type="submit" value="Update Quantity" />

    <a class="navi-item"
       href="${pageContext.request.contextPath}/index">Continue
        Buy</a>
</form:form>
</body>
</html>
