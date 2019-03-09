package tool;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.function.VarArgsSQLFunction;
import org.hibernate.service.ServiceRegistry;

import bean.File;
import bean.User;


/*
 * 操作数据库的类
 */
public class ORMTool {
	
	private String TableName;
	private Object object;
	private String tag;
	private Session session;
	private Transaction trasaction;
	

	/*
	 * ORMtool的构造函数
	 */
	public ORMTool()
	{
		
	}
	
	public ORMTool(String TableName,Object object)
	{
		this.TableName = TableName;
		this.object = object;
	}
	
	/*
	 * Getter and Setter
	 */
	public String getTableName() {
		return TableName;
	}
	public void setTableName(String tableName) {
		TableName = tableName;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public Transaction getTrasaction() {
		return trasaction;
	}
	public void setTrasaction(Transaction trasaction) {
		this.trasaction = trasaction;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	
	
	/*
	*初始化对话，开启事务
	*/
	public void  initSession()
	{
		Configuration cfg = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(cfg.getProperties()).build();
		SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		this.session = sessionFactory.openSession();
		trasaction = session.beginTransaction();
	}
	

	/*
	 * 关闭会话
	 */
	public void closeSession()
	{
		session.close();
	}
	
	/*
	 * 查询
	 */
	public Query getQuery(String hql)
	{
		return session.createQuery(hql);
	}
	
	
	public Session getSession()
	{
		return session;
	}
	
	public Transaction getTranscation()
	{
		return this.trasaction;
	}
	
	/*
	 * 插入
	 */
	public void insert()
	{
		this.initSession();
		switch(this.TableName)
		{
			case "user":
				User user = new User();
				user = (User)this.object;			
				session.save(user);
				session.getTransaction().commit();
				//this.closeSession();
				break;
			case "file":
				File file = new File();
				file = (File)this.object;
				session.save(file);
				session.getTransaction().commit();
				//this.closeSession();
				break;
		}
	}
	
	
	/*
	 * 更新
	 */
	public void update()
	{
		this.initSession();
		switch(this.TableName)
		{
			/*case "student":
				Student student = new Student();
				student = (Student)this.object;
				Student ole_student=(Student)session.get(Student.class, student.getStudentid());		            
		        System.out.println("1412666026    "+ole_student.getStudenttag());
		        System.out.println("1412666026    "+student.getStudenttag());
				ole_student.setStudenttag(student.getStudenttag());
	            
				session.update(ole_student);
				session.getTransaction().commit();
				//this.closeSession();
				break;
			case "teacher":
				Teacher teacher = new Teacher();
				teacher = (Teacher)this.object;
				session.update(teacher);
				session.getTransaction().commit();
				//this.closeSession();
				break;
			case "exam":
				Exam exam = new Exam();
				exam = (Exam)this.object;
				session.update(exam);
				session.getTransaction().commit();
				//this.closeSession();
				break;*/
		}
	}
	
	
	/*
	 * 删除
	 */
	public void delete()
	{
		this.initSession();
		switch(this.TableName)
		{
			/*case "student":
				Student student = new Student();
				student = (Student)this.object;
				session.delete(student);
				session.getTransaction().commit();
				//this.closeSession();
				break;
			case "teacher":
				Teacher teacher = new Teacher();
				teacher = (Teacher)this.object;
				session.delete(teacher);
				session.getTransaction().commit();
				//this.closeSession();
				break;
			case "exam":
				Exam exam = new Exam();
				exam = (Exam)this.object;
				session.delete(exam);
				session.getTransaction().commit();
				//this.closeSession();
				break;*/
		}
	}
	
	
	public List<Object[]> query(String hql)
	{
		Query query = session.createQuery(hql);
		return query.list();
	}
}
