<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<script src="${pageContext.request.contextPath}/basejs/jquery.js"></script>
		<script src="${pageContext.request.contextPath}/community/community.js"></script>
		<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/airplane/three.min.js"></script>
		<script src="${pageContext.request.contextPath}/airplane/airplane.js"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/community/community.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/airplane/airplane.css">
		<title>社区</title>
	</head>
	<body class="bg-warning">
		<script type="text/javascript">
		function all_video_click() {
			$.get("/Community/ajaxaction/LoadAction", 
					{tag:"all"},
					function (data, textStatus){
						console.log("OK");
						$("#content").append(data);
						/* $("#content").load("Video.jsp"); */
				});
		}
		function tv_video_click() {
			$.get("/Community/ajaxaction/LoadAction", 
					{},
					function (data, textStatus){
						$("#content").load("Video_TV.jsp");
				});
		}
		function movie_video_click() {
			$.get("/Community/ajaxaction/LoadAction", 
					{},
					function (data, textStatus){
						$("#content").load("Video_movie.jsp");
				});
		}
		function cg_video_click() {
			$.get("/Community/ajaxaction/LoadAction", 
					{},
					function (data, textStatus){
						$("#content").load("Video_CG.jsp");
				});
		}
		</script>
		<div id="world">
		<!-- 加载背景动画 -->
		</div>
		<div class="container">
			<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="page-header">
					<h1>
						<small class="font_title">回忆</small>
					</h1>
					<div class="text-right">
						<a class="dropdown-toggle" href="#" data-toggle="dropdown">
						<img src="${pageContext.request.contextPath}/img/login_gray.svg" class="margin">
						用户
						</a>
						<ul class="dropdown-menu">
							<li><a href="#">信息</a></li>
							<li><a onclick="get_collection()">收藏</a></li>
							<li><a onclick="a_share_click()">分享</a></li>
							<li class="divider"></li>
							<li><a href="Quit.jsp">退出</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-md-12 column">
				<div class="col-md-2 column">
					<ul class="nav nav-pills nav-justified">	
						<li><a onclick="return all_video_click()">全部</a></li>
					</ul>
				</div>
				<div class="col-md-2 column">
					<ul class="nav nav-pills nav-justified">	
						<li><a onclick="return movie_video_click()">电影</a></li>
					</ul>
				</div>
				<div class="col-md-2 column">
					<ul class="nav nav-pills nav-justified">	
						<li><a onclick="return tv_video_click()">电视</a></li>
					</ul>
				</div>
				<div class="col-md-2 column">
					<ul class="nav nav-pills nav-justified">	
						<li><a onclick="return cg_video_click()">CG动漫</a></li>
					</ul>
				</div>
				<div class="col-md-1 column">
				
				</div>
				<div class="col-md-3 column margin_top">
					<form class="bs-example bs-example-form" role="form">
						<div class="input-group">
							<input type="text" class="form-control text_area_transparency">
							<span class="input-group-btn">
								<button class="btn btn-success text_area_transparency" type="button">搜索</button>
							</span>
						</div>          
					</form>
				</div>
			<div class="col-md-12 column">
				<div class="col-md-8 column">
					<div id="content" class="margin">
					<!-- 内容区域 -->
					</div>
				</div>
				<div class="col-md-1 column"></div>
				<div class="col-md-3 column"></div>
			</div>
		</div>
		<div>		
		</div>
	</body>
</html>