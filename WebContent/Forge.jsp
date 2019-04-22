<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!--用户管理页，在id为forge的div里面改变为登陆或者注册-->
<!--  最终待优化：动画背景的更换学习 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<!-- 基本js（jquery）与css（bootstrap） -->
		<script src="${pageContext.request.contextPath}/static/basejs/jquery.js"></script>
		<script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css">
		<!-- 本页行为js -->
		<script src="${pageContext.request.contextPath}/static/community/page_forge.js"></script>
		<!-- 网站主题样式 -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/community/community.css">
		<!-- 网站背景动画 -->
		<script src="${pageContext.request.contextPath}/static/airplane/three.min.js"></script>
		<script src="${pageContext.request.contextPath}/static/airplane/airplane.js"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/airplane/airplane.css">
		<title>社区</title>
	</head>
	<body class="bg-warning">
		<div id="world">
		<!-- 背景动画 -->
		</div>
		<!-- 使用bootstrap网格布局（row+column） -->
		<div class="container">
			<!-- 页眉 -->
			<div class="row clearfix page-header">
				<div class="col-md-2 column">
					<!-- 页面标题 -->
					<div class="text-left">
						<small class="font_title h1" onclick="return all_video_click()">回忆</small>
					</div>
				</div>
				<div class="col-md-8 column">
				<!-- 页面导航 -->
				</div>
				<div class="col-md-2 column">
				<!-- 页面用户管理 -->
					<div class="text-right">
						<a><img class="img_login" alt="登录" title="登录" src="/Community/static/img/login_gray.svg" onmouseover="return img_login_over()" onmouseout="return img_login_out()" onclick="return img_login_click()"></a>
						<a><img class="img_regist" alt="注册" title="注册" src="/Community/static/img/regist_gray.svg"onmouseover="return img_regist_over()" onmouseout="return img_regist_out()" onclick="return img_regist_click()"></a>
					</div>
				</div>
			</div>
			
			<div class="row clearfix">
				<!-- 填充空白块【12分为3+6+3】 -->
				<div class="col-md-3 column"></div>
				<div class="col-md-6 column">
					<!-- 主题内容 -->
					<div id="forge">
						<!-- 填充页面 -->
					</div>
				</div>
				<div class="col-md-3 column"></div>
			</div>
		</div>
	</body>
</html>