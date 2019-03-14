<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="org.apache.struts2.ServletActionContext"%>
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
						//调试代码
						//console.log(obj.jsonresult[0].filename + obj.jsonresult[0].filesize);
						//避免重复加载，每次加载数据前先清空
						$("#content").html("");
						/* 处理json数据并执行 */
						var obj = JSON.parse(data);
						//append注意：https://blog.csdn.net/qq_22771739/article/details/80554675
						//全部-电影块
						var str1 = '<div class="container-fluid">\n<div class="row-fluid">\n<div class="span12">\n';
						str1 += '<h2>电影</h2><hr>' + '<table class="table table-hover table-bordered">\n' +
						'<thead>\n<tr class="">\n<th>文件名</th><th>文件大小</th><th>热度</th><th>操作</th></tr>\n</thead><tbody>\n';
						for(var i = 0;i<obj.jsonresult.length;i++)
						{
							if(obj.jsonresult[i].filetype == "0")
							{
							str1 += '<tr>\n' + 
							'<td><a data-toggle="modal" data-target="#myModal">'
							+ obj.jsonresult[i].filename + '</a></td>' +
							'<td>'+ obj.jsonresult[i].filesize + "MB"+ '</td>' +
							'<td>'+ obj.jsonresult[i].goodnumber + '</td>' +
							'<td><div class="btn-group">' +
							'<button name="' +obj.jsonresult[i].filenumber + 
							'"' + ' class="btn btn-primary btn_manager" type="button">' 
							+ "下载" + '</button>' + 
							'<button name="' +obj.jsonresult[i].filenumber + 
							'"' + ' class="btn btn-primary btn_manager" type="button">' +
							"详情" + '</button>' +
							'<button name="' +obj.jsonresult[i].filenumber + 
							'"' + ' class="btn btn-primary btn_manager" type="button">' + 
							"播放" + '</button>' +  '</div></td>\n</tr>\n';
							}
						}
						str1 += '</tbody></table></div></div></div>';
						//全部-电视块
						str1 += '<div class="container-fluid"><div class="row-fluid"><div class="span12">' +
								'<h2>电视</h2><hr>' + '<table class="table table-hover table-bordered">\n' +
								'<thead>\n<tr class="">\n<th>文件名</th><th>文件大小</th><th>热度</th><th>操作</th></tr>\n</thead><tbody>\n';
						for(var i = 0;i<obj.jsonresult.length;i++)
						{
							if(obj.jsonresult[i].filetype == "2")
							{
							str1 += '<tr>\n' + 
									'<td><a data-toggle="modal" data-target="#myModal">'
									+ obj.jsonresult[i].filename + '</a></td>' +
									'<td>'+ obj.jsonresult[i].filesize + "MB"+ '</td>' +
									'<td>'+ obj.jsonresult[i].goodnumber + '</td>' +
									'<td><div class="btn-group">' +
									'<button name="' +obj.jsonresult[i].filenumber + 
									'"' + ' class="btn btn-primary btn_manager" type="button">' 
									+ "下载" + '</button>' + 
									'<button name="' +obj.jsonresult[i].filenumber + 
									'"' + ' class="btn btn-primary btn_manager" type="button">' +
									"详情" + '</button>' +
									'<button name="' +obj.jsonresult[i].filenumber + 
									'"' + ' class="btn btn-primary btn_manager" type="button">' + 
									"播放" + '</button>' +  '</div></td>\n</tr>\n';
							}
						}
						str1 += '</tbody></table></div></div></div>';
						//全部-CG块
						str1 += '<div class="container-fluid"><div class="row-fluid"><div class="span12">' +
								'<h2>CG动漫</h2><hr>' + '<table class="table table-hover table-bordered">\n' +
								'<thead>\n<tr class="">\n<th>文件名</th><th>文件大小</th><th>热度</th><th>操作</th></tr>\n</thead><tbody>\n';
						for(var i = 0;i<obj.jsonresult.length;i++)
						{
							if(obj.jsonresult[i].filetype == "1")
							{
								str1 += '<tr>\n' + 
										'<td><a data-toggle="modal" data-target="#myModal">'
										+ obj.jsonresult[i].filename + '</a></td>' +
										'<td>'+ obj.jsonresult[i].filesize + "MB"+ '</td>' +
										'<td>'+ obj.jsonresult[i].goodnumber + '</td>' +
										'<td><div class="btn-group">' +
										'<button name="' +obj.jsonresult[i].filenumber + 
										'"' + ' class="btn btn-primary btn_manager" type="button">' 
										+ "下载" + '</button>' + 
										'<button name="' +obj.jsonresult[i].filenumber + 
										'"' + ' class="btn btn-primary btn_manager" type="button">' +
										"详情" + '</button>' +
										'<button name="' +obj.jsonresult[i].filenumber + 
										'"' + ' class="btn btn-primary btn_manager" type="button">' + 
										"播放" + '</button>' +  '</div></td>\n</tr>\n';
							}
						}
						str1 += '</tbody></table></div></div></div>';
						$("#content").append(str1);
				});
		}
		window.onload = all_video_click;
		function tv_video_click() {
			$.get("/Community/ajaxaction/LoadJsonAction", 
					{tag:"2"},
					function (data, textStatus){
						//调试代码
						//console.log(obj.jsonresult[0].filename + obj.jsonresult[0].filesize);
						//加载前必须先清除
						$("#content").html("");
						/* 处理json数据并执行 */
						var obj = JSON.parse(data);
						//TV块
						var str1 = '<div class="container-fluid"><div class="row-fluid"><div class="span12">' +
								'<h2>CG动漫</h2><hr>' + '<table class="table table-hover table-bordered">\n' +
								'<thead>\n<tr class="">\n<th>文件名</th><th>文件大小</th><th>热度</th><th>操作</th></tr>\n</thead><tbody>\n';
						for(var i = 0;i<obj.jsonresult.length;i++)
						{
							if(obj.jsonresult[i].filetype == "2")
							{
								str1 += '<tr>\n' + 
										'<td><a data-toggle="modal" data-target="#myModal">'
										+ obj.jsonresult[i].filename + '</a></td>' +
										'<td>'+ obj.jsonresult[i].filesize + "MB"+ '</td>' +
										'<td>'+ obj.jsonresult[i].goodnumber + '</td>' +
										'<td><div class="btn-group">' +
										'<button name="' +obj.jsonresult[i].filenumber + 
										'"' + ' class="btn btn-primary btn_manager" type="button">' 
										+ "下载" + '</button>' + 
										'<button name="' +obj.jsonresult[i].filenumber + 
										'"' + ' class="btn btn-primary btn_manager" type="button">' +
										"详情" + '</button>' +
										'<button name="' +obj.jsonresult[i].filenumber + 
										'"' + ' class="btn btn-primary btn_manager" type="button">' + 
										"播放" + '</button>' +  '</div></td>\n</tr>\n';
							}
						}
						str1 += '</tbody></table></div></div></div>';
						$("#content").append(str1);
				});
		}
		function movie_video_click() {
			$.get("/Community/ajaxaction/LoadJsonAction", 
					{tag:"0"},
					function (data, textStatus){
						//调试代码
						//console.log(obj.jsonresult[0].filename + obj.jsonresult[0].filesize);
						//加载前必须先清除
						$("#content").html("");
						/* 处理json数据并执行 */
						var obj = JSON.parse(data);
						//电影块
						var str1 = '<div class="container-fluid"><div class="row-fluid"><div class="span12">' +
								'<h2>电影</h2><hr>' + '<table class="table table-hover table-bordered">\n' +
								'<thead>\n<tr class="">\n<th>文件名</th><th>文件大小</th><th>热度</th><th>操作</th></tr>\n</thead><tbody>\n';
						for(var i = 0;i<obj.jsonresult.length;i++)
						{
							if(obj.jsonresult[i].filetype == "0")
							{
								str1 += '<tr>\n' + 
										'<td><a data-toggle="modal" data-target="#myModal">'
										+ obj.jsonresult[i].filename + '</a></td>' +
										'<td>'+ obj.jsonresult[i].filesize + "MB"+ '</td>' +
										'<td>'+ obj.jsonresult[i].goodnumber + '</td>' +
										'<td><div class="btn-group">' +
										'<button name="' +obj.jsonresult[i].filenumber + 
										'"' + ' class="btn btn-primary btn_manager" type="button">' 
										+ "下载" + '</button>' + 
										'<button name="' +obj.jsonresult[i].filenumber + 
										'"' + ' class="btn btn-primary btn_manager" type="button">' +
										"详情" + '</button>' +
										'<button name="' +obj.jsonresult[i].filenumber + 
										'"' + ' class="btn btn-primary btn_manager" type="button">' + 
										"播放" + '</button>' +  '</div></td>\n</tr>\n';
							}
						}
						str1 += '</tbody></table></div></div></div>';
						$("#content").append(str1);
				});
		}
		function cg_video_click() {
			$("#content").html("");
			$.get("/Community/ajaxaction/LoadJsonAction", 
					{tag:"1"},
					function (data, textStatus){
						//调试代码
						//console.log(obj.jsonresult[0].filename + obj.jsonresult[0].filesize);
						//加载前必须先清除
						$("#content").html("");
						/* 处理json数据并执行 */
						var obj = JSON.parse(data);
						//TV块
						var str1 = '<div class="container-fluid"><div class="row-fluid"><div class="span12">' +
								'<h2>CG动漫</h2><hr>' + '<table class="table table-hover table-bordered">\n' +
								'<thead>\n<tr class="">\n<th>文件名</th><th>文件大小</th><th>热度</th><th>操作</th></tr>\n</thead><tbody>\n';
						for(var i = 0;i<obj.jsonresult.length;i++)
						{
							if(obj.jsonresult[i].filetype == "1")
							{
								str1 += '<tr>\n' + 
										'<td><a data-toggle="modal" data-target="#myModal">'
										+ obj.jsonresult[i].filename + '</a></td>' +
										'<td>'+ obj.jsonresult[i].filesize + "MB"+ '</td>' +
										'<td>'+ obj.jsonresult[i].goodnumber + '</td>' +
										'<td><div class="btn-group">' +
										'<button name="' +obj.jsonresult[i].filenumber + 
										'"' + ' class="btn btn-primary btn_manager" type="button">' 
										+ "下载" + '</button>' + 
										'<button name="' +obj.jsonresult[i].filenumber + 
										'"' + ' class="btn btn-primary btn_manager" type="button">' +
										"详情" + '</button>' +
										'<button name="' +obj.jsonresult[i].filenumber + 
										'"' + ' class="btn btn-primary btn_manager" type="button">' + 
										"播放" + '</button>' +  '</div></td>\n</tr>\n';
							}
						}
						str1 += '</tbody></table></div></div></div>';
						$("#content").append(str1);
				});
		}
		</script>
		<div id="world">
		<!-- 加载背景动画 -->
		</div>
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    		<div class="modal-dialog">
       			 <div class="modal-content">
            		<div class="modal-header">       
               			 <h4 class="modal-title" id="myModalLabel">…</h4>
            		</div>
            		<div class="modal-body text-center">
            			<video class="video_size" id="video" controls="controls">
            				<source src="" type="audio/mp4"></source>
            			</video>      
            		</div>
            		<div class="modal-footer">
                
            		</div>
        		</div>
    		</div>
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
								<a class="dropdown-toggle" href="#" data-toggle="dropdown">
									<img src="${pageContext.request.contextPath}/img/login_gray.svg" class="margin">
									<%
									HttpSession mSession = ServletActionContext
									.getRequest().getSession();
									%>
									<%= mSession.getAttribute("username")%>
								</a>
								<ul class="dropdown-menu">
									<li><a href="/Community/action/LinkAction?index=<%= "usercenter" %>"">个人中心</a></li>
									<li><a onclick="get_collection()">信息中心</a></li>
									<li><a onclick="a_share_click()">上传视频</a></li>
									<li class="divider"></li>
									<li><a href="Quit.jsp">退出</a></li>
								</ul>
							</li>
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
									<button class="btn btn-success" type="button">搜索</button>
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