package com.mtl.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.mtl.dao.ExeAdmin;
import com.mtl.pojo.Admin;
import com.mtl.pojo.Clazz;
import com.mtl.pojo.Student;
import com.mtl.util.DBUtil;

public class ExeAdminImpl implements ExeAdmin {

	@Override
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

	@Override
	public int insertAdmin(Admin admin) {
		String sql = "insert into t_admin (userid, username, password, age, hobby, enterdate) values (?, ?, ?, ?, ?, ?)";
		int executeUpdate = DBUtil.executeUpdate(sql, admin.toArray());
		DBUtil.closeAll();
		return executeUpdate;
	}

	@Override
	public List<Student> findAllStudent(Map<String, Object> params2) {
		List<Student> list = new ArrayList<Student>();
		StringBuffer sql = new StringBuffer("select * from t_student s left join t_clazz c on s.clazzno=c.clazzno where 1=1 ");
		List<Object> params = new ArrayList<Object>();
		if (null != params2.get("fname") && !params2.get("fname").equals("")){
			sql.append("and sname like ? ");
			params.add("%" + params2.get("fname") + "%");
		}
		
		if (null != params2.get("fgender") && !params2.get("fgender").equals("")){
			sql.append("and gender = ?");
			params.add(params2.get("fgender"));
		}
		
		if (0 != (Integer)params2.get("fclazzno")){
			sql.append("and c.clazzno = ?");
			params.add(params2.get("fclazzno"));
		}
		System.out.println(sql.toString());
		
		ResultSet rs = DBUtil.executeQuery(sql.toString(), params.toArray());
		try {
			System.out.println(rs.toString());
			while (rs.next()){
				Student student = new Student(rs.getInt("sno"), rs.getString("pwd"), rs.getString("sname"), 
						rs.getString("phone"), rs.getString("gender"), rs.getDate("birth"), 
						rs.getInt("clazzno"), rs.getString("remark"));
				student.setClazz(new Clazz(rs.getInt("clazzno"), rs.getString("cname"), rs.getString("chteacher"), rs.getString("clazzroom")));
				list.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int insertStudent(Student student) {
		int i = 0;
		String sql = "insert into t_student values (?, ?, ?, ?, ?, ?, ?, ?)";
		i = DBUtil.executeUpdate(sql, student.toArray());
		return i;
	}
	
	@Override
	public int deleteStudent(int sno) {
		int i = 0;
		String sql = "delete from t_student where sno = ?";
		i = DBUtil.executeUpdate(sql, new Object[]{sno});
		return i;
	}
}
