package tool;

import java.util.Map;

import javax.websocket.Session;

import com.opensymphony.xwork2.ActionContext;

/*
 * 操作session
 */

public class SessionTool{
	
	
	private  ActionContext actionContext;
	private  Map<String, Object> session;
	
	
	public void init(ActionContext actionContext)
	{
		this.actionContext = actionContext;
		this.session = actionContext.getSession();
	}
  
	public void setSession(String username)
	{
		session.put("username", username);
	}
	
	public void setSession(String username,String usernumber)
	{
		session.put("username", username);
		session.put("usernumber", usernumber);
	}
	
	public void setSession(String username,String userpassword,String usernumber)
	{
		session.put("username", username);
		session.put("userpassword", userpassword);
		session.put("usernumber", usernumber);
	}
	
	/*
	 * 退出时清空Session
	 */
	public void removeSession()
	{
		session.clear();
	}
	
}
