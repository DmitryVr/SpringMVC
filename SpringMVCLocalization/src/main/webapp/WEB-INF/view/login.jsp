<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Start</title>
</head>
<body>
    <%@include file="header.jsp"%>

    <spring:message code="message.form"/><br/>


    <form:form method="post" commandName="developer" action="check-user">
        <form:label path="name"><spring:message code="message.input1"/></form:label>
        <form:input path="name"/>
        <form:errors path="name"/>

        <input type="submit" value="<spring:message code="message.button.ok"/>"/>
    </form:form>
</body>
</html>
