<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
			String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
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
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/skin_/login.css" />


<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.select.js"></script>
<script type="text/javascript">
	//刷新验证码
	function changeImg() {
		document.getElementById("validateCodeImg").src = "${pageContext.request.contextPath}/loginServlet?action=drawImage&" + Math.random();
	}
</script>
</head>

<body>
	<div id="container">
		<div id="bd">
			<div id="main">
				<div class="login-box">
					<form action="<%=basePath%>UserServlet?action=login" method="post">
						<div id="logo"></div>
						<h1></h1>
						<div class="input username" id="username">
							<label for="userName">用户名</label> <span></span>
							 <input type="text" name="userName" id="userName" />
						</div>
						<div class="input psw" id="psw">
							<label for="password">密&nbsp;&nbsp;&nbsp;&nbsp;码</label> <span></span>
							<input type="password" name="password" id="password" />
						</div>
						<!-- 
						<div class="input validate" id="validate">
							<label for="valiDate">验证码</label> <input type="text"
								id="stu_code_hide" name="validateCode" />
							<div class="value">
								<img alt="验证码看不清，换一张"
									src="${pageContext.request.contextPath}/loginServlet?action=drawImage"
									id="validateCodeImg" onclick="changeImg()" />
							</div>
 -->
						</div>
						<div class="styleArea">
							<div class="styleWrap">
								${loginError}
							</div>
						</div>
						<div id="btn" class="loginButton">
							<input type="submit" class="button" value="登录" />
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>



</body>
<script type="text/javascript">
	var height = $(window).height() > 445 ? $(window).height() : 445;
	$("#container").height(height);
	var bdheight = ($(window).height() - $('#bd').height()) / 2 - 20;
	$('#bd').css('padding-top', bdheight);
	$(window).resize(function(e) {
		var height = $(window).height() > 445 ? $(window).height() : 445;
		$("#container").height(height);
		var bdheight = ($(window).height() - $('#bd').height()) / 2 - 20;
		$('#bd').css('padding-top', bdheight);
	});
	$('select').select();
</script>
</html>
