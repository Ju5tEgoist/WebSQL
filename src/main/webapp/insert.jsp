<%--
  Created by IntelliJ IDEA.
  User: yulia
  Date: 23.04.17
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WebSQL</title>
</head>
<body>
Enter target table name to add row
<form action="insert" method="post">
    <table>
        <tr>
            <td>TableName</td>
            <td><input type="text" name="tName"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="choose"/></td>
        </tr>
    </table>
</form>
</body>
</html>
