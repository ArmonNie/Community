package action;

import com.opensymphony.xwork2.ActionSupport;

import tool.AppTool;
import tool.ORMTool;

public class LoginAction extends ActionSupport{
	
	private String username;
	private String userpassword;
	
	/*
	 * Getter and Setter
	 */
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	

	/*
	 * 控制逻辑
	 */
	public String execute()
	{
		String result = "LoginError";
		AppTool.ConsoleOut("前台传入用户名：" + this.username 
				+ "前台传入密码" + this.userpassword);
		
		
		ORMTool tool = new ORMTool("user");
		String hql = "select u from User u where username like :username";
		tool.getQuery(hql,this.username);
		tool.miterateresultList();
		
		return result;
	}

}
