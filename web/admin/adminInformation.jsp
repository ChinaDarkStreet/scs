<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
	    <base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title></title>
		<style type="text/css">
			<!-- body {
				margin-left: 0px;
				margin-top: 0px;
				margin-right: 0px;
				margin-bottom: 0px;
			}
			.tabfont01 {
				font-family: "宋体";
				font-size: 9px;
				color: #555555;
				text-decoration: none;
				text-align: center;
			}
			.font051 {
				font-family: "宋体";
				font-size: 12px;
				color: #333333;
				text-decoration: none;
				line-height: 20px;
			}
			.font201 {
				font-family: "宋体";
				font-size: 12px;
				color: #FF0000;
				text-decoration: none;
			}
			.button {
				font-family: "宋体";
				font-size: 14px;
				height: 37px;
			}
			html {
				overflow-x: auto;
				overflow-y: auto;
				border: 0;
			}
			-->
		</style>

		<link href="../css/css.css" rel="stylesheet" type="text/css" />
		<script type="text/JavaScript">

		</script>
		<style type="text/css">
			<!-- .style3 {
				font-size: 18px
			}
			.style5 {
				font-size: 14px;
				text-decoration: none;
				font-family: "宋体";
			}
			.style6 {
				font-size: 12px;
				height: 20px;
				width: 45px;
				background-image: url(../images/button04.gif);
				border-top-width: 0px;
				border-right-width: 0px;
				border-bottom-width: 0px;
				border-left-width: 0px;
				font-family: "宋体";
			}
			.style7 {
				font-size: 12px;
				height: 20px;
				width: 75px;
				background-image: url(../images/button09.gif);
				border-top-width: 0px;
				border-right-width: 0px;
				border-bottom-width: 0px;
				border-left-width: 0px;
				font-family: "宋体";
			}
			.style10 {
				color: #000000
			}
			-->
		</style>
		<link href="../css/style.css" rel="stylesheet" type="text/css" />
	</head>
	<SCRIPT language=JavaScript>
		function sousuo() {
			window.open("gaojisousuo.htm", "", "depended=0,alwaysRaised=1,width=800,height=510,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
		}

		function selectAll() {
			var obj = document.fom.elements;
			for (var i = 0; i < obj.length; i++) {
				if (obj[i].name == "delid") {
					obj[i].checked = true;
				}
			}
		}

		function unselectAll() {
			var obj = document.fom.elements;
			for (var i = 0; i < obj.length; i++) {
				if (obj[i].name == "delid") {
					if (obj[i].checked == true) obj[i].checked = false;
					else obj[i].checked = true;
				}
			}
		}
	</SCRIPT>

	<body>
		<form name="fom" id="fom" method="post">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">

				<tr>
					<td height="30">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td height="62" background="../images/nav04.gif" class="style10">
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td>
									<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
										<tr>
											<td height="40" class="font42">
												<table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646">

													<tr>
														<td height="20" colspan="2" align="center" bgcolor="#EEEEEE" class="tablestyle_title"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
															个人信息列表 &nbsp;</td>
													</tr>
													<tr>
														<td width="21%" height="20" align="right" bgcolor="#FFFFFF">姓名:</td>
														<td width="74%" bgcolor="#FFFFFF">张三丰</td>
													</tr>
													<tr>
														<td height="20" align="right" bgcolor="#FFFFFF">编号:</td>
														<td bgcolor="#FFFFFF">001</td>
													</tr>
													
													<tr>
														<td height="20" align="right" bgcolor="#FFFFFF">性别:</td>
														<td bgcolor="#FFFFFF">男</td>
													</tr>
													
													<tr>
														<td align="right" bgcolor="#FFFFFF">电子邮箱:</td>
														<td bgcolor="#FFFFFF">123@qq.com</td>
													</tr>
													<tr>
														<td align="right" bgcolor="#FFFFFF">电话号码:</td>
														<td bgcolor="#FFFFFF">13676352226</td>
													</tr>
													
													<tr>
														<td align="right" bgcolor="#FFFFFF">身份:</td>
														<td bgcolor="#FFFFFF">管理员</td>
													</tr>
													
													<tr>
														<td align="right" bgcolor="#FFFFFF">个人说明:</td>
														<td bgcolor="#FFFFFF"><textarea rows="10" cols="120"></textarea></td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>

</html>