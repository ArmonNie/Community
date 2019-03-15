/*
 * forge.jsp页面行为控制
 * 初始应该载入登陆部分
 */
$(document).ready(function() {
	$("#forge").load("Login.jsp");
});
//img_login的mouseover
function img_login_over() {
	$(".img_login").attr("src","img/login_black.svg");
}
//img_login的mouseout
function img_login_out() {
	$(".img_login").attr("src","img/login_gray.svg");
}
//img_login的click
function img_login_click() {
	$(".img_login").attr("src","img/login_white.svg");
	$("#forge").load("Login.jsp");
}
//img_regist的mouseover
function img_regist_over() {
	$(".img_regist").attr("src","img/regist_black.svg");
}
//img_regist的mouseout
function img_regist_out() {
	$(".img_regist").attr("src","img/regist_gray.svg");
}
//img_regist的click
function img_regist_click() {
	$(".img_regist").attr("src","img/regist_white.svg");
	$("#forge").load("Regist.jsp");
}
