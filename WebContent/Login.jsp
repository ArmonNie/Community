<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body>
	<!-- 注意表单的提交路径,Community是默认的根，/action则对应xml文件中的namespace-->
	<form class="form-horizontal" action="/Community/action/LoginAction" method="post">
		<div class="form-group">
			<label  class="col-sm-2 control-label">昵称：</label>
			<div class="col-sm-8">
				<input class="form-control text_area_transparency" name="username" type="text" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">密码：</label>
			<div class="col-sm-8">
				<input class="form-control text_area_transparency" name="userpassword" type="password" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<div class="checkbox">
					 <label><input type="checkbox" />记住我</label>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-3 col-sm-5">
				 <button type="submit" class="btn btn-success btn-block">登录</button>
			</div>
		</div>
	</form>
</body>
</html>