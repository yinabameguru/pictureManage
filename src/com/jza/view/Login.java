package com.jza.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {

	public Login() {
		super();
	}


	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String errMsg=(String) request.getAttribute("err");

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>MyPicture</title>");
		out.println("<style type='text/css'>");
		out.println("#bg {");
		out.println("margin: 180px auto;");
		out.println("background: url('img/bg.png');");
		out.println("}");
		out.println("#top{");
		out.println("margin:auto;");
		out.println("font-size:23px;");
		out.println("height: 20px;");
		out.println("width: 85px;");
		out.println("}");
		out.println("#Lose{");
		out.println("font-size:12px;");
		out.println("}");
		out.println("#User{");
		out.println("margin-left:15px;");
		out.println("}");
		out.println("#Password{");
		out.println("margin-left:15px;");
		out.println("}");
		out.println("#Code{");
		out.println("margin-left:15px;");
		out.println("}");
		
		
		
		out.println("#LogIn{");
		out.println("height: 25px;");
		out.println("width: 57px;");
		out.println("margin-left:80px;");
		out.println("background-color:transparent;");
		out.println("font-size:20px;");
		out.println("font-weight:500;");
		out.println("}");
		out.println("#Lose{");
		out.println("margin-left:170px;");
		out.println("color:#000000;");
		out.println("}");

		out.println("</style>");
		
		out.println("<script type='text/javascript'>");
		out.println("function changeCode(){");
		out.println("var img = document.getElementsByTagName('img')[0];");
		out.println("img.src = '/pictureManage/CodeServlet?time='+new Date().getTime();");
		out.println("}");
		out.println("</script>");

		
		out.println("</head>");
		out.write("<form method='post' action='/pictureManage/LoginServlet'>");			
		out.println("<body>");
		out.println("<div id='bg' style='height: 370px; width: 296px;'>");
		out.println("<p>&nbsp;</p>");
		out.println("<p>&nbsp;</p>");
		out.println("<div id='top'>");
		out.println("<span id='Title'>请&nbsp;登&nbsp;陆</span>");
		out.println("</div>");
		out.println("<p>");
		out.println("<span id='User'>账&nbsp;&nbsp;&nbsp;号：</span>");
		out.println("<input name='User' type='text' name='User'>");
		out.println("</p>");
		out.println("<p>");
		out.println("<span id='Password'>密&nbsp;&nbsp;&nbsp;码：</span>");
		out.println("<input  type='password' name='Password'>");
		out.println("</p>");
		out.println("<div style='height: 25px;  float: left;'>");
		out.println("<span id='Code'>验证码：</span>");
		out.println("<input  type='text' id='Code' name='Code' style='width: 30px; margin-left:0px;'>");
		out.println("</div>");
		out.println("<img src='/pictureManage/CodeServlet'style=' margin-left:5px;'onclick='changeCode()'/>");
		out.println("<a href='javascript:changeCode()'>换一张</a><br />");				
		if(errMsg!=null) out.write(errMsg);
		
		out.println("<br /><input type='submit' value='登录' id='LogIn' style='height:36px;width:106px;' id='CodeImg'/><br>");
		out.println("<a id='Lose' href='/pictureManage/Register'>注册</a>");
		out.println("</div>");
		out.write("</form>");
		out.println("</body>");
		out.println("</html>");		
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
