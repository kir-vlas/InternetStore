<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Goods</title>
    <script src="/resources/js/jquery.js" type="text/javascript" ></script>
    <spring:url value="/resources/css/bootstrap.css" var="bootstrap"/>
    <spring:url value="/resources/css/modern-business.css" var="startertemplate"/>
    <link href="${bootstrap}" rel="stylesheet"/>
    <link href="/resources/css/style.css" rel="stylesheet"/>
    <link href="${startertemplate}" rel="stylesheet"/>
</head>
<body>
<div id="main">
    <jsp:include page="shared/_header.jsp"/>
    <jsp:include page="shared/_menu.jsp"/>

<div id="left">
    <h2>Categories</h2>
    <c:if test="${!empty CategoryList}">
        <table class="data">
            <c:forEach items="${CategoryList}" var="category">
                <tr>
                    <td><a href="goods/${category.id}">${category.category}</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>

<div id="right">
<h2>Goods</h2>
<c:if test="${!empty GoodList}">
    <div id="goods">

            <c:forEach items="${GoodList}" var="good">
                <div class="goodsm">
                    <a href="${pageContext.request.contextPath}/good?id=${good.id}">${good.title}</a>
                    <div class="goods-ut">
                        ${good.price} $
                        <button onclick="$.ajax('/addToCart?good=${good.id}',show())">Add to cart</button>
                    </div>
                </div>
            </c:forEach>

    </div>
</c:if>
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
