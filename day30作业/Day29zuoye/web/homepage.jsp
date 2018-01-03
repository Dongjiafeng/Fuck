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
<%
    if(session.getAttribute("user")!=null){
        User user = (User)session.getAttribute("user");
        session.setAttribute("username",user.getUsername());
        out.write("登录成功");
%>
<table style="border: 1px solid black;text-align: center"></table>
<%
}else {
    out.write("请先登录");
%>
<br>
<a href="http://localhost:8080/index.jsp">点击去登录</a>
<%
    }
%>

<input type = "button" name="exit" value="退出">

</body>
<script type="text/javascript">
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
                                .append($('<td>').append($('<a href="showBook.jsp">'+obj['bookName']+'</a>')))
                                .append($('<td>').text(obj['writer']))
                                .append($('<td>').text(obj['money'])));
                    })
                }
            }
        })

</script>
</html>