$(document).ready(function() {
	$("#forge").load("Login.jsp");
});
function img_login_over() {
	$(".img_login").attr("src","img/login_black.svg");
}
function img_login_out() {
	$(".img_login").attr("src","img/login_gray.svg");
}
function img_login_click() {
	$(".img_login").attr("src","img/login_white.svg");
	$("#forge").load("Login.jsp");
}
function img_regist_over() {
	$(".img_regist").attr("src","img/regist_black.svg");
}
function img_regist_out() {
	$(".img_regist").attr("src","img/regist_gray.svg");
}
function img_regist_click() {
	$(".img_regist").attr("src","img/regist_white.svg");
	$("#forge").load("Regist.jsp");
}
function a_video_click() {
	$("#content").load("Video.jsp");
}
function a_audio_click() {
	$("#content").load("Audio.jsp");
}
function a_share_click(){
	$("#content").load("Share.jsp");
}
function a_collect_click(){
	$("#content").load("Collect.jsp");
}
function download(data) {
	$.post("DownloadServlet",{"msg" : data.name},
	function(data,status){
	window.location.href = "DownloadServlet";
	});	
}
function video_play(data){
	var v = document.getElementById("video");
	v.src="resource/"+data.name;
	v.load();
	v.play();
}
function set_collection(a){
	alert(a.name);
	$.post(
			"SetCollectServlet",
			{
				"filename" : a.name
			},
			function(data,status){
				alert(data);
			});
}
function get_collection(){
	$.post(
			"GetCollectServlet",
			{
				"filename" : ""
			},
			function(data,status){
				alert(data);
			});
}