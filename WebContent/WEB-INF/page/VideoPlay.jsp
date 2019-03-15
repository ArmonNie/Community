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
		<link href="http://vjs.zencdn.net/5.0.2/video-js.css" rel="stylesheet">
    	<script src="http://vjs.zencdn.net/ie8/1.1.0/videojs-ie8.min.js"></script>
    	<script src="http://vjs.zencdn.net/5.0.2/video.js"></script>
		<title>社区</title>
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
				 <video id="example_video_1" class="video-js vjs-default-skin" controls preload="none" width="640" height="264" poster="http://vjs.zencdn.net/v/oceans.png" data-setup="{}">
    <source src="http://vjs.zencdn.net/v/oceans.mp4" type="video/mp4">
    <source src="http://vjs.zencdn.net/v/oceans.webm" type="video/webm">
    <source src="http://vjs.zencdn.net/v/oceans.ogv" type="video/ogg">
    <track kind="captions" src="../shared/example-captions.vtt" srclang="en" label="English"></track>
    <!-- Tracks need an ending tag thanks to IE9 -->
    <track kind="subtitles" src="../shared/example-captions.vtt" srclang="en" label="English"></track>
    <!-- Tracks need an ending tag thanks to IE9 -->
    <p class="vjs-no-js">To view this video please enable JavaScript, and consider upgrading to a web browser that <a href="http://videojs.com/html5-video-support/" target="_blank">supports HTML5 video</a></p>
  </video>
</div>
			</div>
		</div>		
	</body>
</html>