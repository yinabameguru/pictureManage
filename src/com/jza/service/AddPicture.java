package com.jza.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.sql.BLOB;

import com.jza.domain.Album;
import com.jza.util.DbHelper;

public class AddPicture {
	private static Connection conn = null;
	private static PreparedStatement ps  = null;
	private static ResultSet rs = null;
	
	public boolean addPicutre(int album_id,ArrayList<FileInputStream> imgs) throws SQLException, IOException {
		boolean flag =true;
		for (int i = 0; i < imgs.size(); i++) {
			
			//String sql = "update album set user_id=?,album_title=?,album_describe=?,album_date=? where album_id='29'";
			String sql = "insert into photo(album_id) values (?)";
			try {
				conn = DbHelper.getConnection();
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}		
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, album_id);
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
				String sql3="select photo_body from photo where rownum <=1 order by photo_id DESC for update";
				ps = conn.prepareStatement(sql3);
				/*DbUtil.executeQuery(sql3, null);
    		 
    		C3P0Util.release(conn, ps, null);*/
				
				ResultSet rs = ps.executeQuery(sql3);
				BLOB blob = null; 
				if(rs.next())   
				{   
					blob = (BLOB)rs.getBlob(1);   
				}
				byte[] temp = new byte[imgs.get(i).available()];
				imgs.get(i).read(temp);   
				OutputStream out = blob.getBinaryOutputStream();   
				out.write(temp);   
				imgs.get(i).close();   
				out.close();
				
				String sql2 = "update photo set photo_body = ? where photo_id = (select max(photo_id) from photo) ";
				ps = conn.prepareStatement(sql2);
				
				/*ps.setBinaryStream(1, file, length);*/
				ps.setBlob(1, blob); 
				ps.executeUpdate();
				conn.commit();
				
				String sql4="delete from photo where PHOTO_DESCRIBE ='first' and album_id=?";
				ps=conn.prepareStatement(sql4);
				ps.setInt(1, album_id);
				ps.executeUpdate();	
				conn.commit();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally{
				
				DbHelper.closeAll(null, ps, conn);
			}
		}
        
        
        
		return flag;
		
		
	}
}
