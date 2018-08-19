package com.jza.domain;

import java.sql.Blob;

public class Photo {
	private Integer photo_id;
	private Integer album_id;
	private String photo_describe;
	private Blob photo_body;
	public Integer getPhoto_id() {
		return photo_id;
	}
	public void setPhoto_id(Integer photo_id) {
		this.photo_id = photo_id;
	}
	public Integer getAlbum_id() {
		return album_id;
	}
	public void setAlbum_id(Integer album_id) {
		this.album_id = album_id;
	}
	public String getPhoto_describe() {
		return photo_describe;
	}
	public void setPhoto_describe(String photo_describe) {
		this.photo_describe = photo_describe;
	}
	public Blob getPhoto_body() {
		return photo_body;
	}
	public void setPhoto_body(Blob photo_body) {
		this.photo_body = photo_body;
	}
	
	
}
