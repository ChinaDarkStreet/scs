package com.mtl.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Arrays;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mtl.pojo.Admin;
import com.mtl.pojo.Student;
import com.mtl.pojo.Teacher;
import com.mtl.service.impl.AdminServiceImpl;
import com.mtl.service.impl.StudentServiceImpl;
import com.mtl.service.impl.TeacherServiceImpl;

public class UserServlet extends BaseServlet {
	
	/*@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String method = req.getParameter("method");
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		if ("doLogin".equals(method)){
			doLogin(req, resp);
		}else if ("doLogout".equals(method)){
			doLogout(req, resp);
		}
	}*/
	
	protected void doLogout(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getSession().invalidate();
		resp.sendRedirect(req.getContextPath() + "/login.jsp");
	}
	protected void doLogin(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String id = req.getParameter("userId");
		String pwd = req.getParameter("pwd");
		String role = req.getParameter("role");
		System.out.println(role);
		req.getSession().setAttribute("role", role);
		String yanzhengma = req.getParameter("yanzhengma");
		String randStr = (String) req.getSession().getAttribute("randStr");

		System.out.println("yanzhengma = " + yanzhengma);
		System.out.println("randStr = " + randStr);
//		if (!randStr.equals(yanzhengma)){
//			req.setAttribute("yangzhengma", "验证码错误");
//			req.getRequestDispatcher("/login.jsp").forward(req, resp);
//		    return;
//		}

		if (null != id && null != pwd){
			if (role.equals("admin"))
			{
				Admin admin = new AdminServiceImpl().login(id, pwd);
				if (admin != null){
					int count = 0;
					ServletContext servletContext = req.getServletContext();
					Object obj = servletContext.getAttribute("count");
					if (obj == null){
						count = 1;
					}else {
						count = (Integer)obj;
						count++;
					}
					servletContext.setAttribute("count", count);
					req.getSession().setAttribute("admin", admin);
					resp.sendRedirect(req.getContextPath() + "/index.jsp");

				}else{
					req.setAttribute("msg", "用户名或密码错误");
					req.getRequestDispatcher("/login.jsp").forward(req, resp);
				}
			}else if (role.equals("student"))
			{
				Student student = new StudentServiceImpl().studentLogin(Integer.parseInt(id), pwd);
				if (student != null){
					int count = 0;
					ServletContext servletContext = req.getServletContext();
					Object obj = servletContext.getAttribute("count");
					if (obj == null){
						count = 1;
					}else {
						count = (Integer)obj;
						count++;
					}
					servletContext.setAttribute("count", count);
					req.getSession().setAttribute("student", student);
					resp.sendRedirect(req.getContextPath() + "/index.jsp");

				}else{
					req.setAttribute("msg", "用户名或密码错误");
					req.getRequestDispatcher("/login.jsp").forward(req, resp);
				}
			}else if (role.equals("teacher")){
				Teacher teacher = new TeacherServiceImpl().teacherLogin(Integer.parseInt(id), pwd);
				if (teacher != null){
					int count = 0;
					ServletContext servletContext = req.getServletContext();
					Object obj = servletContext.getAttribute("count");
					if (obj == null){
						count = 1;
					}else {
						count = (Integer)obj;
						count++;
					}
					servletContext.setAttribute("count", count);
					req.getSession().setAttribute("teacher", teacher);
					resp.sendRedirect(req.getContextPath() + "/index.jsp");

				}else{
					req.setAttribute("msg", "用户名或密码错误");
					req.getRequestDispatcher("/login.jsp").forward(req, resp);
				}
			}
		}
	}
}
