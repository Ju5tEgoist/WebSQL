
<%--
  Created by IntelliJ IDEA.
  User: yulia
  Date: 10.04.17
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WebSQL</title>
</head>
<body>
<form action="find" method="post">
    <table>
        <tr>
            <td>TableName</td>
            <td><input type="text" name="tName"/></td>
        </tr>
        <tr>
            <td>Limit/Offset</td>
            <td><input type="text" name="LO"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="find"/></td>
        </tr>
    </table>
</form>
</body>
</html>
