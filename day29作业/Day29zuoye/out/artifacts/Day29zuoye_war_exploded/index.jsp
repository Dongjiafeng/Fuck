<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/2
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>欢迎来到唐僧云</title>
    <style type="text/css">
      *{
        margin:0;
        padding: 0;
      }
      body{
        width: 100%;
        height: 100%;

      }
      .top{
        height: 10%;
        width: 100%;
      }
      .top ul{
        list-style: none;
        float: right;
        position: relative;
        top: 18px;
      }
      .top ul li{
        float: left;
        font-size: 22px;
        padding-right: 15px;
      }
      .bottom{
        height: 90%;
        width: 100%;
        float: right;
        background-color: skyblue;
      }
      .bottom img{
        position: relative;
        left: 300px;
        top:250px;
      }
      .box{
        width: 560px;
        height: 665px;
        background-color: azure;
        position: relative;
        left: 55%;
        top:-300px;
      }
      .box h1{
        text-align: center;
        padding-top: 30px;
      }
      .box form input{
        width: 500px;
        height: 50px;
        margin-top: 50px;
        position: relative;
        left: 30px;
        font-size: 20px;
        border: black;
      }
      .box form input#s1{
        margin-top: 150px;
      }

      .box form span{

        margin-left: 41px;

      }
      .box form span#s2{
        margin-left: 260px;
      }
      #time{
        margin-left: 1700px;
      }
    </style>
    <script type="text/javascript">
        function showOnfocus() {
            var haha = document.getElementById("haha");
            haha.style.fontSize = "25px";
            haha.style.border = "1px solid red";


        }
        function showOnblur() {
            var haha = document.getElementById("haha");
            haha.style.fontSize="20px";
            haha.style.border ="black";
        }

    </script>
  </head>
  <body>
  <div id="time"></div>
  <script>
      setInterval("document.getElementById('time').innerHTML = new Date().toLocaleString();", 1000);

  </script>

  <div class="top">
    <img src="../img/4.png">
    <ul>
      <li>网易云首页</li>
      <li>|</li>
      <li>帮助文档</li>
    </ul>
  </div>
  <div class="bottom" id="bottom">
    <img src="../img/123.jpg">
    <div class="box">
      <h1>唐僧登录</h1>
      <form action="show" method="post">
        <input type="text"  id="haha" placeholder="唐僧账号/唐僧邮箱账号"
               onfocus="showOnfocus(this)" onblur="showOnblur(this)">

        <br/>
        <input type="password" placeholder="登录密码">

        <input
                type="submit" value="登   录" id="s1" >
        <span>还没有账号?<a href="Reigster.html">
                    免费注册</a></span>
        <span id="s2"><a href="Reigster.html">忘记密码</a></span>
      </form>
    </div>
  </div>
  </body>
</html>
