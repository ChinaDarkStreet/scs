package com.mtl.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mtl.dao.ExeTeacher;
import com.mtl.pojo.Student;
import com.mtl.pojo.Teacher;
import com.mtl.util.DBUtil;

public class ExeTeacherImpl implements ExeTeacher {


	@Override
	public int addTeacher(Teacher teacher) throws Exception {
		// TODO Auto-generated method stub
		int executeUpdate = 0;
		try {
			String sql = "insert into t_teacher values (null, ?, ?, ?, ?, ?)";
			executeUpdate = DBUtil.executeUpdate(sql, teacher.toArray());
			DBUtil.closeAll();
		} catch (Exception e) {

			throw new Exception();
		}
		return executeUpdate;
	}

	@Override
	public List<Teacher> getAllTeacher() {
		List<Teacher> list = new ArrayList<Teacher>();
		String sql = "select * from t_teacher";
		ResultSet rs = DBUtil.executeQuery(sql, new Object[]{});
		try {
			while (rs.next()){
				list.add(new Teacher(rs.getInt("tno"),rs.getString("tname"), rs.getString("pwd"), rs.getString("phone"),
						rs.getDate("hireDate"), rs.getString("remark")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Teacher getTeacherByPwd(int tno, String pwd) {
		Teacher teacher = null;
		String sql = "select * from t_teacher where tno = ? and pwd = ?";
		ResultSet rs = DBUtil.executeQuery(sql, new Object[]{tno, pwd});
		try {
			if (rs.next()){
				teacher = new Teacher(rs.getInt("tno"), rs.getString("tname"), rs.getString("pwd"),
						rs.getString("phone"), rs.getDate("hireDate"), rs.getString("remark"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teacher;
	}

}
