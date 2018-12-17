<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分享</title>
</head>
<body>
<form role="form" action="UploadServlet" method="post" enctype="multipart/form-data">
<div class="form-group">
<label for="resource_name">名称</label>
<input type="text" name="resource_name" class="form-control text_area_transparency" id="resource_name" placeholder="请输入名称">
</div>
<div class="form-group">
<label for="inputfile">请上传视频或音频文件</label>
<input type="file" id="inputfile" name="filename">
</div>
<div class="form-group">
<label for="resource_describe">描述</label>
<textarea class="form-control text_area_transparency" name="resource_describe" rows="4" id="resource_describe"></textarea></div>
<div class="form-group">
<button type="submit" name="upload" class="btn btn-success">分享</button>
</div>
</form>
</body>
</html>