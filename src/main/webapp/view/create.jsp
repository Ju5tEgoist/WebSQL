<%--
  Created by IntelliJ IDEA.
  User: yulia
  Date: 15.04.17
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WebSQL</title>
</head>
<body>
<form action="create" method="post">
    <table>
        <tr>
            <td>TableName</td>
            <td><input type="text" name="tName"/></td>
        </tr>
        <tr>
            <td>ColumnsNumber</td>
            <td><input type="text" name="cNumber"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="create"/></td>
        </tr>
    </table>
</form>
</body>
</html>
