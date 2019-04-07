<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="org.apache.struts2.ServletActionContext"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<!-- 基本js（jquery）与css（bootstrap） -->
		<script src="${pageContext.request.contextPath}/static/basejs/jquery.js"></script>
		<script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css">
		<!-- 本页行为js -->
		<script src="${pageContext.request.contextPath}/static/community/page_admienter.js"></script>
		<!-- 网站主题样式 -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/community/community.css">
		<!-- 网站背景动画 -->
		<script src="${pageContext.request.contextPath}/static/airplane/three.min.js"></script>
		<script src="${pageContext.request.contextPath}/static/airplane/airplane.js"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/airplane/airplane.css">
		<title>管理员中心</title>
	</head>
	<body class="bg-warning">
		<div id="world">
		<!-- 加载背景动画 -->
		</div>
		<!-- 视频预览播放的模态框 -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    		<div class="modal-dialog">
       			 <div class="modal-content">
            		<div class="modal-header">       
               			 <h4 class="modal-title" id="myModalLabel">…</h4>
            		</div>
            		<div class="modal-body text-center">
            			<video class="video_size" id="video" controls="controls">
            				<source src="" type="audio/mp4"></source>
            			</video>      
            		</div>
            		<div class="modal-footer">
                
            		</div>
        		</div>
    		</div>
		</div>
		<div class="container">
			<!-- 页眉 -->
			<div class="row clearfix page-header">
				<div class="col-md-2 column">
					<!-- 页面标题 -->
					<div class="text-left">
						<small class="font_title h1">回忆</small>
					</div>
				</div>
				<div class="col-md-8 column">
				<!-- 页面空白 -->
				</div>
				<div class="col-md-2 column">
				<!-- 页面用户管理 -->
					<div class="text-right">
						<li style="list-style:none" class="dropdown pull-right">
							<a class="dropdown-toggle" href="#" data-toggle="dropdown">
								<img src="${pageContext.request.contextPath}/static/img/login_gray.svg" class="margin">
								<%
								HttpSession mSession = ServletActionContext
								.getRequest().getSession();
								%>
								<%= mSession.getAttribute("adminusername")%>
							</a>
							<%-- <ul class="dropdown-menu">
								<li><a href="/Community/action/LinkAction?index=<%= "usercenter" %>">个人中心</a></li>
								<li><a onclick="get_collection()">信息中心</a></li>
								<li><a href="/Community/action/LinkAction?index=<%= "uploadvideo" %>">上传视频</a></li>
								<li class="divider"></li>
								<li><a href="Quit.jsp">退出</a></li>
							</ul> --%>
						</li>
					</div>
				</div>
			</div>
			<div class="row clearfix">
				<div class="col-md-2 column">
					<ul class="nav nav-pills nav-justified">	
						<li><a onclick="return getAllVideo()">视频管理</a></li>
					</ul>
				</div>
				<div class="col-md-2 column">
					<ul class="nav nav-pills nav-justified">	
						<li><a onclick="return getAllUser()">用户管理</a></li>
					</ul>
				</div>
				<div class="col-md-2 column">
					<!-- <ul class="nav nav-pills nav-justified">	
						<li><a onclick="return tv_video_click()">电视</a></li>
					</ul> -->
				</div>
				<div class="col-md-2 column">
					<!-- <ul class="nav nav-pills nav-justified">	
						<li><a onclick="return cg_video_click()">CG动漫</a></li>
					</ul> -->
				</div>
				<div class="col-md-1 column">
				
				</div>
				<div class="col-md-3 column margin_top">
					<form class="bs-example bs-example-form" role="form">
						<div class="input-group">
							<input id="inputsearch" type="text" placeholder="请输入您想要的视频" class="form-control text_area_transparency">
							<span class="input-group-btn">
								<button onclick="return video_search()" class="btn btn-success" type="button">搜索</button>
							</span>
						</div>          
					</form>
				</div>
			</div>
			<div class="row clearfix">
				<div class="col-md-1 column"></div>
				<div class="col-md-10 column">
					<div id="content" class="margin">
					<!-- 内容区域 -->
					</div>
				</div>
				<div class="col-md-1 column"></div>
			</div>
		</div>		
	</body>
</html>