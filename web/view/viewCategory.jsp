<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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

<form:form method="post" action="add" commandName="Category">

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

<h2>List</h2>
<c:if test="${!empty CategoryList}">
  <table class="data">
    <tr>
      <th>  category</th>
            <th>&nbsp;</th>
    </tr>
    <c:forEach items="${CategoryList}" var="category">
      <tr>
        <td>  ${category.category}</td>
        <td><a href="delete/${category.id}">  delete</a></td>
      </tr>
    </c:forEach>
  </table>
</c:if>




</body>
</html>
