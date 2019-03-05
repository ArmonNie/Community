<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
</head>
<body>
<form class="form-horizontal" action="RegistServlet" method="post">
                <div class="form-group">
					 <label  class="col-sm-2 control-label">昵称：</label>
					<div class="col-sm-8">
						<input class="form-control text_area_transparency" name="name" type="text" />
					</div>
					</div>
				<div class="form-group">
					 <label  class="col-sm-2 control-label">邮箱：</label>
					<div class="col-sm-8">
						<input class="form-control text_area_transparency" name="email" type="email" />
					</div>
				</div>
				<div class="form-group">
					 <label class="col-sm-2 control-label">密码：</label>
					<div class="col-sm-8">
						<input class="form-control text_area_transparency" type="password" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">确认：</label>
					<div class="col-sm-8">
						<input class="form-control text_area_transparency" name="pwd" type="password" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-3 col-sm-5">
						 <div class="input-group">
                            <input type="text" class="form-control text_area_transparency">
                              <span class="input-group-btn">
                                <button class="btn btn-default text_area_transparency" type="button">验证</button>
                              </span>
                          </div>   
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-3 col-sm-5">
						 <button type="submit" class="btn btn-success btn-block">注册</button>
					</div>
				</div>
			</form>
</body>
</html>