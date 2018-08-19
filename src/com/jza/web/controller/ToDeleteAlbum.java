package com.jza.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jza.domain.Album;
import com.jza.service.DeleteAlbumService;
import com.jza.service.RightService;

public class ToDeleteAlbum extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ToDeleteAlbum() {
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

		response.setContentType("text/html");
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		DeleteAlbumService das=new DeleteAlbumService();
		RightService rs=new RightService();
		ArrayList<Album> albums = das.findAlbumByUser_name(user_id);
		ArrayList<Album> randomAlbum=rs.findAlbumRandom();
		ArrayList<Album> newAlbums=rs.findAlbumNew();
		request.setAttribute("Albums", albums);
		HttpSession session = request.getSession();	
		session.setAttribute("randomAlbum", randomAlbum);
		session.setAttribute("newAlbums", newAlbums);
		request.getRequestDispatcher("/DeleteAlbum.jsp").forward(request, response);
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
