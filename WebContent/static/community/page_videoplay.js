/**
 * 
 */
window.onload = load_comment;

$(document).ready(function() {
	load_comment();
	//createCode();
});

//提交评论
function btn_comment(data)
{
	var filenumber = data.name;
	var usernumber = document.getElementById("img_user").attributes["name"].value;
	var usercomment = $("#usercomment").val();
	
	console.log("filenumber" + filenumber);
	console.log("usernumber" + usernumber);
	console.log("usercomment" + usercomment);
	
	$.get("/Community/ajaxaction/CommentAction",
			{filenumber:filenumber,usernumber:usernumber,comment:usercomment},
			function(date,status){
				console.log(status);
				load_comment();
			});
}

//加载视频评论
function load_comment()
{
	console.log("评论加载");
	
	var filenumber = document.getElementById("btn-comment").attributes["name"].value;
	$("#videoconment").html("");
	
	console.log("filenumber" + filenumber);
	
	$.get("/Community/ajaxaction/GetCommentAction",
			{filenumber:filenumber},
			function(date,status){
				console.log(date);
				var obj = JSON.parse(date);
				console.log("obj" + obj.jsonresult.length);
				var str = "";
				for(var i = 0;i<obj.jsonresult.length;i++)
				{
					str += '<div class="col-md-12 column"><div class="media">' + 
					'<a href="" class="pull-left">' + 
					'<img height="64" width="64" alt="140x140" src="/Community/static/img/userdefault.png" class="media-object" alt=""/>' +
					'</a>' + '<div class="media-body" style="vertical-allign:center"><h4 class="media-heading">' + obj.jsonresult[i].username + '说：' +
					'</h4>' + '' + obj.jsonresult[i].usercomment + 
					'</div></div></div>';
				}
				console.log("拼接" + str);
				$("#videoconment").append(str);
			});
}
