<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>用户注册</title>
</head>
<body>
	<script type="text/javascript">
	/* 中的成员变量名称都和ajax中的data：｛...｝名称相一致 */
	function register_click(){
		$.get("/Community/ajaxaction/RegisterAction", 
				{username:$("#username").val(),
				 useremail:$("#useremail").val(),
				 userpassword:$("#userpassword").val()},
				function (data, textStatus){
					console.log(data);
					$(".img_login").attr("src","img/login_white.svg");
					$("#forge").load("Login.jsp");
			});
	}
	</script>
	<form class="form-horizontal">
      	<div class="form-group">
					 <label  class="col-sm-2 control-label">昵称：</label>
					<div class="col-sm-8">
						<input class="form-control text_area_transparency" id="username" name="username" type="text" />
					</div>
					</div>
				<div class="form-group">
					 <label  class="col-sm-2 control-label">邮箱：</label>
					<div class="col-sm-8">
						<input class="form-control text_area_transparency" id="useremail" name="useremail" type="email" />
					</div>
				</div>
				<div class="form-group">
					 <label class="col-sm-2 control-label">密码：</label>
					<div class="col-sm-8">
						<input class="form-control text_area_transparency" id="userpassword" name="userpassword" type="password" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">确认：</label>
					<div class="col-sm-8">
						<input class="form-control text_area_transparency" id="confirmpassword" name="confirmpassword" type="password" />
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
						 <button id="btn_register" onclick="return register_click()" class="btn btn-success btn-block">注册</button>
					</div>
				</div>
			</form>
</body>
</html>