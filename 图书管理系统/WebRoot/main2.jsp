<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	
	-->
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/WdatePicker.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/skin_/table.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/jquery.grid.css" />

  </head>
  
  <body>
  <div id="container">
	<div id="hd"></div>
    <div id="bd">
    	<div id="main">
        	<div class="search-box ue-clear">
            	<div class="search-area">
                    <div class="kv-item ue-clear">
                        <label>选择时间：</label>
                        <div class="kv-item-content ue-clear">
                            <span class="choose">
                                <span class="checkboxouter">
                                    <input type="radio" name="time" />
                                    <span class="radio"></span>
                                </span>
                                <span class="text">全部</span>
                            </span>
                            <span class="choose">
                                <span class="checkboxouter">
                                    <input type="radio" name="time" />
                                    <span class="radio"></span>
                                </span>
                                <span class="text">近3天</span>
                            </span>
                            <span class="choose">
                                <span class="checkboxouter">
                                    <input type="radio" name="time" />
                                    <span class="radio"></span>
                                </span>
                                <span class="text">近一周</span>
                            </span>
                            <span class="choose">
                                <span class="checkboxouter">
                                    <input type="radio" name="time" />
                                    <span class="radio"></span>
                                </span>
                                <span class="text">近一月</span>
                            </span>
                            <span class="choose">
                                <span class="checkboxouter">
                                    <input type="radio" name="time" data-define="define" />
                                    <span class="radio"></span>
                                </span>
                                <span class="text">自定义</span>
                            </span>
                            <span class="define-input">
                            	<input type="text" placeholder="开始时间" />
                                <span class="division"></span>
                                <input type="text" placeholder="结束时间" />
                            </span>
                        </div>
                    </div>
                    <div class="kv-item ue-clear">
                        <label>选择类型:</label>
                        <div class="kv-item-content">
                            <select>
                                <option>全部</option>
                                <option>全部</option>
                                <option>全部</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="search-button">
                	<input class="button" type="button" value="搜索一下" />
                </div>
             </div>
             
            <div class="table">
            	<div class="opt ue-clear">
                	<span class="sortarea">
                    	<span class="sort">
                        	<label>排序：</label>
                            <span class="name">
                            	<i class="icon"></i>
                                <span class="text">名称</span>
                            </span>
                        </span>
                        
                        <i class="list"></i>
                        <i class="card"></i>
                    </span>
                	<span class="optarea">
                        <a href="javascript:;" class="add">
                            <i class="icon"></i>
                            <span class="text">添加</span>
                        </a>
                        <a href="javascript:;" class="delete">
                            <i class="icon"></i>
                            <span class="text">删除</span>
                        </a>
                        
                        <a href="javascript:;" class="statistics">
                            <i class="icon"></i>
                            <span class="text">统计</span>
                        </a>
                        
                        <a href="javascript:;" class="config">
                            <i class="icon"></i>
                            <span class="text">配置</span>
                        </a>
                    </span>
                </div>
                
                <div class="grid"></div>
                
                <div class="pagination"></div>
            </div>
        </div>
    </div>
</div>


  <%-- 构建分页导航 --%>
            共有${pageBean.totalRecord}个员工，共${pageBean.totalPage }页，当前为${pageBean.pageNum}页
            <br/>
            <a href="${pageContext.request.contextPath}/UserServlet?action=getAllUserList&pageNum=1">首页</a>
            <%--如果当前页为第一页时，就没有上一页这个超链接显示 --%>
            <c:if test="${pageBean.pageNum ==1}">
                <c:forEach begin="${pageBean.start}" end="${pageBean.end}" step="1" var="i">
                    <c:if test="${pageBean.pageNum == i}">
                        ${i}
                    </c:if>                
                    <c:if test="${pageBean.pageNum != i}">
                        <a href="${pageContext.request.contextPath}/UserServlet?action=getAllUserList&pageNum=${i}">${i}</a>                                        
                    </c:if>                        
                </c:forEach>
                <a href="${pageContext.request.contextPath}/UserServlet?action=getAllUserList&pageNum=${pageBean.pageNum+1}">下一页</a>                    
            </c:if>
            
            <%--如果当前页不是第一页也不是最后一页，则有上一页和下一页这个超链接显示 --%>
            <c:if test="${pageBean.pageNum > 1 && pageBean.pageNum < pageBean.totalPage}">
                <a href="${pageContext.request.contextPath}/UserServlet?action=getAllUserList&pageNum=${pageBean.pageNum-1}">上一页</a>
                <c:forEach begin="${pageBean.start}" end="${pageBean.end}" step="1" var="i">    
                    <c:if test="${pageBean.pageNum == i}">
                        ${i}
                    </c:if>            
                    <c:if test="${pageBean.pageNum != i}">
                        <a href="${pageContext.request.contextPath}/UserServlet?action=getAllUserList&pageNum=${i}">${i}</a>                                        
                    </c:if>                        
                </c:forEach>
                <a href="${pageContext.request.contextPath}/UserServlet?action=getAllUserList&pageNum=${pageBean.pageNum+1}">下一页</a>    
            </c:if>
            
            <%-- 如果当前页是最后一页，则只有上一页这个超链接显示，下一页没有 --%>
            <c:if test="${pageBean.pageNum == pageBean.totalPage}">
                <a href="${pageContext.request.contextPath}/UserServlet?action=getAllUserList&pageNum=${pageBean.pageNum-1}">上一页</a>
                <c:forEach begin="${pageBean.start}" end="${pageBean.end}" step="1" var="i">
                    <c:if test="${pageBean.pageNum == i}">
                        ${i}
                    </c:if>
                    <c:if test="${pageBean.pageNum != i}">
                        <a href="${pageContext.request.contextPath}/UserServlet?action=getAllUserList&pageNum=${i}">${i}</a>                                        
                    </c:if>                
                </c:forEach>
            </c:if>
            <%--尾页 --%>
            <a href="${pageContext.request.contextPath}/UserServlet?action=getAllUserList&pageNum=${pageBean.totalPage}">尾页</a>
  </body>
  <script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>js/global.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.select.js"></script>
<script type="text/javascript" src="<%=basePath%>js/core.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.pagination.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.grid.js"></script>
<script type="text/javascript" src="<%=basePath%>js/WdatePicker.js"></script>
<script type="text/javascript">
	$('select').select();
	var head = [{
				label: 'ID',
				width: 100,
				sortable: 'default',
				name: 'id'	
			},{
				label:'用户名',
				width: 150,
				sortable: 'default',
				name:'name'	
			},{
				label:'昵称',
				width:150	
			},{
				label: '籍贯',
				width: 150	
			},{
				label: '毕业院校',
				minWidth: 200	
			},{
				label: '出生日期',
				width: 120	
			},{
				label: '是否审核',
				width:100	
			}];
			
	var oper = [{label:'删除',onclick:function(){
						alert('删除');
				}},{label:'编辑',onclick: function(){
					alert('编辑')	
				}}]
	var tbody = [
					["201301","admin","熊猫王子","江苏南京","南京林业大学","1982-10-18","已审核",oper], 
					["201302","uimaker","小牛","山东济南","山东大学","1989-10-18","已审核",oper],
					["201301","admin","熊猫王子","江苏南京","南京林业大学","1982-10-18","已审核",oper],
					["201301","admin","熊猫王子","江苏南京","南京林业大学","1982-10-18","已审核",oper], 
					["201302","uimaker","小牛","山东济南","山东大学","1989-10-18","已审核",oper],
					["201301","admin","熊猫王子","江苏南京","南京林业大学","1982-10-18","已审核",oper],
					["201301","admin","熊猫王子","江苏南京","南京林业大学","1982-10-18","已审核",oper], 
					["201302","uimaker","小牛","山东济南","山东大学","1989-10-18","已审核",oper],
					["201301","admin","熊猫王子","江苏南京","南京林业大学","1982-10-18","已审核",oper],
					["201301","admin","熊猫王子","江苏南京","南京林业大学","1982-10-18","已审核",oper], 
					["201302","uimaker","小牛","山东济南","山东大学","1989-10-18","已审核",oper],
					["201301","admin","熊猫王子","江苏南京","南京林业大学","1982-10-18","已审核",oper],
					["201301","admin","熊猫王子","江苏南京","南京林业大学","1982-10-18","已审核",oper], 
					["201302","uimaker","小牛","山东济南","山东大学","1989-10-18","已审核",oper],
					["201301","admin","熊猫王子","江苏南京","南京林业大学","1982-10-18","已审核",oper]]
					
					
		$('.grid').Grid({
			thead: head,
			tbody: null,
			height:400,
			checkbox: {
				single:true	
			},
			operator: {
				type : "normal",
				width : 100	
			},
			sortCallBack : function(name,index,type){
				alert(name+","+index+','+type);
			}
			
		});
	
	$('.grid').Grid('addLoading');
	
	/// 模拟异步
	setTimeout(function(){
		$('.grid').Grid('setData',tbody, head);
	},2000)
	
	
	$('.pagination').pagination(100,{
		callback: function(page){
			alert(page);	
		},
		display_msg: false
	});
	
	$('.search-box input[type=radio]').click(function(e) {
        if($(this).prop('checked')){
			if($(this).attr('data-define') === 'define'){
				$('.define-input').show();
			}else{
				$('.define-input').hide();
			}
		}
    });
</script>
</html>
