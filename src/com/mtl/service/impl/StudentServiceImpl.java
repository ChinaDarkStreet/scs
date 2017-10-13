package com.mtl.service.impl;

import com.mtl.dao.ExeSC;
import com.mtl.dao.ExeStudent;
import com.mtl.dao.ExeTC;
import com.mtl.dao.impl.ExeSCImpl;
import com.mtl.dao.impl.ExeStudentImpl;
import com.mtl.dao.impl.ExeTCImpl;
import com.mtl.pojo.Course;
import com.mtl.pojo.Student;
import com.mtl.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
	private ExeStudent exeStudent = new ExeStudentImpl();
	private ExeTC exeTC = new ExeTCImpl();
	private ExeSC exeSC = new ExeSCImpl();

	@Override
	public Student getStudentById(int sno) {
		// TODO Auto-generated method stub
		return exeStudent.queryStudentById(sno);
	}

	@Override
	public Student studentLogin(int sno, String pwd) {

		return exeStudent.queryStudentBypwd(sno, pwd);
	}

	@Override
	public List<Course> getChooseCourse(int sno) {
		return exeTC.getChooseCourse();
	}

	@Override
	public int chooseCourse(int sno, String cno, String tno) {
		return exeSC.insertCourse(sno, Integer.parseInt(cno), Integer.parseInt(tno));
	}

	@Override
	public List<Course> getSelectedCourse(int sno) {
		return exeSC.getAllCourse(sno);
	}


}
