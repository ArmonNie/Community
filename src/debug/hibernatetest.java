package debug;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import bean.User;
/*
 * 用于测试链接数据库用户名密码正确与否
 */
public class hibernatetest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(cfg.getProperties()).build();
		SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Transaction trasaction = session.beginTransaction();
		
		User user = new User();
		user.setIsvip(0);
		user.setUsernumber("dasdasd");
		user.setUseremail("dasd");
		user.setUsername("dasdas");
		user.setUserpassword("dasdasd");
		
		session.save(user);
		trasaction.commit();
		session.close();
	}

}
