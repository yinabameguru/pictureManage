package com.jza.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class DbUtil {
	private static Connection conn = null;
	private static PreparedStatement ps  = null;
	private static ResultSet rs = null;
	
	
	public static Connection getConn() {
		return conn;
	}

	public static PreparedStatement getPs() {
		return ps;
	}
	
public static int  executeUpdate(String sql, Object[] parameters) {
		
		int res = 0;
		
		try {
			conn = DbHelper.getConnection();
			ps = conn.prepareStatement(sql);
			if (parameters != null) {
				for (int i = 0; i < parameters.length; i++) {
					ps.setObject(i + 1, parameters[i]);
				}
				res = ps.executeUpdate();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{

			DbHelper.closeAll(null, ps, conn);
		}		
		return res;
	}
	
	
	
	public static ResultSet executeQuery(String sql, Object [] parameters) {
		try {
			conn = DbHelper.getConnection();
			ps = conn.prepareStatement(sql);
			if (parameters != null) {

				for (int i = 0; i < parameters.length; i++) {
					ps.setObject(i + 1, parameters[i]);
				}
			}		

			rs = ps.executeQuery();
			conn.commit();
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	/*public static int  executeUpdate(String sql, Object[] parameters) {
		
		int res = 0;
		
		try {
			conn = C3P0Util.getConn();
			ps = conn.prepareStatement(sql);
			if (parameters != null) {
				for (int i = 0; i < parameters.length; i++) {
					ps.setObject(i + 1, parameters[i]);
				}
				res = ps.executeUpdate();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{

			C3P0Util.release(conn, ps, null);
		}		
		return res;
	}
	
	
	
	public static ResultSet executeQuery(String sql, Object [] parameters) {
		try {
			conn = C3P0Util.getConn();
			ps = conn.prepareStatement(sql);
			if (parameters != null) {

				for (int i = 0; i < parameters.length; i++) {
					ps.setObject(i + 1, parameters[i]);
				}
			}		

			rs = ps.executeQuery();
			conn.commit();
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}*/
}
