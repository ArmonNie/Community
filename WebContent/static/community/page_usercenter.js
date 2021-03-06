/**
 * 用户中心界面（收藏列表，历史记录）
 */
/*window.onload = sendMessage;

//关于通信
function sendMessage()
{
	console.log("发送信息");
	//CazyIt要改成你自己当前的项目名
	var url = "ws://"+document.location.host+"/Community/websocket/chat"; 
	//创建WebSocket对象
	var webSocket = new WebSocket(url);
	var sendMsg = function(){
	    console.log("11111111111111");
	    var inputElement = document.getElementById('msg');
	    //发送消息
	    webSocket.send(inputElement.value);
	    //清空单行文本框
	    inputElement.value="";
	}
	var send = function(event){
	    if(event.keyCode==13){
	        sendMsg();
	    }
	};
	webSocket.onopen=function(){
	    console.log("22222222222222");
	    //为onmessage事件绑定监听器，接收消息
	    webSocket.onmessage = function(event){
	        console.log("33333333333333");
	        var show = document.getElementById('show');
	        //接收并显示消息
	        show.innerHTML +=event.data+"<br/>";
	        show.scrollTop = show.scrollHeight;
	    }
	    document.getElementById('msg').onkeydown = send;
	    document.getElementById('sendBn').onclick = sendMsg;
	};
	webSocket.onclose = function(){
	    console.log("4444444444444444444");
	    document.getElementById('msg').onkeydown = null;
	    document.getElementById('sendBn').onclick = null;
	    console.log('WebSocket已经被关闭。');
	};
}*/

/*播放按钮点击事件*/
function video_play(data)
{
	console.log("播放");
	//$.post("/Community/action/LinkAction",
		//	{index:"videodetail"});
	window.open("/Community/action/VideoPlayAction?filenumber=" + data.name);
}

//根据usernumber获取播放记录
//用户中心的首页展示历史纪录
$(document).ready(function() {
	var data = document.getElementById("usercenter-list1");
	//$("#usercenter-list1");
	getMyHistory(data);
	//createCode();
});

//获取历史记录（待添加一些样式）
function getMyHistory(data)
{
	console.log("历史记录");
	$.get("/Community/ajaxaction/GetHistoryAction",
			{usernumber:data.name},
			function(data,status){
				//测试
				console.log(data);
				//先清空内容
				$("#usercenter_content").html("");
				/* 处理json数据并执行 */
				var obj = JSON.parse(data);
				//拼接字符串
				var str = "";
				//遍历obj,例如obj.jsonresult[i].filetype
				var counter = 0;
				if(obj.jsonresult.length == 0)
				{
					str += '<div class="panel panel-success text_area_transparency bg-warning">' +
					'<div class="panel-heading"></div>' + 
					'<div class="panel-body"><h3>您还未观看过视频哟~~</h3></div>' + 
					'<div class="panel-footer"></div></div>';
				}
				for(var i = 0;i<obj.jsonresult.length;i++)
				{
					if(counter < 3)
					{
					str += '<div class="panel panel-success text_area_transparency bg-warning">' +
						'<div class="panel-heading"><p class="font_title">于'+ obj.jsonresult[i].historydate +'观看<a class="font_title">'+
						obj.jsonresult[i].filename + '</a></p></div>' + 
						'<div class="panel-body">视频简介:' + obj.jsonresult[i].filedescription + '</div>' + 
						'<div class="panel-footer"><button name="' + obj.jsonresult[i].filenumber + '"'+ 'class="btn-success btn-xs" onclick="return video_play(this)">再次观影</button></div></div>';
					}
					counter++;
				}
				$("#usercenter_content").append(str);
			});
}

//获取我的收藏记录
function getMyCollection(data)
{
	console.log("收藏记录");
	$.get("/Community/ajaxaction/GetCollectionAction",
			{usernumber:data.name},
			function(data,status){
				//测试
				console.log(data);
				//先清空内容
				$("#usercenter_content").html("");
				/* 处理json数据并执行 */
				var obj = JSON.parse(data);
				//拼接字符串
				var str = "";
				str += '<div class="panel panel-default">' +
				'<div class="panel-heading"><h3 class="panel-title">' +
				'我的小宝藏' + '</h3></div>' + '<div class="panel-body"><ol>';
				//遍历obj,例如obj.jsonresult[i].filetype
				if(obj.jsonresult.length == 0)
				{
					str += '<h3>空空的宝库<h3>';
				}
				for(var i = 0;i<obj.jsonresult.length;i++)
				{
					str += '<li><a name="' + obj.jsonresult[i].filenumber + '"'+ 'onclick="return video_play(this)">' + obj.jsonresult[i].filename + '</a></li>';
				}
				str += '</ol></div></div>';
				$("#usercenter_content").append(str);
			});
}
//获取上传记录
function getMyUpload(data)
{
	console.log("上传记录");
	$.get("/Community/ajaxaction/GetUploadAction",
			{usernumber:data.name},
			function(data,status){
				//测试
				console.log(data);
				//先清空内容
				$("#usercenter_content").html("");
				/* 处理json数据并执行 */
				var obj = JSON.parse(data);
				//拼接字符串
				var str = "";
				str += '<div class="panel panel-default">' +
				'<div class="panel-heading"><h3 class="panel-title">' +
				'我的贡献' + '</h3></div>' + '<div class="panel-body"><ol>';
				//遍历obj,例如obj.jsonresult[i].filetype
				if(obj.jsonresult.length == 0)
				{
					str += '<h3>您还没有上传过任何视频哟！<h3>';
				}
				for(var i = 0;i<obj.jsonresult.length;i++)
				{
					str += '<li><a name="' + obj.jsonresult[i].filenumber + '"'+ 'onclick="return video_play(this)">' + obj.jsonresult[i].filename + '</a></li>';
				}
				str += '</ol></div></div>';
				$("#usercenter_content").append(str);
			});
}

