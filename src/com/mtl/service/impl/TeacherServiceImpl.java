package com.mtl.service.impl;

import com.mtl.dao.ExeTeacher;
import com.mtl.dao.impl.ExeTeacherImpl;
import com.mtl.pojo.Teacher;
import com.mtl.service.TeacherService;

public class TeacherServiceImpl implements TeacherService {
    private ExeTeacher exeTeacher = new ExeTeacherImpl();

    @Override
    public Teacher teacherLogin(int tno, String pwd) {
        return exeTeacher.getTeacherByPwd(tno, pwd);
    }
}
