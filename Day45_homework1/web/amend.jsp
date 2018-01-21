<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/20
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
</head>
<body>
<form action="amend" method="post">
    <table border="1">
        <tr>
            <th>员工编号</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>部门</th>
            <th>入职时间</th>
            <th>家庭住址</th>
            <th>联系电话</th>

        </tr>
        <s:iterator value="#find" var="employee">
        <tr>
            <td><input   name="employee.id" value="<s:property value="#employee.id"/>"></td>
            <td><input  name="employee.name" value="<s:property value="#employee.name"/>"></td>
            <td><input  name="employee.age" value="<s:property value="#employee.age"/>"></td>
            <td><input  name="employee.section" value="<s:property value="#employee.section"/>"></td>
            <td><input  name="employee.entrytime" value="<s:property value="#employee.entrytime"/>"></td>
            <td><input  name="employee.adress" value="<s:property value="#employee.adress"/>"></td>
            <td><input  name="employee.phone" value="<s:property value="#employee.phone"/>"></td>
        </tr>
        </s:iterator>
        <tr>
            <td><input type="submit"></td>
        </tr>
    </table>
</form>
</body>
</html>
