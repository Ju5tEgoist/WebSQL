<%--
  Created by IntelliJ IDEA.
  User: yulia
  Date: 19.04.17
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WebSQL</title>
</head>
<body>

Please, enter table name in which you want to change value
<form action="delete" method="post">
    <table>
        <tr>
            <td>TableName</td>
            <td><input type="text" name="tName"/></td>
        </tr>

        <tr>
            <td></td>
            <td><input type="submit" value="chooseTable"/></td>
        </tr>
    </table>
</form>
</body>
</html>
