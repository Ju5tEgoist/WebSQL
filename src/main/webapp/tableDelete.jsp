<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yulia
  Date: 22.04.17
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WebSQL</title>
</head>
<body>
<table>
    <c:forEach items="${tabledata}"  var="data" >
        <tr>
            <td>  <c:out value="${data.key}"/></td>
            <c:forEach items="${data.value}"  var="val">
                <td><c:out value="${val}"/></td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
<form action="tableDelete" method="post">
    <table>

            <td>columnName</td>
            <td><input type="text" name="columnName"/></td>
        </tr>
        <tr>
            <td>value</td>
            <td><input type="text" name="value"/></td>
        </tr>
        <tr>
        <tr>
            <td></td>
            <td><input type="submit" value="delete_value"/></td>
        </tr>
    </table>
</form>
</body>
</html>