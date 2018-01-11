<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>图书列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	body {
		font-size: 10pt;
	}
	.icon {
		margin:10px;
		border: solid 2px gray;
		width: 160px;
		height: 180px;
		text-align: center;
		float: left;
	}
</style>
      <script src="../../js/jquery-3.2.1.min.js"></script>
  </head>
  
  <body>

  <c:forEach items="${requestScope.book}" var="books" step="1">
      <div class="icon">
          <a href="<c:url value='/cart?method=findbook&bid=${books.bid}'/>"><img src="<c:url value='${books.image}'/>" border="0"/></a>
          <br/>
          <a href="<c:url value='/cart?method=findbook&bid=${books.bid}'/>">${books.bname}</a>
      </div>
  </c:forEach>

<c:forEach items="${requestScope.bookse}" step="1" var="se">
  <div class="icon">
      <a href="<c:url value='/cart?method=findbook&bid=${se.bid}'/>"><img src="<c:url value='${se.image}'/>" border="0"/></a>
      <br/>
   	<a href="<c:url value='/cart?method=findbook&bid=${se.bid}'/>">${se.bname}</a>
  </div>
</c:forEach>

<c:forEach items="${requestScope.bookee}" step="1" var="ee">
  <div class="icon">
      <a href="<c:url value='/cart?method=findbook&bid=${ee.bid}'/>"><img src="<c:url value='${ee.image}'/>" border="0"/></a>
      <br/>
   	<a href="<c:url value='/cart?method=findbook&bid=${ee.bid}'/>">${ee.bname}</a>
  </div>
</c:forEach>

<c:forEach items="${requestScope.bookLe}" step="1" var="Le">
  <div class="icon">
      <a href="<c:url value='/cart?method=findbook&bid=${Le.bid}'/>"><img src="<c:url value='${Le.image}'/>" border="0"/></a>
      <br/>
   	<a href="<c:url value='/cart?method=findbook&bid=${Le.bid}'/>">${Le.bname}</a>
  </div>
</c:forEach>
  </body>



 
</html>

