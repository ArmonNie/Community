/**
 * 上传页面行为
 */
function filemsg_console()
{
	console.log("文件信息：");
	//var f = $("#file").files;//获取为undefined
	var f = document.getElementById("file").files; 
	console.log("对象为：" + f);
	console.log("文件名：" + f[0].name);
	console.log("文件大小：" + f[0].size);
	console.log("文件类型：" + f[0].type);
	console.log("文件路径：" + f[0].webkitRelativePath);
	$("#filename").attr('value', f[0].name);
	$("#filesize").attr('value', f[0].size);
	$("#filetype").attr('value', f[0].type);
	$("#filepath").attr('value', 'C:/Server/test.mp4');
	//console.log($("#inputfile").val());
	//console.log($("#inputfile").file.name);
	//console.log($("#inputfile").file.size);
}


function btn_upload()
{
	console.log("文件上传");
	//console.log($("#inputfile")[0].files);
	//console.log($("#inputfile").val());
	//console.log($("#inputfile").files[0].name);
	//console.log($("#inputfile").files[0].size);
	$("#fileform").submit();
}
