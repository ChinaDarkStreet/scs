package com.mtl.controller;

import com.mtl.pojo.Course;
import com.mtl.pojo.Student;
import com.mtl.service.StudentService;
import com.mtl.service.impl.AdminServiceImpl;
import com.mtl.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StudentServlet extends BaseServlet {
    protected void toSelectedCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        Student student = (Student) request.getSession().getAttribute("student");
        List<Course> list = new StudentServiceImpl().getChooseCourse(student.getSno());
        request.setAttribute("courseList", list);
        request.getRequestDispatcher("/student/courseSelectList.jsp").forward(request, response);
    }

    protected void doChooseCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] delids = req.getParameterValues("delid");
        StudentService studentService = new StudentServiceImpl();
        Student student = (Student) req.getSession().getAttribute("student");
        for (String str :
                delids) {
            String[] split = str.split("#");
            int i = studentService.chooseCourse(student.getSno(), split[0], split[1]);
//            req.getRequestDispatcher("/student/courseSelectedList.jsp").forward(req, resp);
        }
        getSelectedCourse(req, resp);
    }

    protected void getSelectedCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = (Student) req.getSession().getAttribute("student");
        List<Course> courseList = new StudentServiceImpl().getSelectedCourse(student.getSno());
        req.setAttribute("courseList", courseList);
        req.getRequestDispatcher("/student/courseSelectedList.jsp").forward(req, resp);
    }
}
