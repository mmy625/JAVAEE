<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>www.jb51.net 表单验证</title>
<style type="text/css">
<!--
body, td, th {
	  font-size: 12px;
	  color: #000000;
}

body {
	  background-color: #CCCCCC;
	  margin-left: 0px;
	  margin-top: 0px;
}

a {
	  font-size: 12px;
	  color: #666600;
}

a:link {
	  text-decoration: none;
}

a:visited {
	  text-decoration: none;
	  color: #000099;
}

a:hover {
	  text-decoration: underline;
	  color: #6633FF;
}

a:active {
	  text-decoration: none;
	  color: #00FF00;
}
-->
</style>
  
<script type="text/javascript">
	function checkusername() {
		var myform = document.getElementById("form1");
		var username = myform.username.value.length;
		if (username < 1 || username > 12) {
			errusername.innerHTML = "<font color='red'>用户名不符合要求</font>";
			return false;
		} else {
			errusername.innerHTML = "<font color='green'>用户名符合要求</font>";
			return true;
		}
	}
	function checkage() {
		var myform = document.getElementById("form1");
		var age = myform.age.value;
		if (age != parseInt(age)) {
			errage.innerHTML = "<font color='red'>年龄不符合要求</font>";
			return false;
		} else {
			errage.innerHTML = "<font color='green'>年龄符合要求</font>";
			return true;
		}
	}
	function checkemail() {
		var myform = document.getElementById("form1");
		var mail = /^[A-Za-z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
		if (!mail.test(myform.email.value)) {
			erremail.innerHTML = "<font color='red'>email不符合要求</font>";
			return false;
		} else {
			erremail.innerHTML = "<font color='green'>email符合要求</font>";
			return true;
		}
	}
	function checkform() {
		checkusername();
		checkage();
		checkemail();
		
		if (checkusername() && checkage() && checkemail()) {
			return true;
		} else {
			return false;
		}
	}
</script>
</head>
<body alink="center">
	 
	<form id="form1" name="form1" method="post" action="ttt.jsp"
		onsubmit="return checkform()">
		<table width="777" border="0" cellpadding="1" cellspacing="1">
			 
			<tr>
				  
				<td colspan="3"><div align="center">请输入你的注册信息</div></td>  
			</tr>
			 
			<tr>
				  
				<td width="250"><div align="right">请输入你的用户名：</div></td>   
				<td width="250"><div align="center">
						     <input type="text" name="username" onblur="checkusername()" /> 
						   
					</div></td>   
				<td><div id="errusername" align="center"></div></td>  
			</tr>
			 
			<tr>
				  
				<td width="250"><div align="right">请输入你的年龄：</div></td>   
				<td width="250"><div align="center">
						   <label>    <input type="text" name="age"
							onblur="checkage()" />    
						</label>   
					</div></td>    
				<td><div align="center" id="errage"></div></td>  
			</tr>
			 
			<tr>
				  
				<td width="250"><div align="right">请输入你的EMAIL:</div></td>   
				<td width="250"><div align="center">
						   <label>    <input type="text" name="email"
							onblur="checkemail()" />    
						</label>   
					</div></td>    
				<td><div align="center" id="erremail"></div></td>  
			</tr>
			 
			<tr>
				  
				<td><div align="right">
						   <label>    <input type="submit" name="Submit"
							value="提交" />    
						</label>   
					</div></td>    
				<td><div align="center">
						    <label>     <input type="reset" name="Submit2"
							value="重置" />     
						</label>    
					</div></td>   
				<td><div align="center"></div></td>  
			</tr>
		</table>
	
		 
	</form>
</body>
</html>