package ajaxaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import bean.File;
import bean.User;
import tool.AppTool;
import tool.ORMTool;

public class ChangePasswordAction {
	
	private int updateid;
	private String userpassword;
	
	/*
	 * 处理注册结果，与Struts视图对应
	 */
	private Map<String,String> result;

	/*public int getUpdateid() {
		return deleteid;
	}*/
	public void setUpdateid(int updateid) {
		this.updateid = updateid;
	}
	/*public String getUserpassword() {
		return userpassword;
	}*/
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}



	/*
	 * ajax注册以json形式返回注册结果
	 */
	@JSON(name="result")
	public Map<String,String> getResult()
	{
		return this.result;
	}
	
	public String execute()
	{	
		try {
		AppTool.ConsoleOut("前台数据：" + this.updateid + this.userpassword);
		//true即是User对象创建成功（参数不为空）
		//AppTool.ConsoleOut("插入数据库前");
		ORMTool ormtool = new ORMTool("user");
		
		String hql = "select u from User as u where userid = ?";
		List resultList = ormtool.getQuery(hql,this.updateid + "");
		AppTool.ConsoleOut("列表大小：" + resultList.size());
		
		ORMTool ormtool1 = new ORMTool("user");
		User user = new User();
		user = (User) resultList.get(0);
		user.setUserpassword(this.userpassword);
		ormtool1.update(user,this.updateid);
		//AppTool.ConsoleOut("插入数据库后");
		/*
		 * 注意插入是否成功
		*/
			
		/*
		 * 给前台返回的json数据
		*/
		result = new HashMap<String,String>();
		result.put("result", "1");
		result.put("msg", "0");
		}
		catch(Exception e)
		{
			result = new HashMap<String,String>();
			result.put("result", "0");
			result.put("msg", "0");
		}
		return "ChangePasswordSuccess";
	}

}
