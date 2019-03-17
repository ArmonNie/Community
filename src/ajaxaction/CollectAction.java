package ajaxaction;

import org.apache.struts2.ServletActionContext;

import bean.Collection;
import bean.History;
import tool.AppTool;
import tool.ORMTool;

public class CollectAction {
	
	private String filenumber;
	

	/*
	 * 为ajaxaction，避免返回多于数据源，取消了多余的getter
	 */
	/*public String getFilenumber() {
		return filenumber;
	}*/
	public void setFilenumber(String filenumber) {
		this.filenumber = filenumber;
	}
	
	public String execute()
	{
		/*
		 * 插入collection表
		 */
		ORMTool ormtool = new ORMTool("collection");
		Collection collection = new Collection();
		String usernumber = ServletActionContext
				.getRequest().getSession()
				.getAttribute("usernumber").toString();
		collection.setFilenumber(filenumber);
		collection.setUsernumber(usernumber);
		ormtool.insert(collection);
		return "CollectSuccess";
	}

}
