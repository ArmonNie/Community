<%@page import="com.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="jquery.js"></script>
<script src="community/community.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="airplane/three.min.js"></script>
<script src="airplane/airplane.js"></script>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="community/community.css">
<link rel="stylesheet" href="airplane/airplane.css">
<title>社区</title>
</head>
<body class="bg-warning">
<%String user_name =(String)session.getAttribute("user_name"); %>
<div id="world"></div>
<div class="container">
<div class="row clearfix">
<div class="col-md-12 column">
<div  class="page-header">
<h1>
<small class="font_title">前 路</small>
</h1>
<div class="text-right">
<a class="dropdown-toggle" href="#" data-toggle="dropdown">
<img src="img/login_gray.svg" class="margin">
<%=user_name%>
</a>
<ul class="dropdown-menu">
<li>
<a href="#">信息</a>
</li>
<li>
<a onclick="get_collection()">收藏</a>
</li>
<li>
<a onclick="a_share_click()">分享</a>
</li>
<li class="divider">
</li>
<li>
<a href="Quit.jsp">退出</a>
</li>
</ul>
</div>
</div>
</div>
<div class="col-md-12 column">
<div class="col-md-8 column">
<ul class="nav nav-pills nav-justified">	
<li>
<a onclick="return a_video_click()">视频</a>
</li>
</ul>
</div>
<div class="col-md-1 column"></div>
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
<div id="content" class="margin"></div></div>
<div class="col-md-1 column"></div>
<div class="col-md-3 column"></div>
</div>
</div>
</div>		
</div>
</body>
</html>