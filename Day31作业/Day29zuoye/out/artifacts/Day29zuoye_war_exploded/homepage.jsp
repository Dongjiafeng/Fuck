<%@ page import="homework.users.User" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/1/4
  Time: 0:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script src="libs/jquery-3.2.1.min.js"></script>
</head>
<body>
<%--<h2>用户名：<span id="username"></span></h2>--%>
<%--<h2>密码：<span id="password"></span></h2>--%>
<%
    if(session.getAttribute("user")!=null){
        User user = (User)session.getAttribute("user");
        session.setAttribute("username",user.getUsername());
        session.setAttribute("password",user.getPassword());
        out.write("登录成功");
%>
<table style="border: 1px solid black;text-align: center"></table>
<%=session.getAttribute("username")%>
<%=session.getAttribute("password")%>
<%
}else {
    out.write("请先登录");
%>
<br>
<a href="http://localhost:8080/index.jsp">点击去登录</a>
<br>
<a href="http://localhost:8080/Reigster.html">点击去注册</a>
<%
    }
%>

<input type = "button" name="exit" value="退出">

</body>
<script type="text/javascript">
//    $.getJSON("http://localhost:8080/homepage",
//        function (json,status) {
//            if(status == "success"){
//                $('#username').text(json['username']);
//                $('#password').text(json['password']);
//            }
//        })
    $.getJSON("http://localhost:8080/homepage",
        function (data, status) {
            if(status=="success"){
                if(data!=null){
                    $('table')
                        .append($('<tr>')
                            .append($('<th>').text("书名"))
                            .append($('<th>').text("作者"))
                            .append($('<th>').text("价格")));
                    $.each(data,function (index,obj){
                        $('table')
                            .append($('<tr>')
                                .append($('<td>').text(obj['bookName']))
                                .append($('<td>').text(obj['author']))
                                .append($('<td>').text(obj['price'])));
                    })
                }
            }
        })

</script>
</html>