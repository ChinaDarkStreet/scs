package com.mtl.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mtl.dao.ExeAdmin;
import com.mtl.dao.ExeStudent;
import com.mtl.pojo.Admin;
import com.mtl.pojo.Clazz;
import com.mtl.pojo.Student;
import com.mtl.util.DBUtil;

public class ExeStudentImpl implements ExeStudent {

	public Admin findAdmin(String userId, String pwd) {
		Admin admin = null;
		String sql = "select * from t_admin where userid = ? and password = ?";
		Object[] prams = {userId, pwd};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		if (rs != null){
			String uname = null;
			try {
				if (rs.next()){
					uname = rs.getString("username");
					int age = rs.getInt("age");
					String hobby = rs.getString("hobby");
					Date enterDate = rs.getDate("enterdate");
					admin = new Admin(userId, uname, pwd, age, hobby, enterDate);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				if (uname != null){
					admin = new Admin(userId, uname, pwd, 12, "12", null);
				}
			}finally{
				DBUtil.closeAll();
			}
		}
		System.out.println("admi = " + admin);
		return admin;
	}

	public int insertAdmin(Admin admin) {
		String sql = "insert into t_admin (userid, username, password, age, hobby, enterdate) values (?, ?, ?, ?, ?, ?)";
		int executeUpdate = DBUtil.executeUpdate(sql, admin.toArray());
		DBUtil.closeAll();
		return executeUpdate;
	}

	public List<Student> findAllStudent() {
		List<Student> list = new ArrayList<Student>();
		String sql = "select * from t_student";
		ResultSet rs = DBUtil.executeQuery(sql, new Object[]{});
		try {
			System.out.println(rs.toString());
			while (rs.next()){
				Student student = new Student(rs.getInt(1), rs.getString("pwd"), rs.getString("sname"), 
						rs.getString("phone"), rs.getString("gender"), rs.getDate("birth"), 
						rs.getInt("clazzno"), rs.getString("remark"));
				System.out.println("student = " + student);
				list.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public int insertStudent(Student student) {
		int i = 0;
		String sql = "insert into t_student values (?, ?, ?, ?, ?, ?, ?, ?)";
		i = DBUtil.executeUpdate(sql, student.toArray());
		return i;
	}
	
	public int deleteStudent(int sno) {
		int i = 0;
		String sql = "delete from t_student where sno = ?";
		i = DBUtil.executeUpdate(sql, new Object[]{sno});
		return i;
	}

	@Override
	public Student queryStudentById(int sno) {
		Student student = null;
		String sql = "select * from t_student where sno = ?";
		ResultSet rs = DBUtil.executeQuery(sql, new Object[]{sno});
		try {
			if (rs.next()){
				student = new Student(rs.getInt("sno"), rs.getString("pwd"), rs.getString("sname"), 
						rs.getString("phone"), rs.getString("gender"), rs.getDate("birth"), 
						rs.getInt("clazzno"), rs.getString("remark"));
				student.setClazz(new Clazz(rs.getInt("clazzno"), rs.getString("cname"), rs.getString("chteacher"), rs.getString("clazzroom")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public Student queryStudentBypwd(int sno, String pwd) {
		Student student = null;
		String sql = "select * from t_student where sno = ? and pwd = ?";
		ResultSet rs = DBUtil.executeQuery(sql, new Object[]{sno, pwd});
		try {
			if (rs.next()){
				student = new Student(rs.getInt("sno"), rs.getString("pwd"), rs.getString("sname"),
						rs.getString("phone"), rs.getString("gender"), rs.getDate("birth"),
						rs.getInt("clazzno"), rs.getString("remark"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}


}
