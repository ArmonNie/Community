package ajaxaction;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import bean.User;
import tool.AppTool;
import tool.ORMTool;

public class DeleteUserAction {
	
	private int deleteid;
	
	/*
	 * 处理注册结果，与Struts视图对应
	 */
	private Map<String,String> result;

	/*public int getDeleteid() {
		return deleteid;
	}*/
	public void setDeleteid(int deleteid) {
		this.deleteid = deleteid;
	}
	
	/*
	 * ajax注册以json形式返回注册结果
	 */
	@JSON(name="deleteresult")
	public Map<String,String> getResult()
	{
		return this.result;
	}
	
	public String execute()
	{
		/*
		 * 注意存在无法删除的情况！！
		 */
		//AppTool.ConsoleOut("前台数据：" + this.username + this.useremail + this.userpassword);
		//true即是User对象创建成功（参数不为空）
		//AppTool.ConsoleOut("插入数据库前");
		try {
		ORMTool ormtool = new ORMTool("user");
		User user = new User();
		ormtool.delete(user,this.deleteid);
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
		return "DeleteUserSuccess";
		}
		catch(Exception e)
		{
			AppTool.ConsoleOut("该用户存在外键关联，不推荐删除！！！");
			result = new HashMap<String,String>();
			result.put("result", "0");
			result.put("msg", "0");
			return "DeleteUserSuccess";
		}
	}

}
