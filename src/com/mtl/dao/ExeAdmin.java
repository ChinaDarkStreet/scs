package com.mtl.dao;

import java.util.List;
import java.util.Map;

import com.mtl.pojo.Admin;
import com.mtl.pojo.Student;

public interface ExeAdmin {
	Admin findAdmin(String userId, String pwd);
	
	/*
	 * 插入管理员
	 */
	int insertAdmin(Admin admin);
	
	/*
	 * 查询所有学生
	 */
	List<Student> findAllStudent(Map<String, Object> params2);
	
	/*
	 * 添加学生
	 */
	int insertStudent(Student student);
	
	/*
	 * 删除学生
	 */
	int deleteStudent(int sno);
}
