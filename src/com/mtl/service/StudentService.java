package com.mtl.service;

import com.mtl.pojo.Course;
import com.mtl.pojo.Student;

import java.util.List;

public interface StudentService {
	/*
	 * ͨ��id��ѯѧ��
	 */
	Student getStudentById(int sno);
	/**
	 * ͨ���˺������ѯѧ��
	 */
	Student studentLogin(int sno, String pwd);

	List<Course> getChooseCourse(int sno);

    int chooseCourse(int sno, String s, String s1);

	List<Course> getSelectedCourse(int sno);
}
