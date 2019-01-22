<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath =
        request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>jQuery无刷新上传插件Uploadify</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="css/Huploadify.css"/>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="js/jquery.Huploadify.js"></script>
	
<script type="text/javascript">
$(function(){
	$('#upload').Huploadify({
		auto:true,
		fileTypeExts:'*.jpg;*.png;*.exe;*.rar',
		multi:true,
		formData:{pid:'portal',token:'portal',filedesc:''},
		fileSizeLimit:999999,
		showUploadedPercent:true,//是否实时显示上传的百分比，如20%
		showUploadedSize:true,
		removeTimeout:9999999,
		uploader : '<%=basePath%>upload',
		onUploadStart:function(){
			//alert('开始上传');
			},
		onInit:function(){
			//alert('初始化');
			},
		onUploadComplete:function(){
			//alert('上传完成');
			},
			onUploadSuccess: function(file, data, response) {
					//alert(data);
				},
		onDelete:function(file){
			console.log('删除的文件：'+file);
			console.log(file);
		}
		});
	});
</script>
</head>

<body>jQuery无刷新上传插件Uploadify
  <div id="upload"></div>
</body>
</html>
