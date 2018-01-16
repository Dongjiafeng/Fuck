<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/16
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <style type="text/css">

    </style>
</head>
<body>
    <form action="register.action" method="post">
        用户名:<input type="text" name="username"><s:fielderror fieldName="user.username"/><br>
        密码:<input type="text" name="password"><s:fielderror fieldName="user.password"/><br>
        确认密码:<input type="text" name="repassword"><s:fielderror fieldName="repassword"/><br>
        电话号码:<input type="text" name="phone"><s:fielderror fieldName="user.phone"/><br>
        邮箱:<input type="text" name="email"><s:fielderror fieldName="user.email"/><br>
        <input type="submit" value="注册">
    </form>

</body>
</html>