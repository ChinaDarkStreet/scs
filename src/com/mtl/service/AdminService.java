package com.mtl.service;

import java.util.List;
import java.util.Map;

import com.mtl.pojo.Admin;
import com.mtl.pojo.Course;
import com.mtl.pojo.Student;
import com.mtl.pojo.Teacher;

public interface AdminService {
	/*
	 * ��¼����Ա
	 */
	Admin login(String id, String pwd);
	
	/*
	 * ע�����Ա
	 */
	int register(Admin admin);
	
	/*
	 * ��ѯ����ѧ��
	 */
	List<Student> getAllStudent(Map<String, Object> params);
	
	/*
	 * ���ѧ��
	 */
	int addStudent(Student student);
	
	/*
	 * ɾ��ѧ��
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
