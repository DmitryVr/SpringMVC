<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Start</title>
</head>
<body>
    <c:forEach items="${upload}" var="item">
        ${item.name}<br/>
        <h3><a href="/ok/${item.id}/${true}">Скачать имэдж</a></h3>
        <img src="/ok/${item.id}/${false}" alt="нет изображения" width="200" height="300"><br/>
        <br/><br/>
    </c:forEach>
</body>
</html>