package com.jza.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jza.domain.Album;
import com.jza.util.DbUtil;

public class SearchService {
	public ArrayList<Album> searchAlbumByTitle(String title,int currentPage,int pageSize) {
		ArrayList<Album> albums = null;
		String titlegai="";
		for (int i = 0; i < title.length(); i++)
        {
			titlegai += title.charAt(i) + "%";
        }
		String sql = "select * from (select rownum no,album_view.* from album_view where rownum<="+ ((currentPage-1)*pageSize+pageSize) +" and album_title like '%"+titlegai+"') where no>"+ ((currentPage-1)*pageSize);

		ResultSet rs = DbUtil.executeQuery(sql, null);
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
	
	public int findRowCount(String title) {
		
		String titlegai = "";
		for (int i = 0; i < title.length(); i++)
        {
			titlegai += title.charAt(i) + "%";
        }
		
		String sql="select count(album_id) from album_view where album_title like '%"+titlegai+"'";

		int rowCount = -1;
		ResultSet rs = DbUtil.executeQuery(sql, null);
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
}
