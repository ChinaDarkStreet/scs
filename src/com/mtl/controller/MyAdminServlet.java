package com.mtl.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mtl.pojo.Admin;
import com.mtl.pojo.Course;
import com.mtl.pojo.Student;
import com.mtl.pojo.Teacher;
import com.mtl.service.AdminService;
import com.mtl.service.impl.AdminServiceImpl;
import com.mtl.service.impl.ClazzServiceImpl;
import com.mtl.service.impl.StudentServiceImpl;
import com.mtl.util.DBUtil;

public class MyAdminServlet extends BaseServlet {
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
		if ("doDeleteStudent".equals(method)){
			doDeleteStudent(req, resp);
		}else if ("doAddStudent".equals(method)){
			doAddStudent(req, resp);
		}else if ("doRegister".equals(method)){
			doRegister(req, resp);
		}else if ("doEnterUpdate".equals(method)){
			doEnterUpdate(req, resp);
		}else if ("doGetAllStudent".equals(method)){
			doGetAllStudent(req, resp);
		}else if ("doUpdateStudent".equals(method)){
			doUpdateStudent(req, resp);
		}
	}*/

	protected void deleteDistribute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		AdminService adminService = new AdminServiceImpl();
		int cno = Integer.parseInt(req.getParameter("cno"));
		int tno = Integer.parseInt(req.getParameter("tno"));

		int result = adminService.deleteDistribute(cno, tno);

		System.out.println("result = " + result);
		req.setAttribute("cno", cno);
		req.setAttribute("tno", tno);
		req.setAttribute("cList", adminService.getAllDistribute());
		req.setAttribute("courseList", adminService .getAllCourse());
		req.setAttribute("teacherList", adminService.getAllTeacher());
		req.getRequestDispatcher("/admin/courseList.jsp").forward(req, resp);

	}
	protected void toDistributeCourse(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int cno = Integer.parseInt(req.getParameter("selectCourse"));
		int tno = Integer.parseInt(req.getParameter("selectTeacher"));
		System.out.println(cno + "    " + tno);
		AdminService adminService = new AdminServiceImpl();
		int result = adminService.addDistribute(cno, tno);//判断返回值操作成功玉佛
		System.out.println("result = " + result);
		
		req.setAttribute("cno", cno);
		req.setAttribute("tno", tno);
		req.setAttribute("cList", adminService.getAllDistribute());
		req.setAttribute("courseList", adminService .getAllCourse());
		req.setAttribute("teacherList", adminService.getAllTeacher());
		req.getRequestDispatcher("/admin/courseList.jsp").forward(req, resp);
		
	}
	protected void doDistributeCourse(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		AdminService adminService = new AdminServiceImpl();
		req.setAttribute("courseList", adminService .getAllCourse());
		req.setAttribute("teacherList", adminService.getAllTeacher());
		req.setAttribute("cList", adminService.getAllDistribute());
		req.getRequestDispatcher("/admin/courseList.jsp").forward(req, resp);
		
	}
	protected void doAddCourse(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = req.getParameter("name");
		int credit = Integer.parseInt(req.getParameter("credit"));
		Date periodStart = Date.valueOf(req.getParameter("periodStart"));
		Date periodEnd = Date.valueOf(req.getParameter("periodEnd"));
		
		try {
			new AdminServiceImpl().addCourse(new Course(name, credit, periodStart, periodEnd));
			resp.sendRedirect("/scs/admin/courseList.jsp");
		} catch (Exception e) {
			req.setAttribute("error", "添加出错");
			req.getRequestDispatcher("/admin/courseRegister.jsp").forward(req, resp);
		}
		
	}
	protected void doAddTeacher(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String tname = req.getParameter("tname");
		String pwd = req.getParameter("pwd");
		String phone = req.getParameter("phone");
		Date hireDate = Date.valueOf(req.getParameter("hireDate"));
		String remark = req.getParameter("remark");
		
		try {
			new AdminServiceImpl().addTeacher(new Teacher(tname, pwd, phone, hireDate, remark));
			resp.sendRedirect("/scs/admin/teacherList.jsp");
		} catch (Exception e) {
			// TODO: 添加老师出错
			req.setAttribute("error", "添加教师出错");
			req.getRequestDispatcher("/admin/teacheRegister.jsp");
		}
	}
	protected void getAllClazz(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List list = new ClazzServiceImpl().getAllClazz();
		req.setAttribute("clazzlist", list);
		req.getRequestDispatcher("/admin/studentRegister.jsp").forward(req, resp);
	}
	protected void doUpdateStudent(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType(DBUtil.charset);
		
		
		
		int sno = Integer.parseInt(req.getParameter("sno"));
		
		int result2 = new AdminServiceImpl().deleteStudent(sno);
		
		String pwd = req.getParameter("pwd");
		String sname =req.getParameter("sname");
		String phone = req.getParameter("phone");
		String gender = req.getParameter("gender");
		java.sql.Date birth = java.sql.Date.valueOf(req.getParameter("birth"));
		int clazzno = Integer.parseInt(req.getParameter("clazzno"));
		String remark = req.getParameter("remark");
		remark = new String (remark.getBytes("iso-8859-1"), "utf-8");
		
		Student student = new Student(sno, pwd, sname, phone, gender, birth, clazzno, remark);
		int result = new AdminServiceImpl().addStudent(student);
		if (result > 0){
			resp.sendRedirect(req.getContextPath() + "/servlet/myAdminServlet?method=doGetAllStudent");
		}else{
			req.setAttribute("error", "添加出错请重试");
			req.getRequestDispatcher("/admin/studentRegister.jsp").forward(req, resp);
		}
	}
	protected void doGetAllStudent(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String fname = req.getParameter("fname");
		String fgender = req.getParameter("fgender");
		String fclazzStr = req.getParameter("fclazz");
		if (null == fclazzStr){
			fclazzStr = "0";
		}
		int fclazz = Integer.parseInt(fclazzStr);
		Map<String, Object> params = new TreeMap<String, Object>();
		params.put("fname", fname);
		params.put("fgender", fgender);
		params.put("fclazzno", fclazz);
		System.out.println(params.toString());
		List<Student> list = new AdminServiceImpl().getAllStudent(params);
		System.out.println("listSize = " + list.size());
//		for (Student student : list) {
//			System.out.println(student);
//		}
		req.setAttribute("fname", fname);
		req.setAttribute("fgender", fgender);
		req.setAttribute("list", list);
		req.setAttribute("fclazzno", fclazz);
		req.setAttribute("clazzList", new ClazzServiceImpl().getAllClazz());
		req.getRequestDispatcher("/admin/studentList.jsp").forward(req, resp);;
	}
	protected void doEnterUpdate(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType(DBUtil.charset);
		
		String sno = req.getParameter("sno");
		Student student = new StudentServiceImpl().getStudentById(Integer.parseInt(sno));
		req.setAttribute("student", student);
		req.setAttribute("clazzList", new ClazzServiceImpl().getAllClazz());
		req.getRequestDispatcher("/admin/studentUpdate.jsp").forward(req, resp);
	}
	protected void doDeleteStudent(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType(DBUtil.charset);
		
		int sno = Integer.parseInt(req.getParameter("sno"));
		int result = new AdminServiceImpl().deleteStudent(sno);
		if (result > 0){
			resp.sendRedirect(req.getContextPath() + "/servlet/myAdminServlet?method=doGetAllStudent");
		}else{
			resp.getWriter().print("alert('删除失败,请重新尝试')");
			req.getRequestDispatcher("/servlet/getAllStudent").forward(req, resp);
		}
	}
	protected void doAddStudent(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType(DBUtil.charset);
		
		int sno = Integer.parseInt(req.getParameter("sno"));
		String pwd = req.getParameter("pwd");
		String sname =req.getParameter("sname");
		String phone = req.getParameter("phone");
		String gender = req.getParameter("gender");
//		gender = new String(gender.getBytes("iso-8859-1"),"utf-8");
		System.out.println(gender);
		java.sql.Date birth = java.sql.Date.valueOf(req.getParameter("birth"));
		int clazzno = Integer.parseInt(req.getParameter("clazzno"));
		String remark = req.getParameter("remark");
		remark = new String (remark.getBytes("iso-8859-1"), "utf-8");
		
		Student student = new Student(sno, pwd, sname, phone, gender, birth, clazzno, remark);
		int result = new AdminServiceImpl().addStudent(student);
		if (result > 0){
			resp.sendRedirect(req.getContextPath() + "/servlet/myAdminServlet?method=doGetAllStudent");
		}else{
			req.setAttribute("error", "添加出错请重试");
			req.getRequestDispatcher("/admin/studentRegister.jsp").forward(req, resp);
		}
		
	}
	protected void doRegister(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String id = req.getParameter("id");
		String uname = req.getParameter("uname");
		uname = new String (uname.getBytes("iso-8859-1"), "utf-8");
		String pwd = req.getParameter("pwd");
		int age = Integer.parseInt(req.getParameter("age"));
		String[] hobbys = req.getParameterValues("hobby");
		String enterDateStr = req.getParameter("enterDate");
		Date enterDate = Date.valueOf(enterDateStr);
		Admin admin = new Admin(id, uname, pwd, age, Arrays.toString(hobbys), enterDate);
		System.out.println(admin);
		new AdminServiceImpl().register(admin);
		
		PrintWriter out = resp.getWriter();
		out.print("<script>window.top.location='../login.jsp';</script>");
		
	}
}
