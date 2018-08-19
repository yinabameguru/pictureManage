package com.jza.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;

import com.jza.domain.User;
import com.jza.service.UserService;
import com.jza.util.Base64Util;
import com.jza.util.DbHelper;
import com.jza.util.DbUtil;


public class LoginServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		String name=request.getParameter("User");
		String password=request.getParameter("Password");
		String code=request.getParameter("Code");
		HttpSession session = request.getSession();
		String Code = (String) session.getAttribute("code");
		session.setAttribute("User", name);
		
		
		UserService us = new UserService();		
		User user = us.findUserByName(name);

		if (user!=null&&Base64Util.encode(password).equals(user.getPwd())) {
			if(Code.equals(code))
			{
				int user_id = user.getId();
				session.setAttribute("user_id", user_id);
				request.getRequestDispatcher("/IndexServlet").forward(request, response);
			}
			else {
				String errMsg="验证码错误";			
				request.setAttribute("err", errMsg);
				request.getRequestDispatcher("/Login").forward(request, response);
			}
		}else {
			String errMsg="用户名或密码不正确";			
			request.setAttribute("err", errMsg);
			request.getRequestDispatcher("/Login").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}



}
