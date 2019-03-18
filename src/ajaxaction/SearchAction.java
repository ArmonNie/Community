package ajaxaction;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import bean.File;
import tool.ORMTool;

public class SearchAction {
	
	private String filename;
	
	private List<File> fileList = new ArrayList<File>();//搜索返回的filenumber列表

	
	//该getter对应于返回的最终数据
	@JSON(name="jsonresult")
	public List<File> getFilejsonarray() {
		return fileList;
	}
	
	/*
	 * Getter and Setter
	 */
	/*public String getFilename() {
		return filename;
	}*/
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public String execute()
	{
		ORMTool ormtool = new ORMTool("Collection");
		String hql = "select f from File as f";
		for(Object o : ormtool.getQuery(hql))
		{
			File f = (File)o;
			if(f.getFilename().contains(this.filename))
			{
				this.fileList.add(f);
			}
		}
		
		return "SearchSuccess";
	}

}
