package com.jza.test;

import static org.junit.Assert.assertEquals;

import java.sql.ResultSet;

import org.junit.Test;

import com.jza.util.DbHelper;
import com.jza.util.DbUtil;

public class DbUtilTest {

	@Test
	public void testExecuteUpdate() throws Exception{
		String sql = "insert into users(name,pwd)values(?,?)";
		String []params={"22","123"};
		
		int res=DbUtil.executeUpdate(sql, params);
		assertEquals(1, res);

	}
	@Test
	public void testExecuteQuery() throws Exception{
		
		String sql = "select * from users";
		
		ResultSet rs=DbUtil.executeQuery(sql, null);
		
		while(rs.next()){
			
			int id=rs.getInt("id");
			String name=rs.getString("name");			
			System.out.println("id="+id);
			System.out.println("name="+name);

		}
		
		DbHelper.closeAll(rs, DbUtil.getPs(), DbUtil.getConn());
		
	}
	
	

	
	
}
