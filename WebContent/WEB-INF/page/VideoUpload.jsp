<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!-- 基本js（jquery）与css（bootstrap） -->
		<script src="${pageContext.request.contextPath}/static/basejs/jquery.js"></script>
		<script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css">
		<!-- 本页行为js -->
		<script src="${pageContext.request.contextPath}/static/community/page_videoupload.js"></script>
		<!-- 网站主题样式 -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/community/community.css">
		<!-- 网站背景动画 -->
		<script src="${pageContext.request.contextPath}/static/airplane/three.min.js"></script>
		<script src="${pageContext.request.contextPath}/static/airplane/airplane.js"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/airplane/airplane.css">
		<title>视频上传</title>
	</head>
	<bodyclass="bg-warning">
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
							<li class="dropdown pull-right">
								<%-- <a class="dropdown-toggle" href="#" data-toggle="dropdown">
									<img src="${pageContext.request.contextPath}/img/login_gray.svg" class="margin">
									<%
									HttpSession mSession = ServletActionContext
									.getRequest().getSession();
									%>
									<%= mSession.getAttribute("username")%>
								</a> --%>
								<ul class="dropdown-menu">
									<li><a href="/Community/action/LinkAction?index=<%= "usercenter" %>">个人中心</a></li>
									<li><a onclick="get_collection()">信息中心</a></li>
									<li><a href="/Community/action/LinkAction?index=<%= "uploadvideo" %>">上传视频</a></li>
									<li class="divider"></li>
									<li><a href="Quit.jsp">退出</a></li>
								</ul>
							</li>
						</div>
					</div>
				</div>
				</div>
		<div class="row clearfix">
			<div class="col-md-1 column">
			
			</div>
			<div class="col-md-8 column">
				<form id="fileform" method="post" action="/Community/action/UploadAction" role="form" enctype="multipart/form-data">
					<div class="form-group">
					 	<label for="inputfile">文件</label>
					 	<input type="file" name="file" id="file" onchange="return filemsg_console()"/>
						<p class="help-block">
							请选择需要上传的视频文件
						</p>
					</div>
					<div class="form-group">
						<label for="filename">文件名</label>
					 	<input  class="form-control" name="filename" id="filename" />
					</div>
					<div class="form-group">
						 <label for="filesize">文件大小</label>
						 <input  class="form-control" name="filesize" id="filesize" />
					</div>
					<div class="form-group">
						 <label for="filepath">文件路径</label>
						 <input class="form-control" name="filepath" id="filepath" />
					</div>
					<div class="form-group">
						 <label for="filepath">文件类别</label>
						 <input class="form-control" name="filetype" id="filetype" />
					</div>
					<div class="form-group">
						 <label for="filedescription">文件描述</label>
						 <input class="form-control" name="filedescription" id="filedescription" />
					</div>
					<button onclick="return btn_upload()" class="btn btn-default">提交</button>
				</form>
			</div>
			<div class="col-md-3 column">
				<!-- 提示信息 -->
			</div>
		</div>
	</div>
</body>
</html>