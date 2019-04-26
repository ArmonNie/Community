package action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import tool.AppTool;
import tool.MyFileTool;
import tool.ORMTool;

public class UploadAction {
	
	private String filenumber;//File表file编号
	private String filename;//File表file名字
	private String filepath;//File表file路径
	private int filesize;//File表file大小
	private int goodnumber;//File表file点赞数
	private String filedescription;//文件描述
	private String filetype;//文件类型（movie，cg，tv）
	private String filetag;//文件标签（综艺，娱乐，戏剧，玄幻）
	
	private File file;
	
	/*
	 * Getter与Setter
	 */
	public String getFilenumber() {
		return filenumber;
	}
	public void setFilenumber(String filenumber) {
		this.filenumber = filenumber;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public int getFilesize() {
		return filesize;
	}
	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}
	public int getGoodnumber() {
		return goodnumber;
	}
	public void setGoodnumber(int goodnumber) {
		this.goodnumber = goodnumber;
	}
	public String getFiledescription() {
		return filedescription;
	}
	public void setFiledescription(String filedescription) {
		this.filedescription = filedescription;
	}
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	public String getFiletag() {
		return filetag;
	}
	public void setFiletag(String filetag) {
		this.filetag = filetag;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	
	
	
	public String execute() throws IOException
	{
		
		String webpath = ServletActionContext.getServletContext().getRealPath("/static/video/ServerVideo");
		/*
		 * 上传逻辑代码，上传完成转到用户中心
		 * 同时记录进入数据库
		 */
		AppTool.ConsoleOut("上传路径" + webpath);
		AppTool.ConsoleOut("即将上传" + file.getName());
		AppTool.ConsoleOut("前台数据" + this.filedescription + this.filename
				+ this.filepath + this.filesize);
		/*
		 * 插入数据库
		 */
		ORMTool ormtool = new ORMTool("file");
		
		bean.File  bf = new bean.File();
		bf.setFilename(filename);
		bf.setFilepath(filepath);
		bf.setFilesize(filesize);
		bf.setFiledescription(filedescription);
		bf.setFilenumber(AppTool.getBase64FromStr(this.filepath));
		bf.setFiletype("0");
		bf.setGoodnumber(0);
		
		ormtool.insert(bf);
		
		ORMTool ormtool2 = new ORMTool("userupload");
		bean.UserUpload usup = new bean.UserUpload();
		String usernumber = ServletActionContext
				.getRequest().getSession()
				.getAttribute("usernumber").toString();
		usup.setFilenumber(AppTool.getBase64FromStr(this.filepath));
		usup.setUploadnumber(AppTool.getBase64FromStr(AppTool.getDateStr() + this.filepath));
		usup.setUsernumber(usernumber);
		ormtool2.insert(usup);
		/*
		 * 关于上传的文件名以及各式的问腿
		 */
		File destFile = new File(webpath + "/" + filename);
		AppTool.ConsoleOut("目标文件名为：" + destFile.getName());
		AppTool.ConsoleOut("目标文件路径为：" + destFile.getAbsolutePath());
		//FileUtils.copyFile(file, destFile);
		MyFileTool.copyFile(this.file, destFile);
		return "usercenter";
	}
	

}
