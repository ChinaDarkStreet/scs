package com.mtl.dao;

import java.util.List;
import java.util.Map;

import com.mtl.pojo.Admin;
import com.mtl.pojo.Student;

public interface ExeAdmin {
	Admin findAdmin(String userId, String pwd);
	
	/*
	 * �������Ա
	 */
	int insertAdmin(Admin admin);
	
	/*
	 * ��ѯ����ѧ��
	 */
	List<Student> findAllStudent(Map<String, Object> params2);
	
	/*
	 * ���ѧ��
	 */
	int insertStudent(Student student);
	
	/*
	 * ɾ��ѧ��
	 */
	int deleteStudent(int sno);
}
