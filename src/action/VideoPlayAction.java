package action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

import bean.File;
import bean.History;
import bean.User;
import tool.AppTool;
import tool.ORMTool;

/*
 * 用于生成播放历史纪录，跳转到播放页面
 */
public class VideoPlayAction {
	
	private String filenumber;//通过filenumber确认播放的视频信息
	
	
	
	public String getFilenumber() {
		return filenumber;
	}
	public void setFilenumber(String filenumber) {
		this.filenumber = filenumber;
	}
	
	
	public String execute()
	{
		/*
		 * 插入history表
		 */
		ORMTool ormtool = new ORMTool("history");
		History history = new History();
		String usernumber = ServletActionContext
				.getRequest().getSession()
				.getAttribute("usernumber").toString();
		history.setHistorynumber(this.filenumber + "/" + usernumber);
		history.setHistorytime(AppTool.getDateStr());
		history.setHistoryfilenumber(this.filenumber);
		history.setHistoryusernumber(usernumber);
		ormtool.insert(history);
		/*
		 * 更改视频热度信息
		 */
		ORMTool ormtool1 = new ORMTool("file");
		
		String hql = "select f from File as f where filenumber = ?";
		List resultList = ormtool1.getQuery(hql,this.filenumber + "");
		AppTool.ConsoleOut("列表大小：" + resultList.size());
		
		ORMTool ormtool2 = new ORMTool("file");
		File file = new File();
		file = (File) resultList.get(0);
		file.setGoodnumber(file.getGoodnumber() + 1);
		ormtool2.update(file,file.getFileid());
		
		
		return "videoplay";
	}

}
