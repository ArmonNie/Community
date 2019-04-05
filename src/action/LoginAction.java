package action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;


import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.opensymphony.xwork2.ActionSupport;

import bean.User;
import tool.AppTool;
import tool.ORMTool;

//登陆控制逻辑
//TODO 1.用户表改进（isvip与管理员总体就是用户身份） 2.提供用户头像，以及在线状态等记录
public class LoginAction extends ActionSupport implements SessionAware{
	
	private String username;
	private String userpassword;
	
	/*
	 * setSession由Struts完成？？
	 */
	private Map mSession;
	
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
	 * 操作Session
	 * (non-Javadoc)
	 * @see org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
	 */
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.mSession = arg0;
	}

	/*
	 * 控制逻辑
	 */
	public String execute()
	{
		String result = "LoginError";
		
		/*AppTool.ConsoleOut("前台传入用户名：" + this.username 
				+ "前台传入密码" + this.userpassword);*/
		
		/*
		 * 数据库查询,控制登陆
		 */
		ORMTool ormtool = new ORMTool("user");
		String hql = "select u from User as u where username = ?";
		List resultList = ormtool.getQuery(hql,this.username);
		if(resultList.size() == 0)
		{
			//此结果代表无此用户
			result = "LoginNoUser";
		}
		else 
		{
			for(Object o : resultList)
			{
				User user = (User)o;
				if(user.getUsername().equals(this.username)&&user.getUserpassword().equals(this.userpassword))
				{
					//存放进入session
					mSession.put("username", user.getUsername());
					mSession.put("usernumber", user.getUsernumber());
					
					//登陆成功
					result = "LoginSuccess";
					
					//管理员登陆（暂时以特定账号密码进行）
					if(user.getUsername().equals("聂璋"))
					{
						result = "Admin";
					}
				}
				//提供邮箱登陆支持
				else if(user.getUseremail().equals(this.username)&&user.getUserpassword().equals(this.userpassword))
				{
					//存放进入session
					mSession.put("username", user.getUsername());
					mSession.put("usernumber", user.getUsernumber());
					result = "LoginSuccess";
					
					//管理员登陆
					if(user.getUsername().equals("聂璋"))
					{
						result = "Admin";
					}
				}
				else
				{
					//密码输入与数据库不匹配
					result = "LoginError";
				}
			}
		}
		
		return result;
	}

}
