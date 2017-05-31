<%@ page import="org.nc.edu.internet_store.mvc.domain.Cart" %>
<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<html>
<head>
    <title>Cart</title>
    <spring:url value="resources/css/bootstrap.css" var="bootstrap"/>
    <spring:url value="/resources/css/modern-business.css" var="startertemplate"/>
    <link href="/resources/css/style.css" rel="stylesheet"/>
    <link href="${bootstrap}" rel="stylesheet"/>
    <link href="${startertemplate}" rel="stylesheet"/>
</head>
<body>
<div id="main">
    <jsp:include page="shared/_header.jsp"/>
    <jsp:include page="shared/_menu.jsp"/>
<c:if test="${empty cartForm or empty cartForm.goodsList}">
    <h4>There is no items in Cart</h4>
    <a href="${pageContext.request.contextPath}/index">Return</a>
</c:if>
<c:if test="${not empty cartForm and not empty cartForm.goodsList}">
    <form:form method="POST" modelAttribute="cartForm"
               action="${pageContext.request.contextPath}/cart">

        <c:forEach items="${cartForm.goodsList}" var="line"
                   varStatus="vstatus">
            <div class="good-preview-container">
                <ul>
                    <li><form:input
                            path="goodsList[${vstatus.index}].good.id" hidden="true" name="id" value="${line.good.id}"/>
                    </li>
                    <li>Name: ${line.good.title}</li>
                    <li>Price: <span id="price">

                         ${line.good.price} $

                       </span></li>
                    <li>Quantity: <form:input
                            path="goodsList[${vstatus.index}].quantity"/></li>
                    <li>Subtotal:
                        <span class="subtotal">

                            ${line.amount} $

                         </span>
                    </li>
                    <li><a
                            href="${pageContext.request.contextPath}/cart/removegood?id=${line.good.id}">
                        Delete </a></li>
                </ul>
            </div>
        </c:forEach>

        <input class="button-update-sc" type="submit" value="Update Quantity"/>

        <button><a class="navi-item"
                   href="${pageContext.request.contextPath}/index">Continue buy</a></button>
        <button><a href="${pageContext.request.contextPath}/order">Order</a></button>
    </form:form>
</c:if>
    <jsp:include page="shared/_footer.jsp"/>
</div>
</body>
</html>
