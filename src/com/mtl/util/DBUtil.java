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
 * JDBC�Ĺ�����
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
	 * ����һ������	 * 
	 * @return
	 */
	public static Connection getConnection() {		
		/*try {
			// ��������
			Class.forName("com.mysql.jdbc.Driver");
			// ��ȡ����
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
	 * �ر����ݿ���Դ
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
	 * ִ��insert��update��delete ����DML����
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
	 * ִ��query����
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
