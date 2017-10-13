package com.mtl.util;

import com.mtl.pojo.Course;
import com.mtl.pojo.Teacher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * JDBC的公共类
 * 
 * @author Administrator
 * 
 */
public class DBUtil {
	public static final String charset = "text/html;charset=utf-8";

	private static Connection conn = null;
	private static ResultSet rs = null;
	private static PreparedStatement pstmt = null;

	public static void getCourse(List<Course> list, ResultSet rs){
		try {
			System.out.println(rs.toString());
			while (rs.next()){
				list.add(new Course(rs.getInt("cno"), rs.getString("name"),
						rs.getInt("credit"), rs.getDate("periodStart"), rs.getDate("periodEnd"),
						new Teacher(rs.getInt("tno"), rs.getString("tname"), rs.getString("pwd"), rs.getString("phone"), rs.getDate("hireDate"), rs.getString("remark"))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 创建一个连接	 * 
	 * @return
	 */
	public static Connection getConnection() {		
		/*try {
			// 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 获取连接
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test", "root", "root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		
		/*conn = ConnectPoolFactory.getInstance().getConnect();*/
		
		try {
			Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");
			conn = DriverManager.getConnection("proxool.test");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 关闭数据库资源
	 * @param rs
	 * @param stmt
	 * @param conn
	 */
	public static void closeAll() {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * 执行insert、update、delete 三个DML操作
	 * @param sql
	 * @param prams
	 * @return
	 */
	public static int executeUpdate(String sql, Object[] prams) {
		conn = getConnection();
		int n = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < prams.length; i++) {
				pstmt.setObject(i + 1, prams[i]);
			}
			n = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	
	/**
	 * 执行query操作
	 * @param sql
	 * @param prams
	 * @return
	 */
	public static ResultSet executeQuery(String sql, Object[] prams) {
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < prams.length; i++) {
				pstmt.setObject(i + 1, prams[i]);
			}
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
