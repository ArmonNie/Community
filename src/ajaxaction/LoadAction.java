package ajaxaction;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;

import tool.AppTool;

public class LoadAction implements ServletContextAware{
	
	private String tag;
	private InputStream inputStream;
	private ServletContext servletContext;
	
	public InputStream getResult()
	{
		return inputStream;
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
		AppTool.ConsoleOut(servletContext.getRealPath("/"));
		//String path = LoadAction.class.getResource(name)
		//String data = "OK";
		//ByteArrayInputStream dataStream = new ByteArrayInputStream(data.getBytes());
		//inputStream = dataStream; 
		try {
			inputStream = AppTool.getAppFileInputStream(servletContext.getRealPath("/"), "Video.jsp");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			String data = "出错了";
			ByteArrayInputStream dataStream = new ByteArrayInputStream(data.getBytes());
			inputStream = dataStream; 
			e.printStackTrace();
		}
		return "LoadSuccess";
	}

}
