<%@page import="java.sql.Date"%>
<%@page import="com.mtl.pojo.Student"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'testJstl.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%
    	//1.准备数据  
     	int n=50;//基本类型
     	double avgScore = 57.45678;//基本类型
    	Student stu = new Student();//引用类型
    	stu.setSno(1);
    	stu.setSname("曹炎兵");
    	stu.setBirth(Date.valueOf("1999-12-12"));
    	
    	String [] strs = {"Java","Oracle","JSP","HTML"};//数组
    	String courses="Java,Oracle,JSP,HTML,Servlet";//特殊的字符串
    	String str = null;
    	String str3 = "";
     	List list1 = new ArrayList();//分配空间，没有元素
     	list1.add(90);
     	list1.add(80);
     	List list2 =null;//没有分配空间
     	List list3 =new ArrayList();//分配空间,没有元素  size()==0
     	Map<String,String> map = new HashMap<String,String>();//Map
     	map.put("cn", "China");
     	map.put("fr", "France");
		//setAttribute
		request.setAttribute("r1",n);
		request.setAttribute("avgScore",avgScore);
    	request.setAttribute("stu",stu);
    	request.setAttribute("courses",strs);
    	request.setAttribute("courses2",courses);   
    	request.setAttribute("now",new java.util.Date());     	
    	request.setAttribute("list1", list1);
    	request.setAttribute("list2", list2);  
    	request.setAttribute("list3", list3);    
    	request.setAttribute("map", map);    	
    	 	
    	request.setAttribute("str", str);
    	request.setAttribute("str3", str3);
    	//2.使用JSTL和EL输出    	
    	 %>
		<c:choose>
			<c:when test="${r1>49 }">A</c:when>
			<c:when test="${r1>39 }">B</c:when>
			<c:when test="${r1>29 }">C</c:when>
		</c:choose>
		
  </body>
</html>
