<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="org.apache.struts2.ServletActionContext"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<!-- 基本js（jquery）与css（bootstrap） -->
		<script src="${pageContext.request.contextPath}/static/basejs/jquery.js"></script>
		<script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css">
		<!-- 本页行为js -->
		<script src="${pageContext.request.contextPath}/static/community/page_usercenter.js"></script>
		<!-- 网站主题样式 -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/community/community.css">
		<!-- 网站背景动画 -->
		<script src="${pageContext.request.contextPath}/static/airplane/three.min.js"></script>
		<script src="${pageContext.request.contextPath}/static/airplane/airplane.js"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/airplane/airplane.css">
		<title>用户中心</title>
	</head>
	<body class="bg-warning">
		<div id="world">
			<!-- 加载背景动画 -->
		</div>
		<!-- 模态框 -->
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
		<!-- 内容容器 -->
		<div class="container">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<div class="page-header">
						<h1>
							<small class="font_title">回忆</small>
						</h1>
					</div>
				</div>
			</div>
			<div class="row clearfix">
				<div class="col-md-2 column">
					<img alt="140x140" src="http://ibootstrap-file.b0.upaiyun.com/lorempixel.com/140/140/default.jpg" 
					class="img-circle" />
					<p>用户名</p>
					<div class="list-group">
				 		<a href="#" class="list-group-item">播放历史</a>
				 		<a href="#" class="list-group-item">收藏记录</a>
				 		<a href="#" class="list-group-item">上传记录</a>
					</div>
				</div>
				<div class="col-md-6 column">
				panel列表
				<!-- 列表以panel形式显示 -->
				</div>
				<div class="col-md-4 column">
					<a id="modal-702946" href="#modal-container-702946" role="button" class="btn" data-toggle="modal">触发遮罩窗体</a>
					<div class="alert alert-success alert-dismissable">
						<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
						<h4>
							注意!
						</h4> 
						<strong>Warning!</strong>
						 Best check yo self, you're not looking too good. 
						 <a href="#" class="alert-link">alert link</a>
					</div>
					<!-- 其他消息（公告等等） -->
				</div>
			</div>
		</div>
		<div style="width:600px;height:240px;overflow-y:auto;border:1px solid #333;" id="show">
		</div>
		<input type="text" size="80" id="msg" name="msg" placeholder="输入内容"/>
		<input type="button" value="发送" id="sendBn" name="sendBn"/>

</body>
</html>