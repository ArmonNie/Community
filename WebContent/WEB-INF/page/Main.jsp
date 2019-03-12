<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<!-- json.js和jquery冲突,采用了其他方法解析json -->
		<%-- <script src="${pageContext.request.contextPath}/basejs/json.js"></script> --%>
		<script src="${pageContext.request.contextPath}/basejs/jquery.js"></script>
		<script src="${pageContext.request.contextPath}/community/community.js"></script>
		<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/airplane/three.min.js"></script>
		<script src="${pageContext.request.contextPath}/airplane/airplane.js"></script>
		<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/community/community.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/airplane/airplane.css">
		<title>社区</title>
	</head>
	<body class="bg-warning">
		<script type="text/javascript">
		function all_video_click() {
			$.get("/Community/ajaxaction/LoadJsonAction", 
					{tag:"all"},
					function (data, textStatus){
						$("#content").html("");
						console.log("OK");
						/* 处理json数据并执行 */
						//$("#content").append(data);
						//$("#content").load(data);
						//$("#content").html(data);
						//$("#content").load("filePart.html");
						var obj = JSON.parse(data);
						console.log(obj.jsonresult[0].filename + obj.jsonresult[0].filesize);
						$("#content").append('<div class="container-fluid"><div class="row-fluid"><div class="span12">');
						//$("#content").append('<h2>电影</h2><hr>');
						$("#content").append('<table class="table">');
						$("#content").append('<thead>');
						$("#content").append('<tr>');
						$("#content").append('<th>文件名</th>');
						$("#content").append('<th>文件大小</th>');
						$("#content").append('<th>热度</th>');
						$("#content").append('<th>操作</th>');
						$("#content").append('</tr>');
						$("#content").append('</thead>');
						$("#content").append('<tbody>');
						for(var i = 0;i<obj.jsonresult.length;i++)
						{
						$("#content").append('<tr>');
						$("#content").append('<td><a>'+ obj.jsonresult[i].filename + '</a></td>');
						$("#content").append('<td>'+ obj.jsonresult[i].filesize + '</td></tr>');
						}
						$("#content").append('</tbody></table>');
						$("#content").append('<h2>电视</h2><hr>');
						$("#content").append('<table class="table">');
						$("#content").append('<thead>');
						$("#content").append('<tr>');
						$("#content").append('<th>文件名</th>');
						$("#content").append('<th>文件大小</th>');
						$("#content").append('<th>热度</th>');
						$("#content").append('<th>操作</th>');
						$("#content").append('</tr>');
						$("#content").append('</thead>');
						$("#content").append('<tbody>');
						for(var i = 0;i<obj.jsonresult.length;i++)
						{
						$("#content").append('<tr>');
						$("#content").append('<td><a>'+ obj.jsonresult[i].filename + '</a></td>');
						$("#content").append('<td>'+ obj.jsonresult[i].filesize + '</td></tr>');
						}
						$("#content").append('</tbody></table>');
						$("#content").append('<h2>CG动漫</h2><hr>');
						$("#content").append('<table class="table">');
						$("#content").append('<thead>');
						$("#content").append('<tr>');
						$("#content").append('<th>文件名</th>');
						$("#content").append('<th>文件大小</th>');
						$("#content").append('<th>热度</th>');
						$("#content").append('<th>操作</th>');
						$("#content").append('</tr>');
						$("#content").append('</thead>');
						$("#content").append('<tbody>');
						for(var i = 0;i<obj.jsonresult.length;i++)
						{
						$("#content").append('<tr>');
						$("#content").append('<td><a>'+ obj.jsonresult[i].filename + '</a></td>');
						$("#content").append('<td>'+ obj.jsonresult[i].filesize + '</td></tr>');
						}
						$("#content").append('</tbody></table>');
						$("#content").append("</div></div></div>");
						/* $("#content").load("Video.jsp"); */
				});
		}
		window.onload = all_video_click;
		function tv_video_click() {
			$.get("/Community/ajaxaction/LoadJsonAction", 
					{tag:"all"},
					function (data, textStatus){
						$("#content").html("");
						console.log("OK");
						/* 处理json数据并执行 */
						var obj = JSON.parse(data);
						console.log(obj.jsonresult[0].filename + obj.jsonresult[0].filesize);
						$("#content").append('<div class="container-fluid"><div class="row-fluid"><div class="span12">');
						$("#content").append('<h2>电视</h2><hr>');
						$("#content").append('<table class="table">');
						$("#content").append('<thead>');
						$("#content").append('<tr>');
						$("#content").append('<th>文件名</th>');
						$("#content").append('<th>文件大小</th>');
						$("#content").append('<th>热度</th>');
						$("#content").append('<th>操作</th>');
						$("#content").append('</tr>');
						$("#content").append('</thead>');
						$("#content").append('<tbody>');
						for(var i = 0;i<obj.jsonresult.length;i++)
						{
						$("#content").append('<tr>');
						$("#content").append('<td><a>'+ obj.jsonresult[i].filename + '</a></td>');
						$("#content").append('<td>'+ obj.jsonresult[i].filesize + '</td></tr>');
						}
						$("#content").append('</tbody></table>');
						$("#content").append('</div></div></div>');
				});
		}
		function movie_video_click() {
			$.get("/Community/ajaxaction/LoadJsonAction", 
					{tag:"all"},
					function (data, textStatus){
						$("#content").html("");
						console.log("OK");
						/* 处理json数据并执行 */
						var obj = JSON.parse(data);
						console.log(obj.jsonresult[0].filename + obj.jsonresult[0].filesize);
						$("#content").append('<div class="container-fluid"><div class="row-fluid"><div class="span12">');
						$("#content").append('<h2>电影</h2><hr>');
						$("#content").append('<table class="table">');
						$("#content").append('<thead>');
						$("#content").append('<tr>');
						$("#content").append('<th>文件名</th>');
						$("#content").append('<th>文件大小</th>');
						$("#content").append('<th>热度</th>');
						$("#content").append('<th>操作</th>');
						$("#content").append('</tr>');
						$("#content").append('</thead>');
						$("#content").append('<tbody>');
						for(var i = 0;i<obj.jsonresult.length;i++)
						{
						$("#content").append('<tr>');
						$("#content").append('<td><a>'+ obj.jsonresult[i].filename + '</a></td>');
						$("#content").append('<td>'+ obj.jsonresult[i].filesize + '</td></tr>');
						}
						$("#content").append('</tbody></table>');
						$("#content").append('</div></div></div>');
				});
		}
		function cg_video_click() {
			$("#content").html("");
			$.get("/Community/ajaxaction/LoadJsonAction", 
					{tag:"all"},
					function (data, textStatus){
						console.log("OK");
						/* 处理json数据并执行 */
						var obj = JSON.parse(data);
						console.log(obj.jsonresult[0].filename + obj.jsonresult[0].filesize);
						$("#content").append('<div class="container-fluid"><div class="row-fluid"><div class="span12">');
						$("#content").append('<h2>CG动漫</h2><hr>');
						$("#content").append('<table class="table">');
						$("#content").append('<thead>');
						$("#content").append('<tr>');
						$("#content").append('<th>文件名</th>');
						$("#content").append('<th>文件大小</th>');
						$("#content").append('<th>热度</th>');
						$("#content").append('<th>操作</th>');
						$("#content").append('</tr>');
						$("#content").append('</thead>');
						$("#content").append('<tbody>');
						for(var i = 0;i<obj.jsonresult.length;i++)
						{
						$("#content").append('<tr>');
						$("#content").append('<td><a>'+ obj.jsonresult[i].filename + '</a></td>');
						$("#content").append('<td>'+ obj.jsonresult[i].filesize + '</td></tr>');
						}
						$("#content").append('</tbody></table>');
						$("#content").append('</div></div></div>');
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
				</div>
				<div class="col-md-12 column">
					<div class="col-md-1 column"></div>
					<div class="col-md-10 column">
						<div id="content" class="margin">
						<!-- 内容区域 -->
						</div>
					</div>
					<div class="col-md-1 column"></div>
				</div>
			</div>
		</div>		
	</body>
</html>