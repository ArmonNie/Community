package action;

import java.util.Iterator;
import java.util.List;

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
		
		/*
		 * 数据库查询,控制登陆
		 */
		ORMTool ormtool = new ORMTool("user");
		String hql = "select u from User as u where username = ?";
		List resultList = ormtool.getQuery(hql,this.username);
		if(resultList.size() == 0)
		{
			result = "LoginError";
		}
		else 
		{
			for(Object o : resultList)
			{
				User user = (User)o;
				if(user.getUsername().equals(this.username)&&user.getUserpassword().equals(this.userpassword))
				{
					result = "LoginSuccess";
				}
				else
				{
					result = "LoginError";
				}
			}
		}

		/*
		 * 密码验证
		 */
		
		
		//测试
		//result = "LoginSuccess";
		
		return result;
	}

}
