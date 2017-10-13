package com.mtl.service;

import com.mtl.pojo.Course;
import com.mtl.pojo.Student;

import java.util.List;

public interface StudentService {
	/*
	 * 通过id查询学生
	 */
	Student getStudentById(int sno);
	/**
	 * 通过账号密码查询学生
	 */
	Student studentLogin(int sno, String pwd);

	List<Course> getChooseCourse(int sno);

    int chooseCourse(int sno, String s, String s1);

	List<Course> getSelectedCourse(int sno);
}
