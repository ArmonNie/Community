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
		//ORMTool tool = new ORMTool("user");
		//String hql = "select u.userpassword from User as u where username like :username";
		//String hql = "select u from User as u";
		//tool.getQuery(hql,this.username);
		/*tool.miterateresultList();*/
		Configuration cfg = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(cfg.getProperties()).build();
		SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Transaction trasaction = session.beginTransaction();
		
	
		String hql = "select u.userpassword from User as u where username = :username";
		List resultList = session.createQuery(hql)
				.setString("username", this.username)
				.list();
		for(Iterator pit = resultList.iterator();pit.hasNext();)
		{
			String str = (String)pit.next();
			AppTool.ConsoleOut(str);
		}
		trasaction.commit();
		session.close();
		/*
		 * 密码验证
		 */
		
		
		//测试
		result = "LoginSuccess";
		
		return result;
	}

}
