package ajaxaction;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.json.annotations.JSON;
import org.apache.struts2.util.ServletContextAware;
import org.json.JSONArray;

import tool.AppTool;
import tool.MyFileTool;

public class LoadAction implements ServletContextAware{
	
	private String tag;
	private InputStream inputStream;
	private ServletContext servletContext;
	private List<File> filelist = new ArrayList<File>();
	private Map<String,String> filemap = new HashMap<String,String>();
	private JSONArray filejsonarray = new JSONArray();
	
	public InputStream getResult()
	{
		return inputStream;
	}
	/*public void setFileList(List<File> filelist) {
		this.filelist = filelist;
	}*/
	//@JSON(name="filemsg")
	/*public List<File> getFileList()
	{
		return filelist;
	}*/
	@JSON(name="filearray")
	public JSONArray getFilejsonarray() {
		return filejsonarray;
	}
	@JSON(name="newName")
	public Map<String,String> getFileMap()
	{
		return filemap;
	}
	
	
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}


	
	@Override
	public void setServletContext(ServletContext arg0) {
		// TODO Auto-generated method stub
		this.servletContext = arg0;
	}


	public String execute()
	{
		AppTool.ConsoleOut("LoadAction");
		AppTool.ConsoleOut("前台传入的标签：" + this.tag);
		AppTool.ConsoleOut(servletContext.getRealPath("/"));
		
		/*
		 * 尝试一
		 */
		//String path = LoadAction.class.getResource(name)
		//String data = "OK";
		//ByteArrayInputStream dataStream = new ByteArrayInputStream(data.getBytes());
		//inputStream = dataStream;
		
		/*
		 * 尝试二
		 */
		/*try {
			inputStream = AppTool.getAppFileInputStream(servletContext.getRealPath("/"), "Video.jsp");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			String data = "出错了";
			ByteArrayInputStream dataStream = new ByteArrayInputStream(data.getBytes());
			inputStream = dataStream; 
			e.printStackTrace();
		}
		return "LoadSuccess";*/
		
		/*
		 * 尝试三
		 */
		MyFileTool mft = new MyFileTool();
		List<File> lf = mft.getFileList(); 
		System.out.println(lf.size());//大小为0
		/*for(File file : lf)
		{
			System.out.println("1");
			MyFileTool.getFileMsg(file);
		}*/
		this.filejsonarray = AppTool.FileList2Json(lf);
		AppTool.ConsoleOut("jsonlen聂璋" + this.filejsonarray.length());
		//File f = new File("C:\\Users\\Armon\\eclipse-workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp2\\wtpwebapps\\Community\\WEB-INF\\page\\Video.jsp");
		//lf.add(f);
		this.filelist = lf;
		filemap.put("1", "数据1");
		
		return "LoadAjax";
	
	}

}
