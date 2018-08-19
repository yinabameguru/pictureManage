package com.jza.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jza.service.DeletePhotoService;

public class DeletePhotoServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DeletePhotoServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("content-type","text/html;charset=UTF-8");
		int photo_id = Integer.parseInt(request.getParameter("Photo_id"));
		int currentPage=Integer.parseInt(request.getParameter("currentPage"));
		int album_id=Integer.parseInt(request.getParameter("album_id"));
		
		DeletePhotoService dps = new DeletePhotoService();
		dps.deletePhotoByPhoto_Id(photo_id);
		
		/*request.setAttribute("photo_id", photo_id);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("album_id", album_id);
		request.setAttribute("date", date);
		request.setAttribute("title", title);
		request.setAttribute("photoCount", photoCount);
		request.setAttribute("album_describe", album_describe);*/
		//response.sendRedirect("/PhotoServlet?Photo_id="+photo_id+"&currentPage="+currentPage+"&album_id="+album_id);  
		request.getRequestDispatcher("/PhotoServlet?Photo_id="+photo_id+"&currentPage="+currentPage+"&album_id="+album_id).forward(request, response);
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
