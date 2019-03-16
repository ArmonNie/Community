<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 视频详情页 -->
<% %>
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
		<title>视频详情</title>
	</head>
	<body class="bg-warning">
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
			<div class="media">
				 <a href="#" class="pull-left"><img src="http://ibootstrap-file.b0.upaiyun.com/lorempixel.com/64/64/default.jpg" class="media-object" alt='' /></a>
				<div class="media-body">
					<h4 class="media-heading">
						Nested media heading
					</h4> Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis.
					<div class="media">
						 <a href="#" class="pull-left"><img src="http://ibootstrap-file.b0.upaiyun.com/lorempixel.com/64/64/default.jpg" class="media-object" alt='' /></a>
						<div class="media-body">
							<h4 class="media-heading">
								Nested media heading
							</h4> Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis.
						</div>
					</div>
				</div>
			</div>
			<div class="btn-group">
				 <button class="btn btn-default" type="button"><em class="glyphicon glyphicon-align-left"></em> 左</button> <button class="btn btn-default" type="button"><em class="glyphicon glyphicon-align-center"></em> 中</button> <button class="btn btn-default" type="button"><em class="glyphicon glyphicon-align-right"></em> 右</button> <button class="btn btn-default" type="button"><em class="glyphicon glyphicon-align-justify"></em> 全</button>
			</div>
		</div>
			</div>
		</div>		
	</body>
</html>