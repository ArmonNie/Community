package action;

import com.opensymphony.xwork2.ActionSupport;

import tool.AppTool;

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
		AppTool.ConsoleOut(this.username);
		if(this.username.equals("Armon"))
		{
			result = "LoginSuccess";
		}
		else
		{
			
		}
		return result;
	}

}