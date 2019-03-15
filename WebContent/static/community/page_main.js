/**
 * 控制Main.jsp页面行为
 */
//初始加载所有视频
window.onload = all_video_click;


/*点击列表里的视频名称，进行预览播放*/
function video_preview(data){
	//console.log("play" + data.innerHTML);
	var v = document.getElementById("video");
	$("#myModalLabel").html(data.innerHTML + "播放中...");
	//v.src="" + '${pageContext.request.contextPath}' +"/static/video/ServerVideo/"+data.name;
	//v.src="/static/video/ServerVideo/"+data.name;
	v.src="/Community/static/video/ServerVideo/"+data.innerHTML;
	v.load();
	v.play();
}

/*下载按钮点击事件*/
function video_download(data)
{
	console.log("下载");
	$.get("/Community/action/DownLoadAction", 
			{filenumber:data.name},
			function (mstream, textStatus){
				console.log("下载中..." + mstream);
			});
}

/*详情按钮点击事件*/
function video_detail(data)
{
	console.log("详情");
	//$.post("/Community/action/LinkAction",
		//	{index:"videodetail"});
	window.open("/Community/action/LinkAction?index=videodetail");
}

/*播放按钮点击事件*/
function video_play(data)
{
	console.log("播放");
	//$.post("/Community/action/LinkAction",
		//	{index:"videodetail"});
	window.open("/Community/action/LinkAction?index=videoplay");
}



//ajax请求，请求所有视频列表
function all_video_click() {
	$.get("/Community/ajaxaction/LoadJsonAction", 
			{tag:"all"},
			function (data, textStatus){
				//调试代码
				//console.log(obj.jsonresult[0].filename + obj.jsonresult[0].filesize);
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
					'<button name="' +obj.jsonresult[i].filenumber + 
					'"' + ' class="btn btn-primary btn_manager" type="button" onclick="return video_download(this)">' 
					+ "下载" + '</button>' + 
					'<button name="' +obj.jsonresult[i].filenumber + 
					'"' + ' class="btn btn-primary btn_manager" type="button" onclick="return video_detail(this)">' +
					"详情" + '</button>' +
					'<button name="' +obj.jsonresult[i].filenumber + 
					'"' + ' class="btn btn-primary btn_manager" type="button" onclick="return video_play(this)">' + 
					"播放" + '</button>' +  '</div></td>\n</tr>\n';
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
						'<button name="' +obj.jsonresult[i].filenumber + 
						'"' + ' class="btn btn-primary btn_manager" type="button" onclick="return video_download(this)">' 
						+ "下载" + '</button>' + 
						'<button name="' +obj.jsonresult[i].filenumber + 
						'"' + ' class="btn btn-primary btn_manager" type="button" onclick="return video_detail(this)">' +
						"详情" + '</button>' +
						'<button name="' +obj.jsonresult[i].filenumber + 
						'"' + ' class="btn btn-primary btn_manager" type="button" onclick="return video_play(this)">' + 
						"播放" + '</button>' +  '</div></td>\n</tr>\n';
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
						'<button name="' +obj.jsonresult[i].filenumber + 
						'"' + ' class="btn btn-primary btn_manager" type="button" onclick="return video_download(this)">' 
						+ "下载" + '</button>' + 
						'<button name="' +obj.jsonresult[i].filenumber + 
						'"' + ' class="btn btn-primary btn_manager" type="button" onclick="return video_detail(this)">' +
						"详情" + '</button>' +
						'<button name="' +obj.jsonresult[i].filenumber + 
						'"' + ' class="btn btn-primary btn_manager" type="button" onclick="return video_play(this)">' + 
						"播放" + '</button>' +  '</div></td>\n</tr>\n';
					}
				}
				str1 += '</tbody></table></div></div></div>';
				$("#content").append(str1);
		});
}
//ajax请求，请求所有电视列表
function tv_video_click() {
	$.get("/Community/ajaxaction/LoadJsonAction", 
			{tag:"2"},
			function (data, textStatus){
				//调试代码
				//console.log(obj.jsonresult[0].filename + obj.jsonresult[0].filesize);
				//加载前必须先清除
				$("#content").html("");
				/* 处理json数据并执行 */
				var obj = JSON.parse(data);
				//TV块
				var str1 = '<div class="container-fluid"><div class="row-fluid"><div class="span12">' +
						'<h2>CG动漫</h2><hr>' + '<table class="table table-hover table-bordered">\n' +
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
						'<button name="' +obj.jsonresult[i].filenumber + 
						'"' + ' class="btn btn-primary btn_manager" type="button" onclick="return video_download(this)">' 
						+ "下载" + '</button>' + 
						'<button name="' +obj.jsonresult[i].filenumber + 
						'"' + ' class="btn btn-primary btn_manager" type="button" onclick="return video_detail(this)">' +
						"详情" + '</button>' +
						'<button name="' +obj.jsonresult[i].filenumber + 
						'"' + ' class="btn btn-primary btn_manager" type="button" onclick="return video_play(this)">' + 
						"播放" + '</button>' +  '</div></td>\n</tr>\n';
					}
				}
				str1 += '</tbody></table></div></div></div>';
				$("#content").append(str1);
		});
}
//ajax请求，请求所有电影列表
function movie_video_click() {
	$.get("/Community/ajaxaction/LoadJsonAction", 
			{tag:"0"},
			function (data, textStatus){
				//调试代码
				//console.log(obj.jsonresult[0].filename + obj.jsonresult[0].filesize);
				//加载前必须先清除
				$("#content").html("");
				/* 处理json数据并执行 */
				var obj = JSON.parse(data);
				//电影块
				var str1 = '<div class="container-fluid"><div class="row-fluid"><div class="span12">' +
						'<h2>电影</h2><hr>' + '<table class="table table-hover table-bordered">\n' +
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
						'<button name="' +obj.jsonresult[i].filenumber + 
						'"' + ' class="btn btn-primary btn_manager" type="button" onclick="return video_download(this)">' 
						+ "下载" + '</button>' + 
						'<button name="' +obj.jsonresult[i].filenumber + 
						'"' + ' class="btn btn-primary btn_manager" type="button" onclick="return video_detail(this)">' +
						"详情" + '</button>' +
						'<button name="' +obj.jsonresult[i].filenumber + 
						'"' + ' class="btn btn-primary btn_manager" type="button" onclick="return video_play(this)">' + 
						"播放" + '</button>' +  '</div></td>\n</tr>\n';
					}
				}
				str1 += '</tbody></table></div></div></div>';
				$("#content").append(str1);
		});
}
//ajax请求，请求所有CG列表
function cg_video_click() {
	$("#content").html("");
	$.get("/Community/ajaxaction/LoadJsonAction", 
			{tag:"1"},
			function (data, textStatus){
				//调试代码
				//console.log(obj.jsonresult[0].filename + obj.jsonresult[0].filesize);
				//加载前必须先清除
				$("#content").html("");
				/* 处理json数据并执行 */
				var obj = JSON.parse(data);
				//TV块
				var str1 = '<div class="container-fluid"><div class="row-fluid"><div class="span12">' +
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
						'<button name="' +obj.jsonresult[i].filenumber + 
						'"' + ' class="btn btn-primary btn_manager" type="button" onclick="return video_download(this)">' 
						+ "下载" + '</button>' + 
						'<button name="' +obj.jsonresult[i].filenumber + 
						'"' + ' class="btn btn-primary btn_manager" type="button" onclick="return video_detail(this)">' +
						"详情" + '</button>' +
						'<button name="' +obj.jsonresult[i].filenumber + 
						'"' + ' class="btn btn-primary btn_manager" type="button" onclick="return video_play(this)">' + 
						"播放" + '</button>' +  '</div></td>\n</tr>\n';
					}
				}
				str1 += '</tbody></table></div></div></div>';
				$("#content").append(str1);
		});
}
