package com.jza.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jza.domain.User;
import com.jza.util.DbUtil;



public class UserService {
	public  User findUserByName(String name) {
		
		User user=null;
		
		String sql="select * from users where user_name=?";
		String[] params={name};
		
		ResultSet rs=DbUtil.executeQuery(sql, params);
		if (rs!=null) {		
			try {
				if(rs.next()){
					user=new User();
					user.setId(rs.getInt("user_id"));
					user.setName(rs.getString("user_name"));
					user.setPwd(rs.getString("pwd"));
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
		}
		return user;
	}
	public static void addUser(String name ,String pwd) {
		String sql="INSERT INTO Users(user_name,pwd) VALUES (?,?)";
		String[] params={name,pwd};
		DbUtil.executeUpdate(sql, params);
		
	}
}










