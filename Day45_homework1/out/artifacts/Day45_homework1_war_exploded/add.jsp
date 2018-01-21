<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/20
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加</title>
</head>
<body>
<form action="add.action" method="post">
    <table border="1">
        <tr>
            <th>姓名</th>
            <td><input type="text" name="employee.name"/></td>

        </tr>
        <tr>
            <th>年龄</th>
            <td><input type="text" name="employee.age"/></td>

        </tr>
        <tr>
            <th>部门</th>
            <td><input type="text" name="employee.section"/></td>
        </tr>
        <tr>
            <th>入职时间</th>
            <td><input type="datetime-local" name="employee.entrytime"/></td>
        </tr>
        <tr>
            <th>家庭住址</th>
            <td><input type="text" name="employee.adress"/></td>
        </tr>
        <tr>
            <th>联系电话</th>
            <td><input type="text" name="employee.phone"/></td>
        </tr>
        <tr>
            <td><input type="submit"></td>
        </tr>
    </table>
</form>
</body>
</html>
