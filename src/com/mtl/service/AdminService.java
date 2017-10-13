package com.mtl.service;

import java.util.List;
import java.util.Map;

import com.mtl.pojo.Admin;
import com.mtl.pojo.Course;
import com.mtl.pojo.Student;
import com.mtl.pojo.Teacher;

public interface AdminService {
	/*
	 * 登录管理员
	 */
	Admin login(String id, String pwd);
	
	/*
	 * 注册管理员
	 */
	int register(Admin admin);
	
	/*
	 * 查询所有学生
	 */
	List<Student> getAllStudent(Map<String, Object> params);
	
	/*
	 * 添加学生
	 */
	int addStudent(Student student);
	
	/*
	 * 删除学生
	 */
	int deleteStudent(int sno);

	void addCourse(Course course) throws Exception;

	void addTeacher(Teacher teacher) throws Exception;

	List<Teacher> getAllTeacher();

	List<Course> getAllCourse();
	
	int addDistribute(int cno, int tno);
	
	List<Course> getAllDistribute();
	
	int deleteDistribute(int cno, int tno);
}
