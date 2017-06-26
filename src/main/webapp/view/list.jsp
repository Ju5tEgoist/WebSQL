<%--
  Created by IntelliJ IDEA.
  User: yulia
  Date: 10.04.17
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>WebSQL</title>
</head>
<body>
List of all available tables: <br>
<c:forEach items="${items}"  var="item" >
    <a href="${item}">${item}</a> <br>
</c:forEach>
<p></p>>
<jsp:include page="footer.jsp" />
</body>
</html>
