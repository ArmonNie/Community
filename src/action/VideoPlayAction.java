package action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

import bean.File;
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
		List fList;
		/*关于值栈*/
		ActionContext context=ActionContext.getContext();
        ValueStack stack=context.getValueStack();
		ORMTool ormtool = new ORMTool("file");
		String hql = "select f from File as f where f.filenumber = ?";
		fList = ormtool.getQuery(hql, filenumber);
		for(Object o : fList)
		{
			File f = (File)o;
			stack.setParameter("file", f);
			AppTool.DebugOut(f, "file", "即将播放视频信息：");
		}
		return "videoplay";
	}

}
