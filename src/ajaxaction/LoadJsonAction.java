package ajaxaction;

/*
 * @author Armon
 * @description 根据前台传过来的不同tag，查询数据库或者遍历相应文件夹
 * 获取视频文件的列表（名字，路径，大小，格式）,之后将List转化为json传送给前台进行显示
 */
import bean.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import tool.AppTool;
import tool.MyFileTool;
import tool.ORMTool;

public class LoadJsonAction{
	
	private String tag;
	private int page = 1;//默认为1
	private List<File> filelist;//待返回的列表
	private int totalNumber;
	
	
	//该getter对应于返回的最终数据
	@JSON(name="jsonresult")
	public List<File> getFilejsonarray() {
		return filelist;
	}
	@JSON(name="total")
	public int getTotalnumber()
	{
		return this.totalNumber;
	}
	
	
	/*
	 * 前台给后台，调用的是setter，后台给前台，调用的是getter
	 * 注意：若依然存在getter，会被Struts以json形式一起传给前台
	 * 造成解析困难
	 */
	/*public String getTag() {
		return tag;
	}*/
	public void setTag(String tag) {
		this.tag = tag;
	}
	/*public int getPage() {
		return page;
	}*/
	public void setPage(int page) {
		this.page = page;
	}


	/*
	 * 信息逻辑处理
	 */
	public String execute()
	{
		AppTool.ConsoleOut("前台传入的标签：" + this.tag);
		
		ORMTool ormtool = new ORMTool("file");
		String hql = "select f from File as f";
		
		List<File> tempfilelist;
		
		switch(tag)
		{
			case "0":
				hql = "select f from File as f where f.filetype = ?";
				tempfilelist = ormtool.getQuery(hql, tag);
				this.totalNumber = tempfilelist.size();
				/*
				 * 根据页数返回相应数量的数据,注意边缘判断
				 */
				this.filelist = tempfilelist.subList((page-1)*12, page*12);
				break;
			case "1":
				hql = "select f from File as f where f.filetype = ?";
				tempfilelist = ormtool.getQuery(hql, tag);
				this.totalNumber = tempfilelist.size();
				/*
				 * 根据页数返回相应数量的数据,注意边缘判断
				 */
				this.filelist = tempfilelist.subList((page-1)*12, page*12);
				break;
			case "2":
				hql = "select f from File as f where f.filetype = ?";
				tempfilelist = ormtool.getQuery(hql, tag);
				this.totalNumber = tempfilelist.size();
				/*
				 * 根据页数返回相应数量的数据,注意边缘判断
				 */
				this.filelist = tempfilelist.subList((page-1)*12, page*12);
				break;
			default:
				hql = "select f from File as f";
				this.filelist = ormtool.getQuery(hql);
				break;
		}
		
		
		AppTool.ConsoleOut("传给前台的列表长度：" + filelist.size());
		
		//返回结果要与Struts.xml对应
		return "LoadAjax";
	
	}

}
