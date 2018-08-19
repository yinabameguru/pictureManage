<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>MyPicture</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="./js/jiao.js"></script>

  </head>
  <%
  String name = (String)session.getAttribute("User");
  %>
  <body onload="startSecond('<%=name%>');">
    	相册创建成功!!!
    <a href="/pictureManage/IndexServlet?currentPage=1&User=<%=name %>" style="color:blue;"><span id="second">3</span></a>秒后自动转跳回首页
  	<br>如果未自动跳转
  	<a href="/pictureManage/IndexServlet?currentPage=1&User=<%=name %>"style="color:blue;">点击这里</a>回到首页
  </body>
</html>
