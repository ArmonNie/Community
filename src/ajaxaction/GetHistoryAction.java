package ajaxaction;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import bean.File;
import bean.FileAndHistory;
import bean.History;
import tool.AppTool;
import tool.ORMTool;

public class GetHistoryAction {

	private String usernumber;
	
	private List<History> historyList;//历史列表
	private List<File> filelist = new ArrayList<File>();//文件列表
	
	private List<FileAndHistory> filehistorylist = new ArrayList<FileAndHistory>();//返回给前台的信息列表
	
	
	//该getter对应于返回的最终数据
	@JSON(name="jsonresult")
	public List<FileAndHistory> getHistoryjsonarray() {
		return filehistorylist;
	}

	
	/*
	 * 前台给后台，调用的是setter，后台给前台，调用的是getter
	 * 注意：若依然存在getter，会被Struts以json形式一起传给前台
	 * 造成解析困难
	 */
	/*public String getUsernumber() {
		return usernumber;
	}*/
	public void setUsernumber(String usernumber) {
		this.usernumber = usernumber;
	}

	/*
	 * 信息逻辑处理
	 */
	public String execute()
	{
		AppTool.ConsoleOut("前台传入的标签：" + this.usernumber);
		
		/*
		 * 首先获取history列表
		 */
		ORMTool ormtool = new ORMTool("history");
		String hql = "select h from History as h where h.historyusernumber = ?";
		this.historyList = ormtool.getQuery(hql, usernumber);
		
		for(History h : this.historyList)
		{
			ORMTool ormtool1 = new ORMTool("file");
			hql = "select f from File as f where f.filenumber = ?";
			/*
			 * 此处出现过nullpointer错误原因：filelist未实例化时调用addAll等实例
			 * 方法就会出想Nullpointer错误
			 */
			this.filelist.addAll(ormtool1.getQuery(hql, h.getHistoryfilenumber()));
			for(File f : filelist)
			{
				FileAndHistory fah = new FileAndHistory();
				fah.setFiledescription(f.getFiledescription());
				fah.setFilename(f.getFilename());
				fah.setFilenumber(f.getFilenumber());
				fah.setHistorydate(h.getHistorytime());
				this.filehistorylist.add(fah);
			}
		}
		
		AppTool.ConsoleOut("传给前台的列表长度：" + this.filehistorylist.size());
		
		//返回结果要与Struts.xml对应
		return "GetHistorySuccess";
	
	}
	
}
