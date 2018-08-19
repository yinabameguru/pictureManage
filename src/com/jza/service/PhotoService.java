package com.jza.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jza.domain.Album;
import com.jza.domain.Photo;
import com.jza.util.DbUtil;

public class PhotoService {
	public ArrayList<Photo> findPagePhoto(Integer album_id,int currentPage,int pageSize) {
		ArrayList<Photo> photos = null;
		String sql="select * from (select rownum no,photo.* from photo where rownum<="+ ((currentPage-1)*pageSize+pageSize) +" and album_id=?) where no>0"+ ((currentPage-1)*pageSize) +"order by photo_id";
		Integer[] params = {album_id};
		ResultSet rs = DbUtil.executeQuery(sql, params);
		try {
			if (rs.next()) {
				photos = new ArrayList<Photo>();
			
			do {
				Photo photo = new Photo();
				photo.setAlbum_id(rs.getInt("album_id"));
				photo.setPhoto_id(rs.getInt("photo_id"));
				photo.setPhoto_body(rs.getBlob("photo_body"));
				photo.setPhoto_describe(rs.getString("photo_describe"));
				photos.add(photo);
				
			} while (rs.next());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return photos;
	}
	public int findRowCount(Integer album_id) {
		String sql="select count(photo_id) from photo where album_id=?";
		Integer[] params={album_id};
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
	
	public Album findAlbumByAlbum_id(int album_id) {
		String sql="select * from album where album_id=?";
		Integer[] params={album_id};
		ResultSet rs=DbUtil.executeQuery(sql, params);
		Album album=new Album();
		try {
			if (rs.next()) {
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
		return album;
	}
	
	public int findPhotoCount(int album_id) {
		String sql="select count(photo_id) from photo where album_id=?";
		Integer[] params={album_id};
		ResultSet rs = DbUtil.executeQuery(sql, params);
		int photoCount = 0;
		try {
			if (rs.next()) {
				photoCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return photoCount;
	}
	
	
	
}

