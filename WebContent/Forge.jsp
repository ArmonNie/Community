<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <!--   用户管理页，在id为forge的div里面改变为登陆或者注册     -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<!-- 基本js（jquery）与css（bootstrap） -->
		<script src="basejs/jquery.js"></script>
		<script src="bootstrap/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		<!-- 网站主题样式 -->
		<script src="community/community.js"></script>
		<link rel="stylesheet" href="community/community.css">
		<!-- 网站背景动画 -->
		<script src="airplane/three.min.js"></script>
		<script src="airplane/airplane.js"></script>
		<link rel="stylesheet" href="airplane/airplane.css">
		<title>社区</title>
	</head>
	<body class="bg-warning">
		<div id="world">
		<!-- 背景动画 -->
		</div>
		<div class="container">
			<div class="row clearfix">
				<!-- 页眉 -->
				<div class="col-md-12 column">
					<!-- 页面标题以及链接 -->
					<div class="page-header">
						<h1 class="text-left">
							<small class="font_title">回忆</small>
						</h1>
						<div class="text-right">
							<a><img class="img_login" alt="登录" title="登录" src="img/login_gray.svg" onmouseover="return img_login_over()" onmouseout="return img_login_out()" onclick="return img_login_click()"></a>
							<a><img class="img_regist" alt="注册" title="注册" src="img/regist_gray.svg"onmouseover="return img_regist_over()" onmouseout="return img_regist_out()" onclick="return img_regist_click()"></a>
						</div>
					</div>
				</div>
				
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