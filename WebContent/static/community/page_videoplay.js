/**
 * 
 */
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
			});
}

//加载视频评论
function load_comment()
{
	$.get("/Community/ajaxaction/CommentAction",
			{filenumber:filenumber,usernumber:usernumber,comment:usercomment},
			function(date,status){
				console.log(status);
			});
}
