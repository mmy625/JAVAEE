<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'login.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		console.log("dddddddddd");
	});

	//检查用户名是否重复
	function ajaxFun(o) {
		var name = $(o).val();
		console.log(name);


		$.ajax(
			{
				url : "<%=basePath%>ajax.action",
				data : "name=" + name,
				success : function(infor) {
					$("#name").after("<span style='color: red' >用户名重复</span>");
				}
			}
		);

	}



	//刷新验证码
	function changeImg() {
		document.getElementById("validateCodeImg").src = "<%=basePath%>image.action?" + Math.random();
	}
	
	function checkCode(o)
	{
		var code = $(o).val();
		
		$.ajax(
			{
				url : "<%=basePath%>checkCode.action",
				data : "validateCode=" + code,
				success : function(infor) {
					$("#spanCodeInfor").html(infor);
				}
			}
		);
	}
	
	//表单提交
	function submitFun()
	{
		
		$("#form").submit();
	}
	
	

</script>
</head>

<body>
	<form id="form" action="<%=basePath%>login.action">
		name: <input type="text" name="loginName" id="name" onblur="ajaxFun(this)" /> <br>
		pwd: <input type="text" name="password" id="pwd"  /><br>
		xib:	
		
		<select id="select">
			<option value="a">a</option>
			<option value="b">b</option>
			<option value="c">c</option>
		</select><br>
		
		验证码：<input type="text" name="validateCode" onblur="checkCode(this)"/> 
		<img alt="验证码看不清，换一张" 	src="<%=basePath%>image.action" id="validateCodeImg" onclick="changeImg()">
			<a href="javascript:void(0)" onclick="changeImg()" >看不清，换一张</a><span id="spanCodeInfor"></span>
	    <input type="button" value="提交" onclick="submitFun()" />
	</form>
	
	<script type="text/javascript">
			$("#select").bind("change",function(){
					console.log($(this).val());
			 });
	</script>
</body>
</html>
