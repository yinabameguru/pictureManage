package com.jza.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.jza.domain.Album;
import com.jza.service.AddAlbum;
import com.jza.service.AddPicture;

public class AddPictureServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
    private String savePath;
    private ServletContext sc;
    
    public void init(ServletConfig config) {
        savePath="upload";          
       sc = config.getServletContext(); 
   }
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String album_id = request.getParameter("album_id");
        PrintWriter out = response.getWriter();
        Map<String, String> map=new HashMap<String, String>();
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (isMultipart == true) {   
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<FileItem> items = null;
            File savedFile=null;
            FileInputStream str=null;
            int length=0;
            try {
                items = upload.parseRequest(request);
            Iterator<FileItem> itr = items.iterator();
            ArrayList<FileInputStream> imgs = new ArrayList<FileInputStream>();
            while (itr.hasNext()) {
                FileItem item = (FileItem) itr.next();
                if (item.isFormField()) {}
                else {
					 
                     File fullFile=new File(item.getName()); 
                     savedFile=new File(sc.getRealPath("/")+savePath,fullFile.getName()); 

                        try {
							item.write(savedFile);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
                    
                     str=new FileInputStream(savedFile);
//                     length=str.available();//获取输入流的长度；       
                     imgs.add(str);
                }
                                                
 }  
     
       AddPicture add2 = new AddPicture();

       //boolean flag = add.addAlbum(Integer.parseInt(user_id),imgs);
       boolean flag = add2.addPicutre(Integer.parseInt(album_id), imgs);
       
       if(flag){
    	   request.getRequestDispatcher("/PhotoServlet?album_id="+album_id).forward(request, response);
       }
            } catch (FileUploadException e) {
            	// TODO Auto-generated catch block
            	e.printStackTrace();
            } catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   
    } else {
        out.print("the enctype must be multipart/form-data");
    }
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
