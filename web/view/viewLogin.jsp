<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
    <title>Login</title>
    <spring:url value="resources/css/bootstrap.css" var="bootstrap"/>
    <spring:url value="/resources/css/modern-business.css" var="startertemplate"/>
    <link href="/resources/css/style.css" rel="stylesheet"/>
    <link href="${bootstrap}" rel="stylesheet" />
    <link href="${startertemplate}" rel="stylesheet" />
</head>
<body>
<div id="main">
    <jsp:include page="shared/_header.jsp"/>
    <jsp:include page="shared/_menu.jsp"/>
<div id="login-container">

    <h3>Enter username and password</h3>
    <br>
    <!-- /login?error=true -->
    <c:if test="${param.error == 'true'}">
        <div style="color: red; margin: 10px 0px;">

            Login Failed!!!<br /> Reason :
                ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}

        </div>
    </c:if>

    <form method="POST"
          action="${pageContext.request.contextPath}/j_spring_security_check">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <table>
            <tr>
                <td>User Name *</td>
                <td><input name="login" /></td>
            </tr>

            <tr>
                <td>Password *</td>
                <td><input type="password" name="password" /></td>
            </tr>

            <tr>
                <td>&nbsp;</td>
                <td><input type="submit" value="Login" /> </td>
            </tr>
        </table>
    </form>

    <span class="error-message">${error }</span>

</div>
    <jsp:include page="shared/_footer.jsp"/>
</div>
</body>
</html>
