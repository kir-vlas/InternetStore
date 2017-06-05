<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Order</title>
    <spring:url value="/resources/css/bootstrap.css" var="bootstrap"/>
    <spring:url value="/resources/css/modern-business.css" var="startertemplate"/>
    <link href="/resources/css/style.css" rel="stylesheet"/>
    <link href="/resources/css/adminstyle.css" rel="stylesheet"/>
    <link href="${bootstrap}" rel="stylesheet" />
    <link href="${startertemplate}" rel="stylesheet" />
</head>
<body>
    <div id="main">
        <table id="order-table">
            <tr>
                <th>Title</th>
                <th>Quantity</th>
                <th>Price</th>
            </tr>
            <c:if test="${!empty OrderLines}">
                <c:forEach items="${OrderLines}" var="orderline">
                    <tr>
                        <td>${orderline.good.title}</td>
                        <td>${orderline.quantity}</td>
                        <td>${orderline.good.price * orderline.quantity}</td>
                    </tr>
                </c:forEach>
            </c:if>
        </table>
        <div id="status-change">
            <form:form modelAttribute="selectedStatus" action="/employee/order/changestatus" method="post">
                <form:select path="status">
                    <option selected disabled>Choose status</option>
                    <c:forEach items="${statuses}" var="status">
                        <option value="${status}">${status}</option>
                    </c:forEach>
                </form:select>
                <form:hidden path="orderId" value="${OrderLines.get(0).order.id}"/>
                <input type="submit" value="Change status"/>
            </form:form>
            <form:form action="/employee">
                <button>Return</button>
            </form:form>
        </div>
    </div>
</body>
</html>
