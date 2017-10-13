package com.mtl.dao;

import com.mtl.pojo.Course;

import java.util.List;

public interface ExeSC {
    List<Course> getAllCourse(int sno);
    int insertCourse(int sno, int cno, int tno);
}
