/**
 * 
 */
window.onload = load_comment;

//提交评论
function btn_comment(data)
{
	var filenumber = data.name;
	var usernumber = document.getElementById("usertag").attributes["name"].value;
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
	
	var usernumber = document.getElementById("usertag").attributes["name"].value;
	$("#videoconment").html("");
	
	$.get("/Community/ajaxaction/GetCommentAction",
			{usernumber:usernumber},
			function(date,status){
				console.log(date);
				var obj = JSON.parse(date);
				console.log("obj" + obj.jsonresult.length);
				var str = "";
				for(var i = 0;i<obj.jsonresult.length;i++)
				{
					str += '<div class="col-md-12 column"><div class="media">' + 
					'<a href="" class="pull-left">' + 
					'<img height="128" width="128" alt="140x140" src="/Community/static/img/userdefault.png" class="media-object" alt=""/>' +
					'</a>' + '<div class="media-body"><h4 class="media-heading">' + obj.jsonresult[i].username +
					'</h4>' + ':' + obj.jsonresult[i].usercomment + 
					'</div></div></div>';
				}
				console.log("拼接" + str);
				$("#videoconment").append(str);
			});
}
