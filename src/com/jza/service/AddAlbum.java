package com.jza.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.sql.BLOB;

import com.jza.domain.Album;
import com.jza.util.C3P0Util;
import com.jza.util.DbHelper;
import com.jza.util.DbUtil;

public class AddAlbum {
	
	private static Connection conn = null;
	private static PreparedStatement ps  = null;
	private static ResultSet rs = null;
	
	public boolean addAlbum(int user_id,Album album,FileInputStream file,int length) throws SQLException, IOException {
		boolean flag =true;
		//String sql = "update album set user_id=?,album_title=?,album_describe=?,album_date=? where album_id='29'";
		String sql = "insert into album(user_id,album_title,album_describe,album_date) values(?,?,?,?)";
		java.util.Date ud = album.getAlbum_date();
		java.sql.Date sd;
		sd = new java.sql.Date(ud.getTime());
		try {
			conn = DbHelper.getConnection();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, album.getUser_id());
			ps.setString(2, album.getAlbum_title());
			ps.setString(3, album.getAlbum_describe());
			//ps.setBinaryStream(5, file, length);
			
			
			ps.setDate(4,sd);
			ps.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{

			DbHelper.closeAll(null, ps, conn);
		}
		
		  
        try {
        	try {
				conn = DbHelper.getConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn.setAutoCommit(false); 
    		String sql3="select album_cover from album where user_id="+album.getUser_id()+" and album_title='"+album.getAlbum_title()+"' and album_describe='"+album.getAlbum_describe()+"' for update";
    		ps = conn.prepareStatement(sql3);
    		/*DbUtil.executeQuery(sql3, null);
    		 
    		C3P0Util.release(conn, ps, null);*/
    		
    		ResultSet rs = ps.executeQuery(sql3);
    		BLOB blob = null; 
			if(rs.next())   
			{   
			    blob = (BLOB)rs.getBlob(1);   
			}
			byte[] temp = new byte[file.available()];
			file.read(temp);   
	        OutputStream out = blob.getBinaryOutputStream();   
	        out.write(temp);   
	        file.close();   
	        out.close();
			
	        String sql2 = "update album set album_cover = ? where user_id="+album.getUser_id()+" and album_title='"+album.getAlbum_title()+"' and album_describe='"+album.getAlbum_describe()+"'";
	        ps = conn.prepareStatement(sql2);
			
			/*ps.setBinaryStream(1, file, length);*/
			ps.setBlob(1, blob); 
			ps.executeUpdate();
			conn.commit();
	        
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{

			DbHelper.closeAll(null, ps, conn);
		}
        
        /*File file = new File("D://iriver//sample1.bmp");   
        FileInputStream fin = new FileInputStream(file); */  

		
		
		/*String sql2 = "update album set user_id=?,album_title=?,album_describe=?,album_date=?,album_cover=? where user_id="+album.getUser_id()+" and album_title='"+album.getAlbum_title()+"' and album_describe='"+album.getAlbum_describe()+"'";
		conn = C3P0Util.getConn();
		try {
			ps = conn.prepareStatement(sql2);
			ps.setInt(1, album.getUser_id());
			ps.setString(2, album.getAlbum_title());
			ps.setString(3, album.getAlbum_describe());
			ps.setDate(4,sd);
			ps.setBinaryStream(5, file, length);
			flag=ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{

			C3P0Util.release(conn, ps, null);
		}*/
		
		
		return flag;
		
		
	}
}
