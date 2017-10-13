package com.mtl.service;

import com.mtl.pojo.Teacher;

public interface TeacherService {
    Teacher teacherLogin(int tno, String pwd);
}
