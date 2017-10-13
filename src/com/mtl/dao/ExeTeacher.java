package com.mtl.dao;

import java.util.ArrayList;
import java.util.List;

import com.mtl.pojo.Teacher;

public interface ExeTeacher {
	int addTeacher(Teacher teacher) throws Exception;
	List<Teacher> getAllTeacher();
	Teacher getTeacherByPwd(int tno, String pwd);
}
