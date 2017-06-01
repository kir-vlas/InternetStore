<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Locale" %>
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
    <link href="${bootstrap}" rel="stylesheet" />
    <link href="${startertemplate}" rel="stylesheet" />
</head>
<body>
    <div id="main">
        <jsp:include page="shared/_header.jsp"/>
        <jsp:include page="shared/_menu.jsp"/>
        <div id="orders-container">
            <c:if test="${!empty orderList}">
                <c:forEach items="${orderList}" var="order">
                    <div class="order">
                        ${order.order.id}
                        <fmt:formatDate value="${order.order.date}" pattern="yyyy-MM-dd"/>
                        ${order.order.totalPrice}
                        <c:forEach items="${order.orderLines}" var="orderLine">
                            <div class="order-line">
                                ${orderLine.good.title}
                                ${orderLine.quantity}
                                ${orderLine.good.price}
                            </div>
                        </c:forEach>
                    </div>
                </c:forEach>
            </c:if>
        </div>
        <jsp:include page="shared/_footer.jsp"/>
    </div>
</body>
</html>
