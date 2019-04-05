/**
 * 控制Main.jsp页面行为
 */
//初始加载所有视频
window.onload = all_video_click;

//图像加载出错时的处理 
function errorImg(img) { 
	img.src ="/Community/static/video/VideoImage/deleted.svg"; 
	img.onerror = null; 
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

/*下载按钮点击事件*/
function video_download(data)
{
	//console.log("下载");
	//此处不可以用ajax吗？？？
	/*$.get("/Community/action/DownLoadAction", 
			{filenumber:data.name},
			function (mstream, textStatus){
				console.log(textStatus);
				console.log("下载中..." + mstream);
			});*/
	window.open("/Community/action/DownLoadAction?filename=" + data.name);
}

/*收藏按钮点击事件*/
function video_collect(data)
{
	//console.log("收藏");
	$.get("/Community/ajaxaction/CollectAction", 
			{filenumber:data.name},
			function (mstream, textStatus){
				console.log(textStatus);
				console.log("收藏状态：" + mstream);
				if(JSON.parse(mstream).result == "ok")
				{
					alert("收藏成功，您可以在用户中心进行查看！");
				}	
			});
	//window.open("/Community/ajaxaction/CollectAction?filenumber=" + data.name);
}

/*播放按钮点击事件*/
function video_play(data)
{
	console.log("播放");
	//$.post("/Community/action/LinkAction",
		//	{index:"videodetail"});
	window.open("/Community/action/VideoPlayAction?filenumber=" + data.name);
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
				}
				str1 += '</tbody></table></div></div></div>';
				$("#content").append(str1);
		});
}
//ajax请求，请求所有电视列表
function tv_video_click(param) {
	console.log("当前页数：" + param);
	$("#content").html("");
	$.get("/Community/ajaxaction/LoadJsonAction", 
			{tag:"2",page:param},
			function (data, textStatus){
				//调试代码
				//console.log(obj.jsonresult[0].filename + obj.jsonresult[0].filesize);
				//加载前必须先清除
				$("#content").html("");
				/* 处理json数据并执行 */
				var obj = JSON.parse(data);
				//获取数据总量用于确定页数
				var totalNumber = obj.totalnumber;
				//var pageNumber = obj.totalnumber[0];
				console.log("总数量：" + totalNumber);
				console.log("总页数" + Math.ceil(totalNumber/12) );
				var totalPage = Math.ceil(totalNumber/12);
				//TV块
				var str_tv ='<h2>电视</h2><hr>';
				var counter_tv = 0;
				for(var i = 0;i < 1;i++)
				{
					for(var j = 0;j < 3;j++)
					{
						/*
						 * 问题记录：往thumnnail中放入按钮就乱是因为换行吗？？
						 */
						str_tv += '<div class="row">';
						str_tv += '<div class="col-md-3"><div class="thumbnail">' + 
						'<img  style="cursor:pointer" alt="300x200" onerror="errorImg(this)" onclick="return video_preview(this)" data-toggle="modal" data-target="#myModal" name="' + obj.jsonresult[counter_tv].filename + '"' + 'src="/Community/static/video/VideoImage/' + obj.jsonresult[counter_tv].filename + '.jpg"/>' + 
						'<div class="caption"><p><a onclick="return video_play(this)" name="' + obj.jsonresult[counter_tv].filenumber + '">' + obj.jsonresult[counter_tv].filename + '</a></p>' + 
						'<p><a class="btn btn-primary" onclick="return video_download(this)" name="' + obj.jsonresult[counter_tv].filename + '">下载</a><a class="btn btn-primary" onclick="return video_collect(this)" name="' + obj.jsonresult[counter_tv].filenumber + '">收藏</a></p>' +
						'</div>'+ 
						'</div></div>';
						counter_tv++;
						str_tv += '<div class="col-md-3"><div class="thumbnail">' + 
						'<img  style="cursor:pointer" alt="300x200" onerror="errorImg(this)" onclick="return video_preview(this)" data-toggle="modal" data-target="#myModal" name="' + obj.jsonresult[counter_tv].filename + '"' + 'src="/Community/static/video/VideoImage/' + obj.jsonresult[counter_tv].filename + '.jpg"/>' + 
						'<div class="caption"><p><a onclick="return video_play(this)" name="' + obj.jsonresult[counter_tv].filenumber + '">' + obj.jsonresult[counter_tv].filename + '</a></p>' + 
						'<p><a class="btn btn-primary" onclick="return video_download(this)" name="' + obj.jsonresult[counter_tv].filename + '">下载</a><a class="btn btn-primary" onclick="return video_collect(this)" name="' + obj.jsonresult[counter_tv].filenumber + '">收藏</a></p>' +
						'</div>'+ 
						'</div></div>';
						counter_tv++;
						str_tv += '<div class="col-md-3"><div class="thumbnail">' + 
						'<img  style="cursor:pointer" alt="300x200" onerror="errorImg(this)" onclick="return video_preview(this)" data-toggle="modal" data-target="#myModal" name="' + obj.jsonresult[counter_tv].filename + '"' + 'src="/Community/static/video/VideoImage/' + obj.jsonresult[counter_tv].filename + '.jpg"/>' + 
						'<div class="caption"><p><a onclick="return video_play(this)" name="' + obj.jsonresult[counter_tv].filenumber + '">' + obj.jsonresult[counter_tv].filename + '</a></p>' + 
						'<p><a class="btn btn-primary" onclick="return video_download(this)" name="' + obj.jsonresult[counter_tv].filename + '">下载</a><a class="btn btn-primary" onclick="return video_collect(this)" name="' + obj.jsonresult[counter_tv].filenumber + '">收藏</a></p>' +
						'</div>'+ 
						'</div></div>';
						counter_tv++;
						str_tv += '<div class="col-md-3"><div class="thumbnail">' + 
						'<img  style="cursor:pointer" alt="300x200" onerror="errorImg(this)" onclick="return video_preview(this)" data-toggle="modal" data-target="#myModal" name="' + obj.jsonresult[counter_tv].filename + '"' + 'src="/Community/static/video/VideoImage/' + obj.jsonresult[counter_tv].filename + '.jpg"/>' + 
						'<div class="caption"><p><a onclick="return video_play(this)" name="' + obj.jsonresult[counter_tv].filenumber + '">' + obj.jsonresult[counter_tv].filename + '</a></p>' + 
						'<p><a class="btn btn-primary" onclick="return video_download(this)" name="' + obj.jsonresult[counter_tv].filename + '">下载</a><a class="btn btn-primary" onclick="return video_collect(this)" name="' + obj.jsonresult[counter_tv].filenumber + '">收藏</a></p>' +
						'</div>'+ 
						'</div></div>';
						counter_tv++;
						str_tv += '</div>';
					}
				}
				str_tv +='<div class="row"><div class="col-md-3"></div><div  id="pageindex" class="col-md-6"></div><div class="col-md-3"></div></div>';
				str_tv +='<script src="/Community/static/basejs/jquery.pagination.js"></script>'
				str_tv +='<script type="text/javascript">'+
					'$("#pageindex").pagination({' +
					' pageCount:'+ totalPage + ',' +
				    'jump: true,' +
				    'coping: true,' +
				    'homePage: "首页",' +
				    'endPage: "末页",' +
				    'prevContent: "上页",' +
				    'nextContent: "下页",' +
				    'callback: function (api) { ' + 
				        'tv_video_click(api.getCurrent());' +
				    '}});' + '</script>'
				$("#content").html(str_tv);
		});
}
//ajax请求，请求所有电影列表
function movie_video_click(param) {
	console.log("当前页数：" + param);
	$("#content").html("");
	$.get("/Community/ajaxaction/LoadJsonAction", 
			{tag:"0",page:param},
			function (data, textStatus){
				//调试代码
				//console.log(obj.jsonresult[0].filename + obj.jsonresult[0].filesize);
				//加载前必须先清除
				$("#content").html("");
				/* 处理json数据并执行 */
				var obj = JSON.parse(data);
				//获取数据总量用于确定页数
				var totalNumber = obj.totalnumber;
				//var pageNumber = obj.totalnumber[0];
				console.log("总数量：" + totalNumber);
				console.log("总页数" + Math.ceil(totalNumber/12) );
				var totalPage = Math.ceil(totalNumber/12);
				//电影块
				var str_movie ='<h2>电影</h2><hr>';
				var counter_movie = 0;
				for(var i = 0;i < 1;i++)
				{
					for(var j = 0;j < 3;j++)
					{
						/*
						 * 问题记录：往thumnnail中放入按钮就乱是因为换行吗？？
						 */
						str_movie += '<div class="row clearfix">';
						str_movie += '<div class="col-md-3"><div class="thumbnail">' + 
						'<img  style="cursor:pointer" alt="300x200" onerror="errorImg(this)" onclick="return video_preview(this)" data-toggle="modal" data-target="#myModal" name="' + obj.jsonresult[counter_movie].filename + '"' + 'src="/Community/static/video/VideoImage/' + obj.jsonresult[counter_movie].filename + '.jpg"/>' + 
						'<div class="caption"><p><a onclick="return video_play(this)" name="' + obj.jsonresult[counter_movie].filenumber + '">' + obj.jsonresult[counter_movie].filename + '</a></p>' + 
						'<p><a class="btn btn-primary" onclick="return video_download(this)" name="' + obj.jsonresult[counter_movie].filename + '">下载</a><a class="btn btn-primary" onclick="return video_collect(this)" name="' + obj.jsonresult[counter_movie].filenumber + '">收藏</a></p>' +
						'</div>'+ 
						'</div></div>';
						counter_movie++;
						str_movie += '<div class="col-md-3"><div class="thumbnail">' + 
						'<img  style="cursor:pointer" alt="300x200" onerror="errorImg(this)" onclick="return video_preview(this)" data-toggle="modal" data-target="#myModal" name="' + obj.jsonresult[counter_movie].filename + '"' + 'src="/Community/static/video/VideoImage/' + obj.jsonresult[counter_movie].filename + '.jpg"/>' + 
						'<div class="caption"><p><a onclick="return video_play(this)" name="' + obj.jsonresult[counter_movie].filenumber + '">' + obj.jsonresult[counter_movie].filename + '</a></p>' + 
						'<p><a class="btn btn-primary" onclick="return video_download(this)" name="' + obj.jsonresult[counter_movie].filename + '">下载</a><a class="btn btn-primary" onclick="return video_collect(this)" name="' + obj.jsonresult[counter_movie].filenumber + '">收藏</a></p>' +
						'</div>'+ 
						'</div></div>';
						counter_movie++;
						str_movie += '<div class="col-md-3"><div class="thumbnail">' + 
						'<img  style="cursor:pointer" alt="300x200" onerror="errorImg(this)" onclick="return video_preview(this)" data-toggle="modal" data-target="#myModal" name="' + obj.jsonresult[counter_movie].filename + '"' + 'src="/Community/static/video/VideoImage/' + obj.jsonresult[counter_movie].filename + '.jpg"/>' + 
						'<div class="caption"><p><a onclick="return video_play(this)" name="' + obj.jsonresult[counter_movie].filenumber + '">' + obj.jsonresult[counter_movie].filename + '</a></p>' + 
						'<p><a class="btn btn-primary" onclick="return video_download(this)" name="' + obj.jsonresult[counter_movie].filename + '">下载</a><a class="btn btn-primary" onclick="return video_collect(this)" name="' + obj.jsonresult[counter_movie].filenumber + '">收藏</a></p>' +
						'</div>'+ 
						'</div></div>';
						counter_movie++;
						str_movie += '<div class="col-md-3"><div class="thumbnail">' + 
						'<img  style="cursor:pointer" alt="300x200" onerror="errorImg(this)" onclick="return video_preview(this)" data-toggle="modal" data-target="#myModal" name="' + obj.jsonresult[counter_movie].filename + '"' + 'src="/Community/static/video/VideoImage/' + obj.jsonresult[counter_movie].filename + '.jpg"/>' + 
						'<div class="caption"><p><a onclick="return video_play(this)" name="' + obj.jsonresult[counter_movie].filenumber + '">' + obj.jsonresult[counter_movie].filename + '</a></p>' + 
						'<p><a class="btn btn-primary" onclick="return video_download(this)" name="' + obj.jsonresult[counter_movie].filename + '">下载</a><a class="btn btn-primary" onclick="return video_collect(this)" name="' + obj.jsonresult[counter_movie].filenumber + '">收藏</a></p>' +
						'</div>'+ 
						'</div></div>';
						counter_movie++;
						str_movie += '</div>';
					}
				}
				str_movie +='<div class="row"><div class="col-md-3"></div><div  id="pageindex" class="col-md-6"></div><div class="col-md-3"></div></div>';
				str_movie +='<script src="/Community/static/basejs/jquery.pagination.js"></script>'
				str_movie +='<script type="text/javascript">'+
					'$("#pageindex").pagination({' +
					' pageCount:'+ totalPage + ',' +
				    'jump: true,' +
				    'coping: true,' +
				    'homePage: "首页",' +
				    'endPage: "末页",' +
				    'prevContent: "上页",' +
				    'nextContent: "下页",' +
				    'callback: function (api) { ' + 
				        'movie_video_click(api.getCurrent());' +
				    '}});' + '</script>'
				$("#content").html(str_movie);
		});
}
//ajax请求，请求所有CG列表
function cg_video_click(param) {
	console.log("当前页数：" + param);
	$("#content").html("");
	$.get("/Community/ajaxaction/LoadJsonAction", 
			{tag:"1",page:param},
			function (data, textStatus){
				//调试代码
				console.log("加载CG...e1");
				console.log(data);
				//console.log(obj.jsonresult[0].filename + obj.jsonresult[0].filesize);
				//加载前必须先清除
				$("#content").html("");
				/* 处理json数据并执行 */
				var obj = JSON.parse(data);
				console.log(obj);
				//获取数据总量用于确定页数
				var totalNumber = obj.totalnumber;
				//var pageNumber = obj.totalnumber[0];
				console.log("总数量：" + totalNumber);
				console.log("总页数" + Math.ceil(totalNumber/12) );
				var totalPage = Math.ceil(totalNumber/12);
				//TV块
				var str_cg ='<h2>CG动漫</h2><hr>';
				var counter_cg = 0;
				for(var i = 0;i < 1;i++)
				{
					for(var j = 0;j < 3;j++)
					{
						/*
						 * 问题记录：往thumnnail中放入按钮就乱是因为换行吗？？
						 */
						str_cg += '<div class="row">';
						str_cg += '<div class="col-md-3"><div class="thumbnail">' + 
						'<img  style="cursor:pointer" alt="300x200" onerror="errorImg(this)" onclick="return video_preview(this)" data-toggle="modal" data-target="#myModal" name="' + obj.jsonresult[counter_cg].filename + '"' + 'src="/Community/static/video/VideoImage/' + obj.jsonresult[counter_cg].filename + '.jpg"/>' + 
						'<div class="caption"><p><a onclick="return video_play(this)" name="' + obj.jsonresult[counter_cg].filenumber + '">' + obj.jsonresult[counter_cg].filename + '</a></p>' + 
						'<p><a class="btn btn-primary" onclick="return video_download(this)" name="' + obj.jsonresult[counter_cg].filename + '">下载</a><a class="btn btn-primary" onclick="return video_collect(this)" name="' + obj.jsonresult[counter_cg].filenumber + '">收藏</a></p>' +
						'</div>'+ 
						'</div></div>';
						counter_cg++;
						str_cg += '<div class="col-md-3"><div class="thumbnail">' + 
						'<img  style="cursor:pointer" alt="300x200" onerror="errorImg(this)" onclick="return video_preview(this)" data-toggle="modal" data-target="#myModal" name="' + obj.jsonresult[counter_cg].filename + '"' + 'src="/Community/static/video/VideoImage/' + obj.jsonresult[counter_cg].filename + '.jpg"/>' + 
						'<div class="caption"><p><a onclick="return video_play(this)" name="' + obj.jsonresult[counter_cg].filenumber + '">' + obj.jsonresult[counter_cg].filename + '</a></p>' + 
						'<p><a class="btn btn-primary" onclick="return video_download(this)" name="' + obj.jsonresult[counter_cg].filename + '">下载</a><a class="btn btn-primary" onclick="return video_collect(this)" name="' + obj.jsonresult[counter_cg].filenumber + '">收藏</a></p>' +
						'</div>'+ 
						'</div></div>';
						counter_cg++;
						str_cg += '<div class="col-md-3"><div class="thumbnail">' + 
						'<img  style="cursor:pointer" alt="300x200" onerror="errorImg(this)" onclick="return video_preview(this)" data-toggle="modal" data-target="#myModal" name="' + obj.jsonresult[counter_cg].filename + '"' + 'src="/Community/static/video/VideoImage/' + obj.jsonresult[counter_cg].filename + '.jpg"/>' + 
						'<div class="caption"><p><a onclick="return video_play(this)" name="' + obj.jsonresult[counter_cg].filenumber + '">' + obj.jsonresult[counter_cg].filename + '</a></p>' + 
						'<p><a class="btn btn-primary" onclick="return video_download(this)" name="' + obj.jsonresult[counter_cg].filename + '">下载</a><a class="btn btn-primary" onclick="return video_collect(this)" name="' + obj.jsonresult[counter_cg].filenumber + '">收藏</a></p>' +
						'</div>'+ 
						'</div></div>';
						counter_cg++;
						str_cg += '<div class="col-md-3"><div class="thumbnail">' + 
						'<img  style="cursor:pointer" alt="300x200" onerror="errorImg(this)" onclick="return video_preview(this)" data-toggle="modal" data-target="#myModal" name="' + obj.jsonresult[counter_cg].filename + '"' + 'src="/Community/static/video/VideoImage/' + obj.jsonresult[counter_cg].filename + '.jpg"/>' + 
						'<div class="caption"><p><a onclick="return video_play(this)" name="' + obj.jsonresult[counter_cg].filenumber + '">' + obj.jsonresult[counter_cg].filename + '</a></p>' + 
						'<p><a class="btn btn-primary" onclick="return video_download(this)" name="' + obj.jsonresult[counter_cg].filename + '">下载</a><a class="btn btn-primary" onclick="return video_collect(this)" name="' + obj.jsonresult[counter_cg].filenumber + '">收藏</a></p>' +
						'</div>'+ 
						'</div></div>';
						counter_cg++;
						str_cg += '</div>';
					}
					
				}
				//页面总数问题：暂时型写死
				str_cg +='<div class="row"><div class="col-md-3"></div><div  id="pageindex" class="col-md-6"></div><div class="col-md-3"></div></div>';
				str_cg +='<script src="/Community/static/basejs/jquery.pagination.js"></script>'
				str_cg +='<script type="text/javascript">'+
					'$("#pageindex").pagination({' +
				    ' pageCount:'+ totalPage + ',' +
				    'jump: true,' +
				    'coping: true,' +
				    'homePage: "首页",' +
				    'endPage: "末页",' +
				    'prevContent: "上页",' +
				    'nextContent: "下页",' +
				    'callback: function (api) { ' + 
				        'cg_video_click(api.getCurrent());' +
				    '}});' + '</script>'
				$("#content").html(str_cg);
				
		});
}
