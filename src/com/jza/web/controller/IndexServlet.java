package com.jza.web.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jza.domain.Album;
import com.jza.service.IndexService;
import com.jza.service.RightService;


public class IndexServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public IndexServlet() {
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
		
		String name = request.getParameter("User");
		String currentPage = request.getParameter("currentPage");
		/*Integer user_id = (Integer)request.getAttribute("user_id");*/
		IndexService index = new IndexService();
		RightService rs=new RightService();
		int pageSize = 4;
		int rowCount = index.findRowCount(name);
		int pageCount=(rowCount-1)/pageSize+1;
		if (currentPage == null) {
			currentPage = "1";
		}
		
		ArrayList<Album> album = index.findPageAlbum(name, Integer.parseInt(currentPage), pageSize);
		ArrayList<Album> randomAlbum=rs.findAlbumRandom();
		ArrayList<Album> newAlbums=rs.findAlbumNew();
		/*for (int i = 0; i < album.size(); i++) {
			Album a = album.get(i);
			out.write(a.getAlbum_cover());
		}*/
		HttpSession session = request.getSession();		
		session.setAttribute("User", name);
		session.setAttribute("albums", album);
		session.setAttribute("randomAlbum", randomAlbum);
		session.setAttribute("newAlbums", newAlbums);
		session.setAttribute("currentPage", currentPage);
		session.setAttribute("pageCount", pageCount);
		session.setAttribute("searchCount", "bb");
		/*session.setAttribute("user_id", user_id);*/
		request.getRequestDispatcher("/Index.jsp").forward(request, response);
		
		
		/*out.write(album.getAlbum_describe());
		out.write(album.getAlbum_title());*/
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
