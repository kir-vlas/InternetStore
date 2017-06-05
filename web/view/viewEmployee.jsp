<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Orders</title>
    <spring:url value="/resources/css/bootstrap.css" var="bootstrap"/>
    <spring:url value="/resources/css/modern-business.css" var="startertemplate"/>
    <link href="/resources/css/style.css" rel="stylesheet"/>
    <link href="/resources/css/adminstyle.css" rel="stylesheet"/>
    <link href="${bootstrap}" rel="stylesheet" />
    <link href="${startertemplate}" rel="stylesheet" />
</head>
<body>
    <div id="main">
        <table id="order-table" border="1">
            <tr>
                <th>Order number</th>
                <th>Client name</th>
                <th>Order status</th>
                <th>Total price</th>
                <th>&nbsp;</th>
            </tr>
            <c:if test="${!empty orders}">
                <c:forEach items="${orders}" var="order">
                    <tr>
                        <td>${order.order.id}</td>
                        <td>${order.order.client.firstName} ${order.order.client.lastName}</td>
                        <td>${order.order.statusList[order.order.status]}</td>
                        <td>${order.order.totalPrice} $</td>
                        <td><a href="/employee/order?id=${order.order.id}">View</a></td>
                    </tr>
                </c:forEach>
            </c:if>
        </table>
        <form:form action="${pageContext.request.contextPath}/logout" method="POST">
            <input type="submit" value="Logout" />
        </form:form>
    </div>
</body>
</html>
