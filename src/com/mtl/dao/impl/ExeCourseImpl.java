package com.mtl.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mtl.dao.ExeCourse;
import com.mtl.pojo.Course;
import com.mtl.pojo.Teacher;
import com.mtl.util.DBUtil;

public class ExeCourseImpl implements ExeCourse {

	@Override
	public void addCourse(Course course) throws Exception {
		// TODO Auto-generated method stub
		try {
			String sql = "insert into t_course values (null, ?, ?, ?, ?)";
			int executeUpdate = DBUtil.executeUpdate(sql, course.toArray());
			DBUtil.closeAll();
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	@Override
	public List<Course> getAllCourse() {
		List<Course> list = new ArrayList<Course>();
		String sql = "select * from t_course";
		ResultSet rs = DBUtil.executeQuery(sql, new Object[]{});
		try {
			while (rs.next()){
				list.add(new Course(rs.getInt("cno"), rs.getString("name"), 
						rs.getInt("credit"), rs.getDate("periodStart"), rs.getDate("periodEnd")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
