<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" 
    import="java.io.File,
	java.util.ArrayList,
	java.util.List,
	tool.MyFileTool"%>
	<!-- 所有影视剧页面 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>视频</title>
	</head>
	<body>
	<%     
	MyFileTool mft = new MyFileTool();
	List<File> lf = mft.getFileList(); 
	%>
	<div class='row col-md-10 col-md-offset-1'>

	</div>
	<div class='row col-md-10 col-md-offset-1'>
		<div class='table-responsive'>		

		<% 
		for(File file_item : lf)
		{
		%>
		<div class="col-md-12 margin_top">
			<div class="col-md-6"><a name="<%= file_item.getName()%>" data-toggle="modal" data-target="#myModal" onclick="video_play(this)"><%= file_item.getName()%></a></div>
			<div class="col-md-2"><%=(file_item.length()/(1024*1024) + "MB")%></div>
			<div class="col-md-2"><a name="<%= file_item.getName()%>" onclick="set_collection(this)">收藏</a></div>
			<div class="col-md-2"><a name="<%= file_item.getName()%>" onclick="download(this)">下载</a></div>
		</div>
		<%
			}
		%>
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    		<div class="modal-dialog">
       			 <div class="modal-content">
            		<div class="modal-header">       
               			 <h4 class="modal-title" id="myModalLabel">…</h4>
            		</div>
            		<div class="modal-body text-center">
            			<video class="video_size" id="video" controls="controls">
            				<source src="" type="audio/mp4"></source>
            			</video>      
            		</div>
            		<div class="modal-footer">
                
            		</div>
        		</div>
    		</div>
		</div>
	</div>
</div>
</body>
</html>