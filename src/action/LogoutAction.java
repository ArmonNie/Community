package action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import tool.SessionTool;

public class LogoutAction implements SessionAware{

	
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

	public String execute()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session1 = request.getSession();
		session1.invalidate();
		return "Logout";
	}
	
}
