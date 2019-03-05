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
<div id="world"></div>
<div class="container">
<div class="row clearfix">
<div class="col-md-12 column">
<div class="page-header">
<h1 class="text-left"><small class="font_title">前 路</small></h1>
<div class="text-right">
<a><img class="img_login" alt="登录" title="登录" src="img/login_gray.svg" onmouseover="return img_login_over()" onmouseout="return img_login_out()" onclick="return img_login_click()"></a>
<a><img class="img_regist" alt="注册" title="注册" src="img/regist_gray.svg"onmouseover="return img_regist_over()" onmouseout="return img_regist_out()" onclick="return img_regist_click()"></a>
</div>
</div>
</div>
<div class="col-md-3 column"></div>
<div class="col-md-5 column">
<div id="forge"></div>
</div>
<div class="col-md-4 column"></div>
</div>
</div>
</body>
</html>