/**
 * 上传页面行为
 */
function filemsg_console()
{
	console.log($("#inputfile").val());
	console.log($("#inputfile").file.name);
	console.log($("#inputfile").file.size);
}


function btn_upload()
{
	console.log("文件信息");
	console.log($("#inputfile").val());
	console.log($("#inputfile").files[0].name);
	console.log($("#inputfile").files[0].size);
}
