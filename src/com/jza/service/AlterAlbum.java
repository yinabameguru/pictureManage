package com.jza.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import oracle.sql.BLOB;

import com.jza.domain.Album;
import com.jza.util.DbHelper;
import com.jza.util.DbUtil;

public class AlterAlbum {
	
	private static Connection conn = null;
	private static PreparedStatement ps  = null;
	private static ResultSet rs = null;
	
	public Album findAlbumByAlbum_id(int album_id) {
		Album album = null;
		String sql = "select * from album_view where album_id=?";
		String[] params={String.valueOf(album_id)};
		ResultSet rs=DbUtil.executeQuery(sql, params);
		if (rs!=null) {		
			try {
				if(rs.next()){
					album=new Album();
					album.setAlbum_id(rs.getInt("album_id"));
					album.setUser_id(rs.getInt("user_id"));
					album.setAlbum_title(rs.getString("album_title"));
					album.setAlbum_cover(rs.getBlob("album_cover"));
					album.setAlbum_date(rs.getDate("album_date"));
					album.setAlbum_describe(rs.getString("album_describe"));
					
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		return album;
	}
	public boolean alterAlbum(int album_id, Album album,FileInputStream file,int length) throws SQLException, IOException {
		boolean flag =true;
		String sql = "update album set album_title=?,album_date=?,album_describe=? where album_id=?";
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
			ps.setString(1, album.getAlbum_title());
			ps.setDate(2,sd);
			ps.setString(3, album.getAlbum_describe());
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
    		String sql3="select album_cover from album where album_id ="+album_id+" for update";
    		ps = conn.prepareStatement(sql3);  		
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
			
	        String sql2 = "update album set album_cover = ? where album_id = "+album_id;
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

		return flag;
		
		
	}
}
