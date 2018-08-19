package com.jza.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {


	public Register() {
		super();
	}


	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String errName=(String) request.getAttribute("errName");
		String errPassword=(String) request.getAttribute("errPassword");
		String errCheckPwd=(String) request.getAttribute("errCheckPwd");
		response.setContentType("text/html;charset=utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title></title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form method='post' action='/pictureManage/RegisterServlet'>");
		out.println("<span>请输入账号：</span>");
		out.println("<input type='text' name='User'/>");
		if(errName!=null) out.write(errName);
		out.println("<br />");
		out.println("<span>请输入密码：</span>");
		out.println("<input type='password' name='Password' />");
		if(errPassword!=null) out.write(errPassword);
		out.println("<br />");
		out.println("<span>请确认密码：</span>");
		out.println("<input type='password' name='CheckPassword' />");
		if(errCheckPwd!=null) out.write(errCheckPwd);
		out.println("<br />");
		out.println("<input type='submit' name='Register' value='注册' />");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");

		
		

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		this.doGet(request, response);

	}

	public void init() throws ServletException {
		// Put your code here
	}

}
