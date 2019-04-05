<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--  本页是一个分页，用于加载进入Forge.jsp的主div中 -->
<!-- 最终优化：验证码控件的更换 -->
<!-- 最终优化：提供邮箱登陆的支持 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>用户登录</title>
	</head>
	<body>
		<script type="text/javascript">
		
		/* 页面准备就绪之后立即生成验证码 */
		$(document).ready(function() {
			createCode();
		});
		
		/* 用于产生验证码 */
		function createCode(){ 
			//测试输出
			//console.log("创建验证码");
			
			code = "";
			var codeLength = 6;//验证码的长度
			var checkCode = document.getElementById("checkCode");
			//console.log(checkCode.id);
			//checkCode.value = "？请点击刷新？";
			var selectChar = new Array(0,1,2,3,4,5,6,7,8,9,
					'A','B','C','D','E','F','G','H','J','K','L','M','N',
					'P','Q','R','S','T','U','V','W','X','Y','Z');

			for(var i=0;i<codeLength;i++) {
				var charIndex = Math.floor(Math.random()*32);
				code += selectChar[charIndex];
			}
			//测试输出
			//console.log("验证码是" + code);
			
			checkCode.value = code;
		}

		//登陆时需要先验证验证码
		function validate(){
			
			//console.log("验证验证码为" + code);
			
			//此文件并未使用jquery，无法使用$
			//父.load(子);关于父子页面的js间的关系？？
			//var inputCode = $("#inputCheck").value;
			var inputCode = document.getElementById("inputCheck").value;
			
			//console.log("输入了：" + inputCode);

			if(inputCode.length <= 0) {
				alert("请输入验证码！");
				return false;
			}
			else if(inputCode != code ){
				alert("验证码输入错误！");
				createCode();
				return false;
			}
			else {
				//alert("验证码通过！");
				
				//提交登陆表单
				$("#loginForm").submit();
				return true;
			}
		}
		
		</script>
		
		
		<!-- 注意表单的提交路径,Community是默认的根，/action则对应xml文件中的namespace-->
		<form id="loginForm" style="margin-top:50px" class="form-horizontal" action="/Community/action/LoginAction" method="post">
			<div class="form-group">
				<label  class="col-sm-2 control-label">昵称：</label>
				<div class="col-sm-8">
					<input placeholder="请输入您的用户名" class="form-control text_area_transparency" 
					name="username" type="text" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">密码：</label>
				<div class="col-sm-8">
					<input placeholder="请输入您的密码" class="form-control text_area_transparency" 
					name="userpassword" type="password" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">验证码：</label>
				<div class="col-sm-4">
					<input id="inputCheck" placeholder="请输入图中的验证码" class="form-control text_area_transparency" 
					name="usertestpassword" type="text" />
				</div>
				<div class="col-sm-4">
					<input value="请点击刷新" class="btn" type="button" id="checkCode" onclick="return createCode()"/>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-3 col-sm-5">
					 <button onclick="return validate()" class="btn btn-success btn-block">登录</button>
				</div>
			</div>
		</form>
	</body>
</html>