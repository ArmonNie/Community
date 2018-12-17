package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.bean.UserBean;
import com.datebase.DateBase;
import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private ServletConfig servletConfig;  
     
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.servletConfig = config;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//实例化	
		String  user_name=(String)request.getSession().getAttribute("user_name");
		SmartUpload su = new SmartUpload();
		//初始化
		try{
			su.initialize(servletConfig,request, response);
		}catch(ServletException e){
			e.printStackTrace();
		}
		//上传限制
		su.setAllowedFilesList("avi,wmv,mp4,mp3");
		su.setMaxFileSize(2*1024*1024*1024);
		su.setTotalMaxFileSize(4*1024*1024*1024);
		//上传
		try {
			su.upload();
		} catch (ServletException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}catch (SmartUploadException e) {
			e.printStackTrace();
		}
		//文件保存
		Date curDate = new Date();
		long d = curDate.getTime();//long型
		//创建request对象
		//Request req =su.getRequest();
		//获取上传文件/全部上传文件
		Files files = su.getFiles();
		//获取指定位置的文件
		File file = files.getFile(0);
		//获取扩展名
		String extFile =file.getFileExt();
		String mainFile = String.valueOf(d);
		//文件上传到服务器的uploud目录下，文件已当前时间命名
		String filename = "/resource/"+mainFile+"."+extFile;
		try {
			file.saveAs(filename);
		} catch (IOException e) {
			e.printStackTrace();
		}catch (SmartUploadException e) {
			e.printStackTrace();
		}
		  String resource_name= su.getRequest().getParameter("resource_name");
		  String resource_describe = su.getRequest().getParameter("resource_describe");
		  String sql = "INSERT INTO resource(Resource_id,Resource_name,Resource_describe,Resource_path,User_name)VALUES(?,?,?,?,?)";
		  
		  int result = 0;
			 try{
				 PreparedStatement preparedStatement = DateBase.excutePreparedStatement(sql);
				 preparedStatement.setString(1, mainFile);
				 preparedStatement.setString(2, resource_name);
				 preparedStatement.setString(3, resource_describe);
				 preparedStatement.setString(4, filename);
				 preparedStatement.setString(5, user_name);
				 result =preparedStatement.executeUpdate();
				 preparedStatement.close();
				 	 }catch (SQLException e) {
						e.printStackTrace();
					}
			 PrintWriter out = response.getWriter();
			 if(result>0){
				 out.println("");
				 response.sendRedirect("Content.jsp");
			 }else{
				 out.println("资源数据更新失败");
			 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
