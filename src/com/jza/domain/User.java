package com.jza.domain;

import com.jza.util.Base64Util;


public class User {

	private Integer id;
	private String name;
	private String pwd;
	public Integer getId() {
		return id;
	}
	public void setId(Integer user_id) {
		this.id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String user_name) {
		this.name = user_name;
	}
	public String getPwd() {
		return Base64Util.encode(pwd);
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}	

}
