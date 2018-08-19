package com.jza.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.jza.service.AlterAlbum;

public class AlterAlbumServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
    private String savePath;
    private ServletContext sc;
    
    public void init(ServletConfig config) {
        savePath="upload";          
       sc = config.getServletContext(); 
   }
    
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*response.setContentType("text/html");
		request.getParameter("album_id");
		request.getParameter("albumTitle");
		request.getParameter("albumDate");
		request.getParameter("albumCover");
		request.getParameter("albumDescription");*/
		
		request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        int album_id = Integer.parseInt(request.getParameter("Album_id"));
//        HttpSession session = request.getSession();	
//        String name = (String)session.getAttribute("User");
        PrintWriter out = response.getWriter();
        Map<String, String> map=new HashMap<String, String>();
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (isMultipart == true) {   
            FileItemFactory factory = new DiskFileItemFactory();// 解析请求。执行解析后，所有的表单项目都保存在一个List中
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<FileItem> items = null;
            File savedFile=null;
            try {
                items = upload.parseRequest(request);
            } catch (FileUploadException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Iterator<FileItem> itr = items.iterator();
            while (itr.hasNext()) {
                FileItem item = (FileItem) itr.next();
             
                if (item.isFormField()) {
                    String fieldName = item.getFieldName();
                    map.put(fieldName, item.getString("UTF-8"));
                    
                } else {   
                     File fullFile=new File(item.getName()); 
                     savedFile=new File(sc.getRealPath("/")+savePath,fullFile.getName()); 
                              try {
                        item.write(savedFile); 
                    
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    
                }
            
        }  
        
       FileInputStream str=new FileInputStream(savedFile);
       int length=str.available();
       AlterAlbum aa=new AlterAlbum();
       Album album = new Album();
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
   	   Date date;
	try {
		date = sdf.parse(map.get("albumDate"));
       album.setAlbum_title(map.get("albumTitle"));
       album.setAlbum_date(date);
       album.setAlbum_describe(map.get("albumDescription"));
       album.setAlbum_id(album_id);
       
       boolean flag = aa.alterAlbum(album_id, album, str, length);  
       
       if(flag){
           response.sendRedirect("/pictureManage/AlterAlbumSuccess.jsp");
       }
	} catch (ParseException e) {
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
