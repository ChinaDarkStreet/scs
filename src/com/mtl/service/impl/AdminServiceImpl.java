package com.mtl.service.impl;

import java.util.List;
import java.util.Map;

import com.mtl.dao.ExeAdmin;
import com.mtl.dao.ExeCourse;
import com.mtl.dao.ExeTC;
import com.mtl.dao.ExeTeacher;
import com.mtl.dao.impl.ExeAdminImpl;
import com.mtl.dao.impl.ExeCourseImpl;
import com.mtl.dao.impl.ExeTCImpl;
import com.mtl.dao.impl.ExeTeacherImpl;
import com.mtl.pojo.Admin;
import com.mtl.pojo.Course;
import com.mtl.pojo.Student;
import com.mtl.pojo.Teacher;
import com.mtl.service.AdminService;

public class AdminServiceImpl implements AdminService {
	private ExeAdmin exeAdminImpl = new ExeAdminImpl();
	private ExeCourse exeCourse = new ExeCourseImpl();
	private ExeTeacher exeTeacher = new ExeTeacherImpl();
	private ExeTC exeTC = new ExeTCImpl();
	@Override
	public Admin login(String id, String pwd) {
		return exeAdminImpl.findAdmin(id, pwd);
	}

	@Override
	public int register(Admin admin) {
		return exeAdminImpl.insertAdmin(admin);
	}

	@Override
	public List<Student> getAllStudent(Map<String, Object> params) {
		return exeAdminImpl.findAllStudent(params);
	}
	
	@Override
	public int addStudent(Student student) {
		return exeAdminImpl.insertStudent(student);
	}
	
	@Override
	public int deleteStudent(int sno) {
		return exeAdminImpl.deleteStudent(sno);
	}

	@Override
	public void addCourse(Course course) throws Exception{
		// TODO Auto-generated method stub
		exeCourse.addCourse(course);
	}

	@Override
	public void addTeacher(Teacher teacher) throws Exception {
		// TODO Auto-generated method stub
		exeTeacher .addTeacher(teacher);
	}
	
	@Override
	public List<Teacher> getAllTeacher(){
		// TODO Auto-generated method stub
		return exeTeacher.getAllTeacher();
	}
	
	@Override
	public List<Course> getAllCourse(){
		return exeCourse.getAllCourse();
	}
	
	@Override
	public int addDistribute(int cno, int tno) {
		return exeTC .addDistribute(cno, tno);
	}
	
	@Override
	public List<Course> getAllDistribute() {
		return exeTC.getAllDistribute();
	}

	@Override
	public int deleteDistribute(int cno, int tno) {

		return exeTC.deleteDistribute(cno, tno);
	}
}
