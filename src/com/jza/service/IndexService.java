package com.jza.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jza.domain.Album;
import com.jza.domain.User;
import com.jza.util.DbUtil;


public class IndexService {
	public Album findAlbumByUser_name(String user_name) {
		Album album = null;
		String sql = "select album_title,album_cover,album_describe from album,users where album.user_id=users.user_id and user_name=?";
		String[] params={user_name};
		ResultSet rs=DbUtil.executeQuery(sql, params);
		if (rs!=null) {		
			try {
				if(rs.next()){
					album=new Album();
					/*album.setAlbum_id(rs.getInt("album_id"));
					album.setUser_id(rs.getInt("user_id"));*/
					album.setAlbum_title(rs.getString("album_title"));
					/*album.setAlbum_cover(rs.getBlob("album_cover"));*/
					/*album.setAlbum_date(rs.getDate("album_date"));*/
					album.setAlbum_describe(rs.getString("album_describe"));
					/*album.setAlbum_type_id(rs.getInt("album_type_id"));
					album.setAlbum_type(rs.getString("album_type"));*/
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		return album;
	}
	
	public ArrayList<Album> findAllAlbum(String user_name) {
		ArrayList<Album> albums = null;
		String sql = "select * from album,users where album.user_id=users.user_id and user_name=?";
				//"select * from (select rownum no,album_view.* from album_view where rownum<=5) where no>=2 and user_name=?";
				//"select * from album,users where album.user_id=users.user_id and user_name=?";
		String[] params={user_name};
		ResultSet rs = DbUtil.executeQuery(sql, params);
		try {
			if (rs.next()) {
				albums = new ArrayList<Album>();
				do {
					Album album=new Album();
					album.setAlbum_id(rs.getInt("album_id"));
					album.setUser_id(rs.getInt("user_id"));
					album.setAlbum_title(rs.getString("album_title"));
					
					album.setAlbum_cover(rs.getBlob("album_cover"));
					album.setAlbum_date(rs.getDate("album_date"));
					album.setAlbum_describe(rs.getString("album_describe"));
					albums.add(album);					
				} while (rs.next());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return albums;
	}
	
	
	public ArrayList<Album> findPageAlbum(String user_name,int currentPage,int pageSize) {
		ArrayList<Album> albums = null;
		String sql = "select * from (select rownum no,album_view.* from album_view where rownum<="+ ((currentPage-1)*pageSize+pageSize) +" and user_name=?) where no>"+ ((currentPage-1)*pageSize);
				//"select * from (select rownum no,album_view.* from album_view where rownum<=5 and user_name=?) where no>=2";
				//"select * from album,users where album.user_id=users.user_id and user_name=?";
		String[] params={user_name};
		ResultSet rs = DbUtil.executeQuery(sql, params);
		try {
			if (rs.next()) {
				albums = new ArrayList<Album>();
				do {
					Album album=new Album();
					album.setAlbum_id(rs.getInt("album_id"));
					album.setUser_id(rs.getInt("user_id"));
					album.setAlbum_title(rs.getString("album_title"));
					album.setAlbum_cover(rs.getBlob("album_cover"));
					album.setAlbum_date(rs.getDate("album_date"));
					album.setAlbum_describe(rs.getString("album_describe"));
					albums.add(album);					
				} while (rs.next());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return albums;
	}
	public int findRowCount(String user_name) {
		String sql="select count(album_id) from album,users where album.user_id=users.user_id and user_name=?";
		String[] params={user_name};
		int rowCount = -1;
		ResultSet rs = DbUtil.executeQuery(sql, params);
		try {
			if (rs.next()) {
				rowCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowCount;
		
	}
	public int findPhotoCount(String album_id) {
		String sql="select count(photo_id) from photo where album_id=?";
		String[] params={album_id};
		ResultSet rs = DbUtil.executeQuery(sql, params);
		int photpCount = 0;
		try {
			if (rs.next()) {
				photpCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return photpCount;
	}
	public ArrayList<String> findAlbumType(String album_id) {
		String sql = "select album_type from album_type where album_id=?";
		String[] params={album_id};
		ResultSet rs = DbUtil.executeQuery(sql, params);
		ArrayList<String> types = new ArrayList<String>();
		
		try {
			while (rs.next()) {
				types.add(rs.getString(1));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return types;
	}
	
	public ArrayList<String> findAllAlbumType() {
		String sql = "select album_type from album_type";
		ResultSet rs = DbUtil.executeQuery(sql, null);
		ArrayList<String> types = new ArrayList<String>();
		
		try {
			while (rs.next()) {
				types.add(rs.getString(1));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return types;
	}
	
}
