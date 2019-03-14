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
					</div>
				</div>
		<div class="col-md-2 column">
			<img alt="140x140" src="http://ibootstrap-file.b0.upaiyun.com/lorempixel.com/140/140/default.jpg" class="img-circle" />
			<div class="list-group">
				 <a href="#" class="list-group-item active">Home</a>
				<div class="list-group-item">
					List header
				</div>
				<div class="list-group-item">
					<h4 class="list-group-item-heading">
						List group item heading
					</h4>
					<p class="list-group-item-text">
						...
					</p>
				</div>
				<div class="list-group-item">
					 <span class="badge">14</span> Help
				</div> <a class="list-group-item active"> <span class="badge">14</span> Help</a>
			</div>
		</div>
		<div class="col-md-6 column">
			<div class="panel-group" id="panel-722495">
				<div class="panel panel-default">
					<div class="panel-heading">
						 <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-722495" href="#panel-element-851633">Collapsible Group Item #1</a>
					</div>
					<div id="panel-element-851633" class="panel-collapse collapse">
						<div class="panel-body">
							Anim pariatur cliche...
						</div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">
						 <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-722495" href="#panel-element-509700">Collapsible Group Item #2</a>
					</div>
					<div id="panel-element-509700" class="panel-collapse collapse">
						<div class="panel-body">
							Anim pariatur cliche...
						</div>
					</div>
				</div>
			</div>
			<div class="row clearfix">
				<div class="col-md-12 column">
					<ul class="pagination">
						<li>
							 <a href="#">Prev</a>
						</li>
						<li>
							 <a href="#">1</a>
						</li>
						<li>
							 <a href="#">2</a>
						</li>
						<li>
							 <a href="#">3</a>
						</li>
						<li>
							 <a href="#">4</a>
						</li>
						<li>
							 <a href="#">5</a>
						</li>
						<li>
							 <a href="#">Next</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="col-md-4 column">
			 <a id="modal-702946" href="#modal-container-702946" role="button" class="btn" data-toggle="modal">触发遮罩窗体</a>
			
			<div class="modal fade" id="modal-container-702946" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">
								标题
							</h4>
						</div>
						<div class="modal-body">
							内容...
						</div>
						<div class="modal-footer">
							 <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> <button type="button" class="btn btn-primary">保存</button>
						</div>
					</div>
					
				</div>
				
			</div>
			
			<div class="alert alert-success alert-dismissable">
				 <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
				<h4>
					注意!
				</h4> <strong>Warning!</strong> Best check yo self, you're not looking too good. <a href="#" class="alert-link">alert link</a>
			</div>
		</div>
	</div>
</div>
</body>
</html>