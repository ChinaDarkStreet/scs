package com.mtl.dao;

import java.util.List;

import com.mtl.pojo.Course;
import com.mtl.pojo.Teacher;

public interface ExeCourse {
	void addCourse(Course course) throws Exception;

	List<Course> getAllCourse();
}
