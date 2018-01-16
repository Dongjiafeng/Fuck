<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/16
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
<form action="login.action" method="post">
    帐号:<input type="text" name="username"><s:fielderror fieldName="user.username"/><br>
    密码:<input type="text" name="password"><s:fielderror fieldName="user.password"/><br>
    <input type="submit" value="登录">

</form>
</body>
</html>
