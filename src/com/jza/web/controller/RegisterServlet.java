package com.jza.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jza.domain.User;
import com.jza.service.UserService;

public class RegisterServlet extends HttpServlet {


	public RegisterServlet() {
		super();
	}


	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("User");
		String password = request.getParameter("Password");
		String checkPwd = request.getParameter("CheckPassword");
		UserService us = new UserService();		
		User user = us.findUserByName(name);
		if(user!=null)
		{
			String errName="用户名已存在";			
			request.setAttribute("errName", errName);
			request.getRequestDispatcher("/Register").forward(request, response);
		}
		else {
			if(password.length()<6)
			{
				String errPassword="密码长度小于6，请重新输入";			
				request.setAttribute("errPassword", errPassword);
				request.getRequestDispatcher("/Register").forward(request, response);
			}
			else{
				if(password.equals(checkPwd))
				{
					UserService.addUser(name,password);
					response.getWriter().write("注册成功，3秒后返回登录界面");
					response.setHeader("refresh", "3;url=/pictureManage");
				}
				else {
					String errCheckPwd="两次输入密码不相同，请重新输入";			
					request.setAttribute("errCheckPwd", errCheckPwd);
					request.getRequestDispatcher("/Register").forward(request, response);
				}
			}
		}
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		this.doGet(request, response);
	}


	public void init() throws ServletException {
		// Put your code here
	}

}
