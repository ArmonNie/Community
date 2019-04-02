<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" 
    import="java.util.List,bean.File,tool.AppTool,tool.ORMTool,
    org.apache.struts2.ServletActionContext"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 视频播放页 -->
<%
	System.out.println("播放页面获取的视频信息" + request.getParameter("filenumber"));
	List fList;
	ORMTool ormtool = new ORMTool("file");
	String hql = "select f from File as f where f.filenumber = ?";
	fList = ormtool.getQuery(hql, request.getParameter("filenumber"));
	File f = (File)fList.get(0);
	AppTool.DebugOut(f, "file", "即将播放视频信息：");
	
	HttpSession mSession = ServletActionContext.getRequest().getSession();
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<!-- 基本js（jquery）与css（bootstrap） -->
		<script src="${pageContext.request.contextPath}/static/basejs/jquery.js"></script>
		<script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css">
		<!-- 本页行为js -->
		<script src="${pageContext.request.contextPath}/static/community/page_videoplay.js"></script>
		<!-- 网站主题样式 -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/community/community.css">
		<!-- 网站背景动画 -->
		<script src="${pageContext.request.contextPath}/static/airplane/three.min.js"></script>
		<script src="${pageContext.request.contextPath}/static/airplane/airplane.js"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/airplane/airplane.css">
		<script src="${pageContext.request.contextPath}/static/community/jsmodern.min.js"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/community/jsmodern.min.css">
		<title>播放视频</title>
	</head>
	<body class="bg-warning">
		<div id="world">
		<!-- 加载背景动画 -->
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
								<%= mSession.getAttribute("username")%>
							</a>
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
			<div class="row clearfix">
				<div class="col-md-8 column">
					<div class="media">
				 		<a href="#" class="pull-left">
				 			<img src="http://ibootstrap-file.b0.upaiyun.com/lorempixel.com/64/64/default.jpg" class="media-object" alt='' />
				 		</a>
						<div class="media-body">
							<h4 class="media-heading">
							<%= f.getFilename() %>
							</h4> 
							<%= f.getFiledescription() %>
						</div>
					</div>
				</div>
				<div class="col-md-4 column">
					
    				
				</div>
			</div>
			<div class="row cleearfix">
				<div class="col-md-12 column">
				填充
				</div>
			</div>
			<hr>
			<div class="row clearfix">
				<div class="col-md-12 column">
				 	<div class="panel panel-default">
						<div class="panel-heading text_area_transparency">
							<h3 class="panel-title">
								<%= f.getFilename() %>播放中
							</h3>
						</div>
						<div class="panel-body">
							<video  style="height:100%;width:100%;object-fit:fill"  id="video" controls="controls">
            					<source src="${pageContext.request.contextPath}/static/video/ServerVideo/<%= f.getFilename() %>" type="audio/mp4"></source>
            				</video>
						</div>
						<div class="panel-footer text_area_transparency">
							<form class="form-horizontal" role="form">
								<div class="form-group">
									<div class="col-sm-10">
										<input type="email" class="form-control" id="inputEmail3" />
									</div>
									<div class="col-sm-2">
										<button class="btn btn_success">发送</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>

			<hr>
			<div class="row clearfix">
				<div class="col-md-8 column">
					<div class="row clearfix">
						<div class="col-md-3 column">
							<img src="http://ibootstrap-file.b0.upaiyun.com/lorempixel.com/64/64/default.jpg" 
							class="media-object" alt='' />
						</div>
						<div class="col-md-9 column">
						<!-- form表单提交会被struts2当作action执行. -->
							 <form onsubmit="return false;">
  								<div class="form-group">
    								<label for="usercomment">写下你的评论吧！</label>
    								<textarea id="usercomment" name="usercomment" class="form-control" rows="3"></textarea>
  								</div>
  								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
						 				<button name="<%= f.getFilenumber()%>" onclick="return btn_comment(this)" class="btn btn-default">评论</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
				<div class="col-md-4 column">
					
    				
				</div>
			</div>
			<div id="videoconment" class="row clearfix">
				<div class="col-md-12 column">
					<div class="media">
				 		<a href="#" class="pull-left">
				 			<img height="128" width="128" alt="140x140" src="/Community/static/img/userdefault.png" class="media-object" alt='' />
				 		</a>
						<div class="media-body">
							<h4 class="media-heading">
							<%= f.getFilename() %>
							</h4> 
							<%= f.getFiledescription() %>
						</div>
					</div>
				</div>
			</div>
		</div>		
	</body>
</html>