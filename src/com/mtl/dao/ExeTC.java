package com.mtl.dao;

import java.util.List;

import com.mtl.pojo.Course;

public interface ExeTC {
	int addDistribute(int cno, int tno);
	List<Course> getAllDistribute();
	int deleteDistribute(int cno, int tno);
	List<Course> getChooseCourse(int sno);
}
