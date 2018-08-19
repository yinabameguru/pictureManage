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
import com.jza.domain.Photo;
import com.jza.service.PhotoService;
import com.jza.service.RightService;

public class PhotoServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PhotoServlet() {
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
		PrintWriter out = response.getWriter();
		String album_id = request.getParameter("album_id");
		String currentPage = request.getParameter("currentPage");
		
		PhotoService photo = new PhotoService();
		RightService rs=new RightService();
		int pageSize = 5;
		int rowCount = photo.findRowCount(Integer.valueOf(album_id));
		int pageCount=(rowCount-1)/pageSize+1;
		if (currentPage == null) {
			currentPage = "1";
		}
		ArrayList<Photo> photos = photo.findPagePhoto(Integer.valueOf(album_id), Integer.parseInt(currentPage), pageSize);
		Album album = photo.findAlbumByAlbum_id(Integer.valueOf(album_id));
		int photoCount = photo.findPhotoCount(Integer.valueOf(album_id));
		ArrayList<Album> randomAlbum=rs.findAlbumRandom();
		ArrayList<Album> newAlbums=rs.findAlbumNew();
		HttpSession session = request.getSession();
		if (photos!=null) {
			session.setAttribute("photos", photos);
		}else {
			session.setAttribute("photos", null);
		}
		
		session.setAttribute("album_id", album_id);
		session.setAttribute("currentPage", currentPage);
		session.setAttribute("pageCount", pageCount);
		request.setAttribute("photoCount", photoCount);
		session.setAttribute("album", album);
		session.setAttribute("randomAlbum", randomAlbum);
		session.setAttribute("newAlbums", newAlbums);
		
		request.getRequestDispatcher("PictureShow.jsp").forward(request, response);
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
