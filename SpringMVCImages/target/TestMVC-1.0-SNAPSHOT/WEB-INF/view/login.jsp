<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Start</title>
</head>
<body>
    <%@include file="header.jsp"%>

    <form:form method="post" commandName="developer" action="check-user">
        <form:label path="name">Name</form:label>
        <form:input path="name"/>
        <form:errors path="name"/>

        <input type="submit" value="OK"/>
    </form:form>
</body>
</html>
