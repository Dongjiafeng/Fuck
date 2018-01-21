<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/20
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="queryAll.action" method="post">
    <table border="1px">
        <tr>
            <th>id</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>部门</th>
            <th>入职时间</th>
            <th>家庭住址</th>
            <th>电话号码</th>
            <th>修改</th>
        </tr>
        <s:iterator value="#request.employee" var="e1">

            <tr>
                <td><s:property value="#e1.id"/></td>
                <td><s:property value="#e1.name"/></td>
                <td><s:property value="#e1.age"/></td>
                <td><s:property value="#e1.section"/></td>
                <td><s:property value="#e1.entrytime"/></td>
                <td><s:property value="#e1.adress"/></td>
                <td><s:property value="#e1.phone"/></td>
                <td><a href="<s:url action="find"><s:param name="texts" value="#e1.id"/></s:url> ">修改</a> </td>
            </tr>
        </s:iterator>
    </table>


</form>
</body>
</html>
