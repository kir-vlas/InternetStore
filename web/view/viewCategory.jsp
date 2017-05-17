<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
  <title>TEST</title>
  <spring:url value="resources/css/bootstrap.css" var="bootstrap"/>
  <spring:url value="/resources/css/modern-business.css" var="startertemplate"/>
  <link href="${bootstrap}" rel="stylesheet" />
  <link href="${startertemplate}" rel="stylesheet" />
</head>
<body>

<c:if test="${!empty CategoryList}">
  <table class="data">
    <tr>
      <th>  category</th>
            <th>&nbsp;</th>
    </tr>
    <c:forEach items="${CategoryList}" var="category">
      <tr>
        <td>  ${category}</td>

      </tr>
    </c:forEach>
  </table>
</c:if>




</body>
</html>
