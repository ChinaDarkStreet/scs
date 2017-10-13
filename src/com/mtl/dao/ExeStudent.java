package com.mtl.dao;

import com.mtl.pojo.Student;

public interface ExeStudent {
	Student queryStudentById(int sno);
	Student queryStudentBypwd(int sno, String pwd);
}
