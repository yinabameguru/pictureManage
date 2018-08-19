package com.jza.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jza.domain.Album;
import com.jza.service.IndexService;

public class AlbumCover0Servlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AlbumCover0Servlet() {
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
		HttpSession session = request.getSession();
		String name = (String)session.getAttribute("User");
		ArrayList<Album> albums = (ArrayList<Album>)session.getAttribute("albums");
		/*String currentPage = (String)session.getAttribute("currentPage");
		String pageCount = (String)session.getAttribute("pageCount");*/
		if (albums.size()>0) {
		Album a=albums.get(0);
		try {
			InputStream is = a.getAlbum_cover().getBinaryStream();
			response.setContentType("text/html");
			 OutputStream os = response.getOutputStream();
			   int num;
			   byte buf[] = new byte[1024];
			  
			   while(   (num=is.read(buf))!=-1   ){
			    os.write(buf, 0, num);
			    
			   }
			   
			   is.close();
			   os.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

		/*response.setContentType("text/html");
		HttpSession session = request.getSession();
		String name = (String)session.getAttribute("User");
		IndexService index = new IndexService();
		ArrayList<Album> album = index.findAllAlbum(name);
		if (album.size()>0) {
			Album a = album.get(0);
			try {
				InputStream is = a.getAlbum_cover().getBinaryStream();
				
				 response.setContentType("text/html");
				 OutputStream os = response.getOutputStream();
				   int num;
				   byte buf[] = new byte[1024];
				  
				   while(   (num=is.read(buf))!=-1   ){
				    os.write(buf, 0, num);
				   }
				   
				   is.close();
				   os.close();				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		
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
