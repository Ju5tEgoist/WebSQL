<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yulia
  Date: 23.04.17
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WebSQL</title>
</head>
<body>
<form action="insertColumns" method="post">
    <table>
        <tr>
            <td>New_value</td>
            <td><input type="text" name="value"/></td>
        </tr>
        <tr>
        <tr>
            <td></td>
            <td><input type="submit" value="change"/></td>
        </tr>
    </table>
</form>
</body>
</html>
