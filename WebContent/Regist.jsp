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
	/*输入校验*/
	function validate()
	{
		var result = 1;
		var reg = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$"); //邮箱正则表达式
		var email = $("#useremail").val(); //邮箱
		var username = $("#username").val();//用户名
		var userpassword = $("#userpassword").val();//密码
		var confirmpassword = $("#confirmpassword").val();//密码确认
		
		console.log("用户名：" + username 
				+ "邮箱：" + email 
				+ "密码" + userpassword
				+ "密码确认" + confirmpassword);
		
		if(!reg.test(email))
		{
			result = 0;
			$("#useremailerror").html("邮箱格式错误");
			return false;
		}
		if(username.length > 6)
		{
			result = 0;
			$("#usernameerror").html("用户名过长");
			return false;
		}
		if(userpassword != confirmpassword)
		{
			result = 0;
			$("#userpassworderror").html("密码前后不一致");
			return false;
		}
		if(result == 1)
		{
			register_click();
		}
		
	}
	
	
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
	<form class="form-horizontal" style="margin-top:50px">
      	<div class="form-group">
			<label  class="col-sm-2 control-label">昵称：</label>
			<div class="col-sm-8">
				<input placeholder="输入用户名，小于6个字符" class="form-control text_area_transparency" id="username" name="username" type="text" />
			</div>
			<div id="usernameerror" class="col-sm-offset-2 col-sm-8 text-right" style="color:red">
			<!-- 格式错误信息提示 -->
			</div>
		</div>
		<div class="form-group">
			<label  class="col-sm-2 control-label">邮箱：</label>
			<div class="col-sm-8">
				<input placeholder="请输入您的邮箱" class="form-control text_area_transparency" id="useremail" name="useremail" type="email" />
			</div>
			<div id="useremailerror" class="col-sm-offset-2 col-sm-8 text-right" style="color:red">
			<!-- 格式错误信息提示 -->
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">密码：</label>
			<div class="col-sm-8">
				<input placeholder="请输入您的密码" class="form-control text_area_transparency" id="userpassword" name="userpassword" type="password" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">确认：</label>
			<div class="col-sm-8">
				<input placeholder="请再次确认您的密码" class="form-control text_area_transparency" id="confirmpassword" name="confirmpassword" type="password" />
			</div>
			<div id="userpassworderror" class="col-sm-offset-2 col-sm-8 text-right" style="color:red">
			<!-- 格式错误信息提示 -->
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-3 col-sm-5">
				 <button id="btn_register" onclick="return validate()" class="btn btn-success btn-block">注册</button>
			</div>
		</div>
	</form>
</body>
</html>