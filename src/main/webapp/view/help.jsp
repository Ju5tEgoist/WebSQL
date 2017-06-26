<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SQLCmd</title>
</head>
<body>
All available command: <br>
<c:forEach items="${items}"  var="item" >
    <a href="${item.key}">${item.key}</a> - ${item.value} <br>
</c:forEach>
</body>
</html> 