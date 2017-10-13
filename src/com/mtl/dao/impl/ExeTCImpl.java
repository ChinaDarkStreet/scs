package com.mtl.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mtl.dao.ExeTC;
import com.mtl.pojo.Course;
import com.mtl.pojo.Student;
import com.mtl.pojo.Teacher;
import com.mtl.util.DBUtil;

public class ExeTCImpl implements ExeTC {

	@Override
	public int addDistribute(int cno, int tno) {
		// TODO Auto-generated method stub
		try {
			String sql = "insert into t_tc values (?, ?)";
			int executeUpdate = DBUtil.executeUpdate(sql, new Object[]{cno, tno});
			DBUtil.closeAll();
			return executeUpdate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Course> getAllDistribute() {
		List<Course> list = new ArrayList<Course>();
		String sql = "SELECT c.*,t.* FROM t_course c LEFT JOIN t_tc tc ON c.`CNO`=tc.`CNO` LEFT JOIN t_teacher t ON t.`TNO`=tc.`TNO` ORDER BY c.`CNO`";
		ResultSet rs = DBUtil.executeQuery(sql, new Object[]{});
		DBUtil.getCourse(list, rs);
		return list;
	}

	@Override
	public int deleteDistribute(int cno, int tno) {
		try {
			String sql = "delete from t_tc where cno=? and tno=?";
			int executeUpdate = DBUtil.executeUpdate(sql, new Object[]{cno, tno});
			DBUtil.closeAll();
			return executeUpdate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Course> getChooseCourse(int sno) {
		List<Course> list = new ArrayList<Course>();
//		String sql = "SELECT c.*,t.* FROM t_course c JOIN t_tc tc ON c.`CNO`=tc.`CNO` JOIN t_teacher t ON t.`TNO`=tc.`TNO` ORDER BY c.`CNO`";
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT * FROM (SELECT c.*,t.* FROM t_course c JOIN t_tc tc ON c.`CNO`=tc.`CNO` JOIN t_teacher t ON t.`TNO`=tc.`TNO` ORDER BY c.`CNO`) z");
		sql.append(" WHERE NOT EXISTS (");
		sql.append(" SELECT c.*,t.* FROM t_course c JOIN t_sc sc ON c.`CNO`=sc.`CNO` JOIN t_teacher t ON t.`TNO`=sc.`TNO` WHERE sc.`SNO`=? AND z.cno=c.`CNO`)");
		ResultSet rs = DBUtil.executeQuery(sql.toString(), new Object[]{sno});
		DBUtil.getCourse(list, rs);
		return list;
	}
}
