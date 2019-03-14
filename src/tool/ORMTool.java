package tool;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
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
	
	
	//无论如何，需要知道操作的是哪个表，以便对于object进行正确的转换
	private String TableName;
	private Object object;
	
	//用于多条数据操作
	private List<Object> objectList;
	
	//操作数据库必须对象
	private Session session;
	private Transaction trasaction;
	
	//用于存储查询返回的结果集
	//private List resultList;
	
	//以便不时之需
	private String tag;
	
	/*
	 * ORMtool的构造函数
	 */
	//一般用于查询，删除
	public ORMTool(String TableName)
	{
		this.TableName = TableName;
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
	public Session getSession()
	{
		return session;
	}
	
	
	/*
	*必须操作
	*初始化对话，开启事务（hibernate框架公共操作）
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
	 * 查询,params代表条件查询的参数
	 */
	/*public List getQuery(String hql)
	{
		resultList = session.createQuery(hql).list();
		AppTool.ConsoleOut("查询得来的列表长度：" + resultList.size());
		this.closeSession();
		return resultList;
	}*/
	public void getQuery(String hql,String params1)
	{
		AppTool.ConsoleOut("查询语句为" + hql);
		AppTool.ConsoleOut("查询条件限制之用户名为" + params1);
		//resultList = session.createQuery(hql).setString("username", params1).list();
		//resultList是一个未初始化的值
		List resultList = session.createQuery(hql).list();
		for(Iterator pit = resultList.iterator();pit.hasNext();)
		{
			User user = (User)pit.next();
			AppTool.ConsoleOut(user.toString());
		}
		AppTool.ConsoleOut("查询得来的列表长度：" + resultList.size());
		this.closeSession();
		//return resultList;
	}
	/*public List getQuery(String hql,String params1,String params2)
	{
		resultList = session.createQuery(hql).list();
		this.closeSession();
		return resultList;
	}*/
	
	/*
	 * 关于查询所返回的list里面的对象类型是否确定?
	 * 待改进
	 */
	/*public void miterateresultList()
	{
		switch(this.TableName)
		{
			case "user":
				for(Object o : resultList)
				{
					System.out.println(o.toString());
				}
				break;
			case "file":
				for(Object o : resultList)
				{
					System.out.println(o.toString());
				}
				break;
		}
	}*/
	
	/*
	 * 单个插入,向目的表插入一条数据
	 */
	public void insert(Object object)
	{
		this.initSession();
		this.setObject(object);
		switch(this.TableName)
		{
			case "user":
				User user = new User();
				user = (User)this.object;	
				AppTool.DebugOut(user, "User", "null");
				session.save(user);
				session.getTransaction().commit();
				this.closeSession();
				break;
			case "file":
				File file = new File();
				file = (File)this.object;
				session.save(file);
				session.getTransaction().commit();
				this.closeSession();
				break;
		}
	}
	
	/*
	 * 批量插入，同时插入多条数据
	 * insertAmount代表插入的数量
	 */
	public void inserts(int insertAmount)
	{
		this.initSession();
		switch(this.TableName)
		{
			case "user":
				for(int i=0;i<insertAmount;i++)
				{
					User user = new User();
					user = (User)this.objectList.get(i);
					session.save(user);
					if(i%10 == 0)
					{
						session.flush();
						session.clear();
					}
				}
				session.getTransaction().commit();
				this.closeSession();
				break;
			case "file":
				for(int i=0;i<insertAmount;i++)
				{
					File file = new File();
					file = (File)this.objectList.get(i);
					session.save(file);
					if(i%10 == 0)
					{
						session.flush();
						session.clear();
					}
				}
				session.getTransaction().commit();
				this.closeSession();
				break;
		}
	}
	
	/*
	 * 更新,待改进
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
	 * 单个删除
	 */
	public void delete()
	{
		this.initSession();
		switch(this.TableName)
		{
			case "user":
				User user = new User();
				user = (User)this.object;
				session.delete(user);
				session.getTransaction().commit();
				break;
			case "file":
				File file = new File();
				file = (File)this.object;
				session.delete(file);
				session.getTransaction().commit();
				break;
		}
	}
	
	/*
	 * 批量删除
	 */
	public void deletes()
	{
		
	}
	
	/*
	 * 关闭会话
	 */
	public void closeSession()
	{
		session.close();
	}
	
	/*
	 * 本方法用于第一次初始化File表，慎重调用
	 */
	public static void initFileTable() throws UnsupportedEncodingException
	{
		List<java.io.File> fl = new ArrayList<java.io.File>();
		List<File> mFile = new ArrayList<File>();
		
		//File f = new File(this.dirPath);
		java.io.File fvideo = new java.io.File("D:\\ServerVideo\\video\\");
		java.io.File fcg = new java.io.File("D:\\ServerVideo\\CG\\");
		java.io.File ftv = new java.io.File("D:\\ServerVideo\\TV\\");
		if(fvideo.isDirectory())
		{
			java.io.File[] fArray = fvideo.listFiles();
			for(int i = 0;i < fArray.length;i++)
			{
				if(fArray[i].isFile())
				{
					fl.add(fArray[i]);
				}
			}
		}
		else
		{
			AppTool.ConsoleOut("非目录");
		}
		if(fcg.isDirectory())
		{
			java.io.File[] fArray = fcg.listFiles();
			for(int i = 0;i < fArray.length;i++)
			{
				if(fArray[i].isFile())
				{
					fl.add(fArray[i]);
				}
			}
		}
		else
		{
			AppTool.ConsoleOut("非目录");
		}
		if(ftv.isDirectory())
		{
			java.io.File[] fArray = ftv.listFiles();
			for(int i = 0;i < fArray.length;i++)
			{
				if(fArray[i].isFile())
				{
					fl.add(fArray[i]);
				}
			}
		}
		else
		{
			AppTool.ConsoleOut("非目录");
		}
		for(java.io.File f : fl)
		{
			File mf = new File();
			/*
			 * 用Base64处理filenumber
			 */
			mf.setFilenumber(AppTool.getBase64FromStr(f.getAbsolutePath()));
			mf.setFilename(f.getName());
			mf.setFilepath(f.getAbsolutePath());
			mf.setFilesize((int)f.length()/(1024*1024));
			mf.setGoodnumber(0);
			mf.setFiledescription("暂时未上传介绍，更多精彩敬请期待！！");
			
			mFile.add(mf);
		}
		
		/*
		 * 执行批量插入
		 */
		ORMTool ormtool = new ORMTool("file");
		ormtool.initSession();
		int counter=0;
		for(File f : mFile)
		{
			AppTool.ConsoleOut(f.toString());
			ormtool.session.save(f);
			if(counter%10 == 0)
			{
				ormtool.session.flush();
				ormtool.session.clear();
			}
			counter++;
		}
		ormtool.session.getTransaction().commit();
		ormtool.closeSession();
	}
	
}
