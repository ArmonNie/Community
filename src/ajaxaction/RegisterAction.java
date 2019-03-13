package ajaxaction;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import bean.User;
import tool.AppTool;
import tool.ORMTool;

public class RegisterAction {
	
	/*
	 * 注册需要的信息（姓名，邮箱，密码）
	 * usernumber，isvip由后台生成
	 */
	private String username;
	private String useremail;
	private String userpassword;
	
	//对应实体对象,在init中进行构造
	private User user;
	
	/*
	 * 处理注册结果，与Struts视图对应
	 */
	private Map<String,String> result;
	
	
	/*
	 * Getter，Setter，因为作为ajax，暂时只提供Setter
	 */
	/*public String getUsername() {
		return username;
	}*/
	public void setUsername(String username) {
		this.username = username;
	}
	/*public String getUseremail() {
		return useremail;
	}*/
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	/*public String getUserpassword() {
		return userpassword;
	}*/
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	/*
	 * 判断是否成功从前台获取到了参数,同时构建相关实体对象
	 */
	private boolean Init()
	{
		boolean result = false;
		user = new User();
		//如果有空字符串，需要重新让前台传值
		if(this.useremail.equals("")||this.username.equals("")||this.userpassword.equals(""))
		{
			result = false;
			AppTool.ConsoleOut("注册时，用户实体类初始化失败！！");
		}
		else
		{
			/*
			 * 关于id，id在数据库中会自动递增
			 */
			user.setUsernumber(AppTool.getDateStr() + "0" + this.useremail);
			user.setUsername(username);
			user.setUseremail(useremail);
			user.setUserpassword(userpassword);
			user.setIsvip(0);
			
			result = true;
			AppTool.ConsoleOut("注册时，用户实体类初始化成功！！");
			AppTool.DebugOut(user, "User", "前台数据已经接受！");
		}
		return result;
	}
	
	/*
	 * ajax注册以json形式返回注册结果
	 */
	@JSON(name="registerresult")
	public Map<String,String> getResult()
	{
		return this.result;
	}


	public String execute()
	{
		AppTool.ConsoleOut("前台数据：" + this.username + this.useremail + this.userpassword);
		//true即是User对象创建成功（参数不为空）
		if(this.Init())
		{
			/*
			 * 插入数据库操作
			 */
			/*
			 * 数据库操作
			 */
			AppTool.ConsoleOut("插入数据库前");
			ORMTool ormtool = new ORMTool("user");
			ormtool.insert(user);
			AppTool.ConsoleOut("插入数据库后");
			/*
			 * 注意插入是否成功
			 */
			
			/*
			 * 给前台返回的json数据
			 */
			result = new HashMap<String,String>();
			result.put("result", "1");
			result.put("msg", "0");
			return "RegisterSuccess";
		}
		else
		{
			return "RegisterFail";
		}
	}

}
