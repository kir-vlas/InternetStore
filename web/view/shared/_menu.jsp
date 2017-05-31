<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="hor_menu">
    <div id="hor_left">
    <ul class="hmenu">
        <li>
            <a href="/cart">Cart</a>
        </li>
        <li>
            <a>Shipping info</a>
        </li>
    </ul>
    </div>
    <div id="hor_right">
        <security:authorize  access="hasRole('ROLE_CLIENT')">
            <ul class="hmenu">
                <li>
                    <a href="${pageContext.request.contextPath}/clientInfo">
                        Welcome, <sec:authentication property="principal.username" />
                    </a>
                </li>
                <li>
                    <form:form cssStyle="width: 350px; float: right;" action="${pageContext.request.contextPath}/logout" method="POST">
                        <input style="font-size: 10px;" type="submit" value="Logout" />
                    </form:form>
                </li>
            </ul>

        </security:authorize>
        <security:authorize access="hasRole('ROLE_ANONYMOUS')">
            <ul class="hmenu">
                <li>
                    <a href="${pageContext.request.contextPath}/clientLogin">Login</a>
                </li>
                <li>
                    <a href="/register">Register</a>
                </li>
            </ul>

        </security:authorize>
    </div>
</div>