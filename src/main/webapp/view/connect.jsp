
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>SQLCmd</title>
</head>
<body>

<form method="POST" action="connect" >
    <table>
        <tr>
            <td>Database name</td>
            <td><input type="text" name="dbName"/></td>
        </tr>
        <tr>
            <td>User name</td>
            <td><input type="text" name="userName"/></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="connect"/></td>
        </tr>
    </table>
</form>
<%--<%@include file="footer.jsp" %>--%>
</body>
</html>