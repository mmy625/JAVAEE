<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
			String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'main.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


</head>

<body>

<input />
	<table id="list2"></table>
	<div id="pager2"></div>
	<br>


</body>

<!-- jqGrid组件基础样式包-必要 -->
<link rel="stylesheet" href="jqgrid/css/ui.jqgrid.css" />

<!-- jqGrid主题包-非必要 -->
<!-- 在jqgrid/css/css这个目录下还有其他的主题包，可以尝试更换看效果 -->
<link rel="stylesheet"
	href="jqgrid/css/css/redmond/jquery-ui-1.8.16.custom.css" />

<!-- jquery插件包-必要 -->
<!-- 这个是所有jquery插件的基础，首先第一个引入 -->
<script type="text/javascript" src="<%=basePath%>js/jquery-1.7.1.js"></script>

<!-- jqGrid插件包-必要 -->
<script type="text/javascript" src="<%=basePath%>jqgrid/js/jquery.jqGrid.src.js"></script>

<!-- jqGrid插件的多语言包-非必要 -->
<!-- 在jqgrid/js/i18n下还有其他的多语言包，可以尝试更换看效果 -->
<script type="text/javascript" src="<%=basePath%>jqgrid/js/i18n/grid.locale-cn.js"></script>

<!-- 本页面初始化用到的js包，创建jqGrid的代码就在里面 -->
<script type="text/javascript" src="<%=basePath%>js/index.js"></script>

<script type="text/javascript">

	$(function() {
		pageInit();
	});


	function pageInit() {
		jQuery("#list2").jqGrid(
			{
				url : '<%=basePath%>UserServlet?action=getAllUserList',
				datatype : "json",
				colNames : [ 'ID', '用户名', '密码', 'Amount', 'Tax', 'Total', 'Notes' ],
				colModel : [
					{
						name : 'id',
						index : 'id',
						width : 55
					},
					{
						name : 'userName',
						index : 'userName',
						width : 90
					},
					{
						name : 'password',
						index : 'userName',
						width : 100
					},
					{
						name : 'userName',
						index : 'userName',
						width : 80,
						align : "right"
					},
					{
						name : 'userName',
						index : 'userName',
						width : 80,
						align : "right"
					},
					{
						name : 'userName',
						index : 'userName',
						width : 80,
						align : "right"
					},
					{
						name : 'userName',
						index : 'userName',
						width : 150,
						sortable : false
					}
				],
				rowNum : 5, //每一页显示的记录数
				rowList : [ 5, 10, 15 ],
				pager : '#pager2',
				sortname : 'id',
				mtype : "post",
				viewrecords : true,
				sortorder : "desc",
				caption : "JSON 实例"
			});
		jQuery("#list2").jqGrid('navGrid', '#pager2', {
			edit : false,
			add : false,
			del : false
		});
	}
</script>
</html>
