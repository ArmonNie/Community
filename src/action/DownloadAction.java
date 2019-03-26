package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.struts2.ServletActionContext;

import tool.AppTool;

public class DownLoadAction {
	
	private String filenumber;//根据filenumber进行文件定位
	
	private InputStream filestream;//使用流形式返回

	/*
	 * Getter and Setter
	 * 只提供一个setter（因为此action是一个ajax）
	 */
	/*public String getFilenumber() {
		return filenumber;
	}*/
	public void setFilenumber(String filenumber) {
		this.filenumber = filenumber;
	}
	
	
	/*
	 * 返回流类型提供下载入口
	 */
	public InputStream getFilestream() {
		return filestream;
	}

	 public String getDownFileName() {
		 String fileName = "moren";
		 try{
             //import java.net.URLEncoder;
             fileName = URLEncoder.encode("阿披实","UTF-8");
         }catch(Exception e){
             throw new RuntimeException();
         }
         
         return fileName;
	 }
	/*
	 * 逻辑控制
	 */
	public String execute() throws FileNotFoundException, UnsupportedEncodingException
	{
		String syspath = AppTool.getStrFromBase64(filenumber);
		File f = new File(syspath.substring(0, syspath.length()-1));
		 //得到视频目录路径
		//this.filestream = ServletActionContext.getServletContext().getResourceAsStream("/static/video/ServerVideo/" + f.getName());
		/*this.filestream = ServletActionContext.getServletContext().getResourceAsStream("/static/video/ServerVideo/" + f.getName());
		String webpath = ServletActionContext.getServletContext().getRealPath("/static/video/ServerVideo/" + f.getName());*/
		this.filestream = ServletActionContext.getServletContext().getResourceAsStream("/static/video/ServerVideo/傲世九重天.mp4");
		String webpath = ServletActionContext.getServletContext().getRealPath("/static/video/ServerVideo/傲世九重天.mp4");
		AppTool.ConsoleOut("即将下载文件：" + webpath);
		

		return "DownloadSuccess";
	}
	
}
