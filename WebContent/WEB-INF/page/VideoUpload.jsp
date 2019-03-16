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
<title>Insert title here</title>
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
			<div class="col-md-2 column">
			</div>
			<div class="col-md-8 column">
					<form role="form">
				<div class="form-group">
					 <label for="exampleInputEmail1">Email address</label><input type="email" class="form-control" id="exampleInputEmail1" />
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword1">Password</label><input type="password" class="form-control" id="exampleInputPassword1" />
				</div>
				<div class="form-group">
					 <label for="exampleInputFile">File input</label><input type="file" id="exampleInputFile" />
					<p class="help-block">
						Example block-level help text here.
					</p>
				</div>
				<div class="checkbox">
					 <label><input type="checkbox" />Check me out</label>
				</div> <button type="submit" class="btn btn-default">Submit</button>
			</form>
		</div>
		<div class="col-md-2 column">
			
			
		</div>
	</div>
</div>
</body>
</html>