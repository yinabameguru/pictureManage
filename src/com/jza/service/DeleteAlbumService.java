package com.jza.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jza.domain.Album;
import com.jza.util.DbUtil;

public class DeleteAlbumService {
	public ArrayList<Album> findAlbumByUser_name(int user_id) {
		ArrayList<Album> albums = null;
		String sql = "select * from album_view where user_id=?";		
		String[] params={String.valueOf(user_id)};
		ResultSet rs=DbUtil.executeQuery(sql, params);
		if (rs!=null) {
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
		
		}
		
		return albums;
	}
	public void DeleteAlbumById(int album_id) {
		String sql="delete from album where album_id=?";
		String[] params={String.valueOf(album_id)};
		DbUtil.executeUpdate(sql, params);
	}
}
