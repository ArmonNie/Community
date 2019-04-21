/**
 * 管理员界面（收藏列表，历史记录）
 */
window.onload = getAllVideo;

function video_delete(data)
{
	console.log("删除视频");
	$.get("/Community/ajaxaction/DeleteFileAction", 
			{deleteid:data.name},
			function (data, textStatus){
				 //测试输出回调数据
				//console.log(data);
				show_alert(data);
				 getAllVideo();
				 //注册完之后显示登陆界面
				//$(".img_login").attr("src","img/login_white.svg");
				//$("#forge").load("Login.jsp");
		});
}

function user_delete(data)
{
	console.log("删除用户");
	$.get("/Community/ajaxaction/DeleteUserAction", 
			{deleteid:data.name},
			function (data, textStatus){
				 //测试输出回调数据
				//console.log(data);
				show_alert(data);
				 getAllUser();
				 //注册完之后显示登陆界面
				//$(".img_login").attr("src","img/login_white.svg");
				//$("#forge").load("Login.jsp");
		});
}

function video_detail(data)
{
	console.log("视频详情");
	$("#ModalOtherLabel").html("视频详情");
	//先清空body与footer
	$("#ModalOtherBody").html("");
	$("#ModalOtherFooter").html("");
}

function user_detail(data)
{
	console.log("用户详情");
	$("#ModalOtherLabel").html("用户详情");
	//先清空body与footer
	$("#ModalOtherBody").html("");
	$("#ModalOtherFooter").html("");
}

function user_changepassword(data)
{
	console.log("修改密码");
	$("#ModalOtherLabel").html("修改密码");
	//先清空body与footer
	$("#ModalOtherBody").html("");
	$("#ModalOtherFooter").html("");
	//修改密码表单
	var bodystr = "";
	bodystr += '<form role="form">';
	bodystr += '<div class="form-group"><label for="newpassword">新密码：</label>'
		+ '<input class="form-control" id="modalnewpassword" /></div>';
	bodystr += '</form>';
	$("#ModalOtherBody").html(bodystr);
	var footstr = "";
	footstr += ' <button name=' + data.name +' onclick="return user_confirmchangepassword(this)" class="btn btn-default">确认修改</button>';
	$("#ModalOtherFooter").html(footstr);
}

function user_confirmchangepassword(data)
{
	console.log("确认修改");
	$.get("/Community/ajaxaction/ChangePasswordAction", 
			{updateid:data.name,
			 userpassword:$("#modalnewpassword").val()},
			function (data, textStatus){
				 //测试输出回调数据
				//console.log(data);
				 show_alert(data);
				 $("#ModalOther").modal('hide');
				 getAllUser();
				 //注册完之后显示登陆界面
				//$(".img_login").attr("src","img/login_white.svg");
				//$("#forge").load("Login.jsp");
		});
}

function getAllVideo()
{
	console.log("获取所有视频信息");
	$.get("/Community/ajaxaction/LoadJsonAction", 
			{tag:"all"},
			function (data, textStatus){
				//调试代码
				//console.log(obj.jsonresult[0].filename + obj.jsonresult[0].filesize);
				//console.log(data);
				//避免重复加载，每次加载数据前先清空
				$("#content").html("");
				/* 处理json数据并执行 */
				var obj = JSON.parse(data);
				//append注意：https://blog.csdn.net/qq_22771739/article/details/80554675
				//全部-电影块
				var str1 = '<div class="container-fluid">\n<div class="row-fluid">\n<div class="span12">\n';
				str1 += '<h2>电影</h2><hr>' + '<table class="table table-hover table-bordered">\n' +
				'<thead>\n<tr class="">\n<th>文件名</th><th>文件大小</th><th>热度</th><th>操作</th></tr>\n</thead><tbody>\n';
				for(var i = 0;i<obj.jsonresult.length;i++)
				{
					if(obj.jsonresult[i].filetype == "0")
					{
					str1 += '<tr>\n' + 
					'<td><a data-toggle="modal" data-target="#myModal" onclick="video_preview(this)">'
					+ obj.jsonresult[i].filename + '</a></td>' +
					'<td>'+ obj.jsonresult[i].filesize + "MB"+ '</td>' +
					'<td>'+ obj.jsonresult[i].goodnumber + '</td>' +
					'<td><div class="btn-group">' +
					'<button data-toggle="modal" data-target="#myModal" name="' +obj.jsonresult[i].filename + 
					'"' + ' class="btn btn-primary btn_manager" type="button" onclick="return video_preview(this)">' 
					+ "播放" + '</button>' + 
					'<button data-toggle="modal" data-target="#ModalOther" name="' +obj.jsonresult[i].filenumber + 
					'"' + ' class="btn btn-primary btn_manager" type="button" onclick="return video_detail(this)">' +
					"详情" + '</button>' +
					'<button name="' +obj.jsonresult[i].fileid + 
					'"' + ' class="btn btn-primary btn_manager" type="button" onclick="return video_delete(this)">' + 
					"删除" + '</button>' +  '</div></td>\n</tr>\n';
					}
				}
				str1 += '</tbody></table></div></div></div>';
				//全部-电视块
				str1 += '<div class="container-fluid"><div class="row-fluid"><div class="span12">' +
						'<h2>电视</h2><hr>' + '<table class="table table-hover table-bordered">\n' +
						'<thead>\n<tr class="">\n<th>文件名</th><th>文件大小</th><th>热度</th><th>操作</th></tr>\n</thead><tbody>\n';
				for(var i = 0;i<obj.jsonresult.length;i++)
				{
					if(obj.jsonresult[i].filetype == "2")
					{
						str1 += '<tr>\n' + 
						'<td><a data-toggle="modal" data-target="#myModal" onclick="video_preview(this)">'
						+ obj.jsonresult[i].filename + '</a></td>' +
						'<td>'+ obj.jsonresult[i].filesize + "MB"+ '</td>' +
						'<td>'+ obj.jsonresult[i].goodnumber + '</td>' +
						'<td><div class="btn-group">' +
						'<button data-toggle="modal" data-target="#myModal" name="' +obj.jsonresult[i].filename + 
						'"' + ' class="btn btn-primary btn_manager" type="button" onclick="return video_preview(this)">' 
						+ "播放" + '</button>' + 
						'<button data-toggle="modal" data-target="#ModalOther" name="' +obj.jsonresult[i].filenumber + 
						'"' + ' class="btn btn-primary btn_manager" type="button" onclick="return video_detail(this)">' +
						"详情" + '</button>' +
						'<button name="' +obj.jsonresult[i].fileid + 
						'"' + ' class="btn btn-primary btn_manager" type="button" onclick="return video_delete(this)">' + 
						"删除" + '</button>' +  '</div></td>\n</tr>\n';
					}
				}
				str1 += '</tbody></table></div></div></div>';
				//全部-CG块
				str1 += '<div class="container-fluid"><div class="row-fluid"><div class="span12">' +
						'<h2>CG动漫</h2><hr>' + '<table class="table table-hover table-bordered">\n' +
						'<thead>\n<tr class="">\n<th>文件名</th><th>文件大小</th><th>热度</th><th>操作</th></tr>\n</thead><tbody>\n';
				for(var i = 0;i<obj.jsonresult.length;i++)
				{
					if(obj.jsonresult[i].filetype == "1")
					{
						str1 += '<tr>\n' + 
						'<td><a data-toggle="modal" data-target="#myModal" onclick="video_preview(this)">'
						+ obj.jsonresult[i].filename + '</a></td>' +
						'<td>'+ obj.jsonresult[i].filesize + "MB"+ '</td>' +
						'<td>'+ obj.jsonresult[i].goodnumber + '</td>' +
						'<td><div class="btn-group">' +
						'<button data-toggle="modal" data-target="#myModal" name="' +obj.jsonresult[i].filename + 
						'"' + ' class="btn btn-primary btn_manager" type="button" onclick="return video_preview(this)">' 
						+ "播放" + '</button>' + 
						'<button data-toggle="modal" data-target="#ModalOther" name="' +obj.jsonresult[i].filenumber + 
						'"' + ' class="btn btn-primary btn_manager" type="button" onclick="return video_detail(this)">' +
						"详情" + '</button>' +
						'<button name="' +obj.jsonresult[i].fileid + 
						'"' + ' class="btn btn-primary btn_manager" type="button" onclick="return video_delete(this)">' + 
						"删除" + '</button>' +  '</div></td>\n</tr>\n';
					}
				}
				str1 += '</tbody></table></div></div></div>';
				$("#content").append(str1);
		});
}

function getAllUser()
{
	console.log("获取所有用户中");
	$.get("/Community/ajaxaction/GetAllUserAction", 
			{},
			function (data, textStatus){
				//调试代码
				//console.log(obj.jsonresult[0].filename + obj.jsonresult[0].filesize);
				console.log(data);
				//避免重复加载，每次加载数据前先清空
				$("#content").html("");
				/* 处理json数据并执行 */
				var obj = JSON.parse(data);
				//append注意：https://blog.csdn.net/qq_22771739/article/details/80554675
				//全部-电影块
				var str1 = '<div class="container-fluid">\n<div class="row-fluid">\n<div class="span12">\n';
				str1 += '<h2>用户列表</h2><hr>' + '<table class="table table-hover table-bordered">\n' +
				'<thead>\n<tr class="">\n<th>用户名</th><th>用户编号</th><th>用户密码</th><th>操作</th></tr>\n</thead><tbody>\n';
				for(var i = 0;i<obj.userlist.length;i++)
				{
					str1 += '<tr>\n' + 
					'<td><a>'
					+ obj.userlist[i].username + '</a></td>' +
					'<td>'+ obj.userlist[i].usernumber + "MB"+ '</td>' +
					'<td>'+ obj.userlist[i].userpassword + '</td>' +
					'<td><div class="btn-group">' +
					'<button data-toggle="modal" data-target="#ModalOther" name="' +obj.userlist[i].userid + 
					'"' + ' class="btn btn-primary btn_manager" type="button" onclick="return user_changepassword(this)">' 
					+ "修改密码" + '</button>' + 
					'<button data-toggle="modal" data-target="#ModalOther" name="' +obj.userlist[i].usernumber + 
					'"' + ' class="btn btn-primary btn_manager" type="button" onclick="return user_detail(this)">' +
					"详情" + '</button>' +
					'<button name="' + obj.userlist[i].userid + 
					'"' + ' class="btn btn-primary btn_manager" type="button" onclick="return user_delete(this)">' + 
					"删除" + '</button>' +  '</div></td>\n</tr>\n';
				}
				str1 += '</tbody></table></div></div></div>';
				$("#content").append(str1);
		});
}

//搜索按钮事件
function video_search()
{
	var inputsearch = $("#inputsearch").val();
	console.log("用户输入了" + inputsearch);
	$.get("/Community/ajaxaction/SearchAction",
			{filename:inputsearch},
			function(data,status)
			{
				console.log(status);
				console.log(data);
				//调试代码
				//console.log(obj.jsonresult[0].filename + obj.jsonresult[0].filesize);
				//避免重复加载，每次加载数据前先清空
				$("#content").html("");
				/* 处理json数据并执行 */
				var obj = JSON.parse(data);
				//append注意：https://blog.csdn.net/qq_22771739/article/details/80554675
				//全部-电影块
				var str1 = '<div class="container-fluid">\n<div class="row-fluid">\n<div class="span12">\n';
				str1 += '<h2>搜索结果</h2><hr>' + '<table class="table table-hover table-bordered">\n' +
				'<thead>\n<tr class="">\n<th>文件名</th><th>文件大小</th><th>热度</th><th>操作</th></tr>\n</thead><tbody>\n';
				for(var i = 0;i<obj.jsonresult.length;i++)
				{
					str1 += '<tr>\n' + 
					'<td><a data-toggle="modal" data-target="#myModal" onclick="video_preview(this)">'
					+ obj.jsonresult[i].filename + '</a></td>' +
					'<td>'+ obj.jsonresult[i].filesize + "MB"+ '</td>' +
					'<td>'+ obj.jsonresult[i].goodnumber + '</td>' +
					'<td><div class="btn-group">' +
					'<button name="' +obj.jsonresult[i].filename + 
					'"' + ' class="btn btn-primary btn_manager" type="button" onclick="return video_download(this)">' 
					+ "下载" + '</button>' + 
					'<button name="' +obj.jsonresult[i].filenumber + 
					'"' + ' class="btn btn-primary btn_manager" type="button" onclick="return video_collect(this)">' +
					"收藏" + '</button>' +
					'<button name="' +obj.jsonresult[i].filenumber + 
					'"' + ' class="btn btn-primary btn_manager" type="button" onclick="return video_play(this)">' + 
					"播放" + '</button>' +  '</div></td>\n</tr>\n';
				}
				str1 += '</tbody></table></div></div></div>';
				$("#content").append(str1);
			});
}

/*点击列表里的视频名称，进行预览播放*/
function video_preview(data){
	//console.log("play" + data.innerHTML);
	var v = document.getElementById("video");
	$("#myModalLabel").html(data.name + "播放中...");
	//v.src="" + '${pageContext.request.contextPath}' +"/static/video/ServerVideo/"+data.name;
	//v.src="/static/video/ServerVideo/"+data.name;
	v.src="/Community/static/video/ServerVideo/傲世九重天.mp4";
	v.load();
	v.play();
}

/*function loadAdduser()
{
	$("#content").load("/Community/WEB-INF/page/AddUser.jsp");
}*/


function btn_adduser()
{
	console.log("添加用户");
	$.get("/Community/ajaxaction/AddUserAction", 
			{username:$("#username").val(),
			 useremail:$("#useremail").val(),
			 userpassword:$("#userpassword").val()},
			function (data, textStatus){
				 //测试输出回调数据
				//console.log(data);
				 show_alert(data);
				 //注册完之后显示登陆界面
				//$(".img_login").attr("src","img/login_white.svg");
				//$("#forge").load("Login.jsp");
		});
}

function show_alert(data)
{
	console.log(data);
	var obj = JSON.parse(data);
	//console.log(obj.result.msg);
	if(obj.result.result == "1")
	{
		alert("操作成功");
	}
	else
	{
		alert("操作失败");
	}
}