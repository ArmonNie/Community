/**
 * 用户中心界面（收藏列表，历史记录）
 */
window.onload = sendMessage;

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
}