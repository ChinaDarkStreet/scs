	
	<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<%
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ path + "/";
	%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title></title>
	<style type="text/css">
	<!--
	body {
		margin-left: 0px;
		margin-top: 0px;
		margin-right: 0px;
		margin-bottom: 0px;
	}
	-->
	</style>
	<link href="css/css.css" rel="stylesheet" type="text/css" />
	</head>
	
	<body>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="59" background="images/top.gif"><table
						width="99%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="1%"><img src="images/logo.jpg" width="557"
								height="59" border="0" /></td>
							<td width="64%" align="right"
								style="font-size:12px;vertical-align:bottom;">&copy; 2017 
								你是第${applicationScope.count }个登陆的用户
								</td>
						</tr>
					</table></td>
			</tr>
		</table>
	</body>
	</html>