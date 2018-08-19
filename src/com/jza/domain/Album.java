package com.jza.domain;

import java.sql.Blob;
import java.util.Date;



public class Album {
	private Integer user_id;
	private String album_title;
	private Blob album_cover;
	private Date album_date;
	private String album_describe;
	private Integer album_id;
	/*private Integer album_type_id;
	private String album_type;*/
	/*public Integer getAlbum_type_id() {
		return album_type_id;
	}
	public void setAlbum_type_id(Integer album_type_id) {
		this.album_type_id = album_type_id;
	}
	public String getAlbum_type() {
		return album_type;
	}
	public void setAlbum_type(String album_type) {
		this.album_type = album_type;
	}*/

	public Integer getAlbum_id() {
		return album_id;
	}
	public void setAlbum_id(Integer album_id) {
		this.album_id = album_id;
	}
	
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	
	public String getAlbum_title() {
		return album_title;
	}
	public void setAlbum_title(String album_title) {
		this.album_title = album_title;
	}
	public Blob getAlbum_cover() {
		return album_cover;
	}
	public void setAlbum_cover(Blob album_cover) {
		this.album_cover = album_cover;
	}
	public Date getAlbum_date() {
		return album_date;
	}
	public void setAlbum_date(Date album_date) {
		this.album_date = album_date;
	}
	public String getAlbum_describe() {
		return album_describe;
	}
	public void setAlbum_describe(String album_describe) {
		this.album_describe = album_describe;
	}
	

}
