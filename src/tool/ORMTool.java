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

import bean.Collection;
import bean.Comment;
import bean.File;
import bean.History;
import bean.User;
import bean.UserUpload;


/**
 * @author Armon
 * @category 操作数据库的工具类
 * 功能描述：构造函数传入操作的表格（若要
 * 进行插入/批量插入，还需要传入插入
 * 的对象），并进行初始化之后通过实例
 * 调用具体的方法完成数据库操作
 */
public class ORMTool {
	
	
	//无论如何，需要知道操作的是哪个表，以便对于object进行正确的转换
	private String TableName;
	
	//操作数据库必须对象
	private Session session;
	private Transaction trasaction;
	
	
	/*
	 * ORMtool的构造函数
	 */
	//一般用于查询，删除（进行具体操作再传入具体的对象）
	public ORMTool(String TableName)
	{
		this.TableName = TableName;
		this.Init();
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
	/*
	 * Session与Transication不提供Setter
	 */
	public Transaction getTrasaction() {
		return trasaction;
	}
	public Session getSession()
	{
		return session;
	}
	
	
	/*
	*必须操作（默认在构造器中执行）
	*初始化对话，开启事务（hibernate框架公共操作）
	*/
	public void  Init()
	{
		Configuration cfg = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(cfg.getProperties()).build();
		SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		this.session = sessionFactory.openSession();
		this.trasaction = session.beginTransaction();
	}
	
	/*
	 * 需要显式关闭会话
	 */
	public void closeSession()
	{
		session.close();
	}

	
	
	/*
	 * 以下为数据库操作（增删改查）
	 */
	// 单个插入,向目的表插入一条数据
	public void insert(Object object)
	{
		switch(this.TableName)
		{
			case "user":
				User user = new User();
				user = (User)object;	
				AppTool.DebugOut(user, "user", "null");
				session.save(user);
				session.getTransaction().commit();
				this.closeSession();//注意关闭
				break;
			case "file":
				File file = new File();
				file = (File)object;
				AppTool.DebugOut(file, "file", "null");
				session.save(file);
				session.getTransaction().commit();
				this.closeSession();//注意关闭
				break;
			case "history":
				History history = new History();
				history = (History)object;
				AppTool.DebugOut(history, "history", "null");
				session.save(history);
				session.getTransaction().commit();
				this.closeSession();//注意关闭
				break;
			case "collection":
				Collection collection = new Collection();
				collection = (Collection)object;
				AppTool.DebugOut(collection, "collection", "null");
				session.save(collection);
				session.getTransaction().commit();
				this.closeSession();//注意关闭
				break;
			case "comment":
				Comment comment = new Comment();
				comment = (Comment)object;
				AppTool.DebugOut(comment, "comment", "null");
				session.save(comment);
				session.getTransaction().commit();
				this.closeSession();//注意关闭
				break;
			case "userupload":
				UserUpload usup = new UserUpload();
				usup = (UserUpload)object;
				AppTool.DebugOut(usup, "userupload", "null");
				session.save(usup);
				session.getTransaction().commit();
				this.closeSession();//注意关闭
				break;
		}
	}
	/*
	 * 批量插入，同时插入多条数据
	 * insertAmount代表插入的数量
	 */
	public void inserts(List<Object> objectList)
	{
		switch(this.TableName)
		{
			case "user":
				for(int i=0;i<objectList.size();i++)
				{
					User user = new User();
					user = (User)objectList.get(i);
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
				for(int i=0;i<objectList.size();i++)
				{
					File file = new File();
					file = (File)objectList.get(i);
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
	 * 单个删除
	 */
	public void delete(Object object,int id)
	{
		switch(this.TableName)
		{
			case "user":
				User user = new User();
				user = (User)object;
				user.setUserid(id);
				session.delete(user);
				session.getTransaction().commit();
				this.closeSession();
				break;
			case "file":
				File file = new File();
				file = (File)object;
				file.setFileid(id);
				session.delete(file);
				session.getTransaction().commit();
				this.closeSession();
				break;
		}
	}
	
	/*
	 * 批量删除
	 */
	/*public void deletes()
	{
		
	}*/
	
	
	/*
	 * 更新,待改进
	 */
	public void update(Object object,int updateid)
	{
		switch(this.TableName)
		{
			case "user":
				User user = new User();
				user = (User)object;
				user.setUserid(updateid);
				session.update(user);
				session.getTransaction().commit();
				//this.closeSession();
				break;
		}
	}
	
	
	/*
	 * 查询,params代表条件查询的参数
	 */
	//无条件查询
	public List getQuery(String hql)
	{
		List resultList = session.createQuery(hql).list();
		AppTool.ConsoleOut("查询得来的列表长度：" + resultList.size());
		for(int i = 0;i<resultList.size();i++)
		{
			AppTool.ConsoleOut(resultList.get(i).toString());
		}
		this.closeSession();
		return resultList;
	}
	//条件查询
	public List getQuery(String hql,String params1)
	{
		AppTool.ConsoleOut("查询语句为" + hql);
		AppTool.ConsoleOut("查询条件限制之用户名为" + params1);
		List resultList = session.createQuery(hql)
				.setString(0, params1)
				.list();
		AppTool.ConsoleOut("查询得来的列表长度：" + resultList.size());
		for(int i = 0;i<resultList.size();i++)
		{
			AppTool.ConsoleOut(resultList.get(i).toString());
		}
		this.closeSession();
		return resultList;
	}
	
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
	 * 本方法用于第一次初始化File表，慎重调用
	 */
	public static void initFileTable() throws UnsupportedEncodingException
	{
		List<java.io.File> fl = new ArrayList<java.io.File>();
		List<Object> mFile = new ArrayList<Object>();
		
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
			int i = 0;
			if(f.getAbsolutePath().contains("video"))
			{
				i=0;
			}
			if(f.getAbsolutePath().contains("CG"))
			{
				i=1;
			}
			if(f.getAbsolutePath().contains("TV"))
			{
				i=2;
			}
			File mf = new File();
			/*
			 * 用Base64处理filenumber
			 */
			mf.setFilenumber(AppTool.getBase64FromStr(f.getAbsolutePath() + "" + i));
			mf.setFilename(f.getName());
			mf.setFilepath(f.getAbsolutePath());
			mf.setFilesize((int)f.length()/(1024*1024));
			mf.setGoodnumber(0);
			mf.setFiledescription("暂时未上传介绍，更多精彩敬请期待！！");
			mf.setFiletype("" + i);
			
			mFile.add(mf);
		}
		
		/*
		 * 执行批量插入
		 */
		ORMTool ormtool = new ORMTool("file");
		ormtool.inserts(mFile);
		ormtool.closeSession();
	}
	
}
