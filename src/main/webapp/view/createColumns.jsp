<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yulia
  Date: 15.04.17
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WebSQL</title>
</head>
<body>
<form action="createColumns" method="post">
    <table>
        <tr>
            <td>ColumnName</td>
            <td><input type="text" name="cName"/></td>
        </tr>
        <tr>
        <tr>
            <td></td>
            <td><input type="submit" value="createColumn"/></td>
        </tr>
    </table>
</form>
</body>
</html>
