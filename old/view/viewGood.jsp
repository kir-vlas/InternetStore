<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>${good.title}</title>
    <script src="/resources/js/jquery.js" type="text/javascript" ></script>
    <spring:url value="/resources/css/bootstrap.css" var="bootstrap"/>
    <spring:url value="/resources/css/modern-business.css" var="startertemplate"/>
    <link href="${bootstrap}" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet"/>
    <link href="${startertemplate}" rel="stylesheet"/>
</head>
<body>
    <div id="main">
        <jsp:include page="shared/_header.jsp"/>
        <jsp:include page="shared/_menu.jsp"/>
        <div id="good-page">
            <img class="prod-image" src="${pageContext.request.contextPath}/image?id=${good.id}"/>
            <span id="good-name">${good.title}</span>
            <span id="good-category">${good.category.category}</span>
            <div id="good-description">${good.description}</div>
            <span id="good-price">${good.price} $</span>
            <button onclick="$.ajax('${pageContext.request.contextPath}/addToCart?good=${good.id}',show())">Add to cart</button>
        </div>
        <jsp:include page="shared/_footer.jsp"/>
    </div>
    <div id="after-add-in-cart">
        Item Added in cart
    </div>
    <script type="text/javascript">
        function show() {
            $("#after-add-in-cart").show();
            setTimeout(function () {
                $("#after-add-in-cart").hide()
            },5000);
        }
    </script>
</body>
</html>
