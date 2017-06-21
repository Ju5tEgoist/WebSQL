<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yulia
  Date: 26.04.17
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WebSQL</title>
</head>
<body>
<jsp:include page="table.jsp" />
<form action="updateValue" method="post">
    <table>
        <tr>
            <td>Column</td>
            <td><input type="text" name="column"/></td>
        </tr>
        <tr>
            <td>Old_value</td>
            <td><input type="text" name="oldValue"/></td>
        </tr>
        <tr>
            <td>New_value</td>
            <td><input type="text" name="newValue"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="change"/></td>
        </tr>
    </table>
</form>
</body>
</html>
