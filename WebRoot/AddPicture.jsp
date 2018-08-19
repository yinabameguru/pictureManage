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
	

  </head>
  <form name="form1" action="/pictureManage/NewAlbumServlet?user_id=" method="post" enctype="multipart/form-data">

    <table align="center">
    
    <tr>
    <td>标题：</td>
    <td><input type="text" name="albumTitle" ></td>
    </tr>
    <tr>
    <td>日期：</td>
    <td><input type="date" name="albumDate" ></td>
    </tr>
    <tr>
    <td>封面：</td>
    <td><input type="file"  name="albumCover" multiple="multiple" accept="image/*"></td>
    </tr>
    <tr>
    <td>描述：</td>
    <td><input type="text" name="albumDescription" ></td>
    </tr>
    <tr>
    <td><input type="submit"></td>
    </tr> 
    </table>
   </form> 
  <body>  
     
</body>  
</html>
