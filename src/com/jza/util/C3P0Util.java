package com.jza.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {

	private static ComboPooledDataSource cpds = new ComboPooledDataSource();
	static {
		try {
			cpds.setDriverClass("oracle.jdbc.driver.OracleDriver");
			/*cpds.setJdbcUrl("jdbc:mysql://localhost:3306/test");*/
			cpds.setJdbcUrl("jdbc:oracle:thin:@192.168.137.129:1521:jza");
			cpds.setUser("SCOTT");
			cpds.setPassword("jjj642328789");
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConn() {

		Connection connection = null;

		try {
			connection = cpds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return connection;
		}
	}

	public static void release(Connection conn, Statement stmt, ResultSet rs) {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				rs = null; // 垃圾回收，上！
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				stmt = null; // 垃圾回收，上！
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				conn = null; // 垃圾回收，上！
			}
		}

	}
	
	public static void main(String[] args) {
		System.out.println(getConn());
	}

}
