<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%@include file="header.jsp"%><br/><br/>

    <%--multipart/form-data - параметр для передачи двоичных данных--%>
    <form:form method="post" enctype="multipart/form-data" modelAttribute="uploadedFile" action="uploadFile">
        <table>
            <tr>
                <td>Upload File:</td>
                <td><input type="file" name="file" /></td>
                <%--<td style="color: red; font-style: italic;">--%>
                <form:errors path="file" /></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Upload" /></td>
                <td></td>
            </tr>
        </table>
    </form:form>
</body>
</html>
