package com.mtl.dao.impl;

import com.mtl.dao.ExeSC;
import com.mtl.pojo.Course;
import com.mtl.pojo.Teacher;
import com.mtl.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExeSCImpl implements ExeSC{
    @Override
    public List<Course> getAllCourse(int sno) {
        List<Course> list = new ArrayList<Course>();
        String sql = "SELECT c.*,t.* FROM t_course c JOIN t_sc sc ON c.`CNO`=sc.`CNO` JOIN t_teacher t ON t.`TNO`=sc.`TNO` WHERE sc.`SNO`=? ORDER BY c.`CNO`";
        ResultSet rs = DBUtil.executeQuery(sql, new Object[]{sno});
        DBUtil.getCourse(list, rs);
        return list;
    }

    @Override
    public int insertCourse(int sno, int cno, int tno) {
        String sql = "INSERT INTO t_sc (SNO, CNO, TNO) VALUES (?, ?, ?)";
        int i = DBUtil.executeUpdate(sql, new Object[]{sno, cno, tno});
        return i;
    }
}
