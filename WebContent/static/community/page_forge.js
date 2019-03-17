/*
 * forge.jsp页面行为控制
 * 初始应该载入登陆部分
 */
//var code="" ; //在全局 定义验证码
$(document).ready(function() {
	$("#forge").load("Login.jsp");
	//createCode();
});



//img_login的mouseover事件
function img_login_over() {
	$(".img_login").attr("src","img/login_black.svg");
}
//img_login的mouseout事件
function img_login_out() {
	$(".img_login").attr("src","img/login_gray.svg");
}
//img_login的click事件，load登陆分页
function img_login_click() {
	$(".img_login").attr("src","img/login_white.svg");
	$("#forge").load("Login.jsp");
}


//img_regist的mouseover事件
function img_regist_over() {
	$(".img_regist").attr("src","img/regist_black.svg");
}
//img_regist的mouseout事件
function img_regist_out() {
	$(".img_regist").attr("src","img/regist_gray.svg");
}
//img_regist的click事件，load注册分页
function img_regist_click() {
	$(".img_regist").attr("src","img/regist_white.svg");
	$("#forge").load("Regist.jsp");
	document.title = "注册";
}


/*
 * 图片验证码
 */
/*
 * 问题记录：document.getElementById("checkCode")总是获取为空
 * 知识点：浅谈js在html中的加载执行顺序,多个jquery ready执行顺序
 * 参考网站：https://blog.csdn.net/tel13259437538/article/details/83352987
 * 个人解决办法：此js代码段移植到Login.jsp的body内部
 * 
 * 关于“切记包含有类似getElement代码<script>代码段 必须出现在HTML的Element之后”
 * 【见于https://blog.csdn.net/xiongchao2011/article/details/7039221】
 * 个人实践：没必要（可能是因为js自身更新或者浏览器处理）
 */
/*function createCode(){ 
	
	console.log("创建验证码");
	
	code = "";
	var codeLength = 6;//验证码的长度
	var checkCode = document.getElementById("checkCode");
	console.log(checkCode.id);
	//checkCode.value = "？请点击刷新？";
	var selectChar = new Array(0,1,2,3,4,5,6,7,8,9,
			'A','B','C','D','E','F','G','H','J','K','L','M','N',
			'P','Q','R','S','T','U','V','W','X','Y','Z');

	for(var i=0;i<codeLength;i++) {
		var charIndex = Math.floor(Math.random()*32);
		code += selectChar[charIndex];
	}
	
	console.log("验证码是" + code);
	
	checkCode.value = code;
}

function validate(){
	
	console.log("验证验证码为" + code);
	
	var inputCode = $("#inputCheck").value.toUpperCase();
	
	console.log("输入了：" + inputCode);

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
		alert("验证码通过！");
		$("#loginForm").action = "/Community/action/LoginAction";
		$("#loginForm").submit();
		return true;
	}
}*/