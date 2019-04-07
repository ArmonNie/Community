package ajaxaction;

import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import bean.User;
import tool.AppTool;
import tool.ORMTool;

public class GetAllUserAction {
	
	private List<User> userlist;
	
	@JSON(name="userlist")
	public List<User> getAlluser()
	{
		return this.userlist;
	}
	
	public String execute()
	{
		ORMTool ormtool = new ORMTool("user");
		String hql = "select u from User as u";
		this.userlist = ormtool.getQuery(hql);
		AppTool.ConsoleOut("传给前台的列表长度：" + userlist.size());
		return "GetUserSuccess";
	}

}
