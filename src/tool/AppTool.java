package tool;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


/*
 * 系统工具
 */
public class AppTool {
	
	private static String basePath = "d:/ServerVideo";//系统操作的文件夹
	
	public static void ConsoleOut(String msg)
	{
		System.out.println(msg);
	}

	public static String getBasePath()
	{
		return basePath;
	}
	
	/*
	 * 初始化File表格，应用仅允许调用一次
	 */
	public static void InitFileTable()
	{
		
	}
	
	/*
	 * 获取项目在服务器绝对路径
	 */
	public static String getApplicationAbsolutePath()
	{
		return "";
	}
	/*
	 * 处理项目内文件，处理为流对象返回
	 */
	//C:\Users\Armon\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp2\wtpwebapps\Community\   
	//WEB-INF\page
	public static InputStream getAppFileInputStream(String path,String filename) throws FileNotFoundException
	{
		File file = new File(path + "WEB-INF\\page\\" + filename);
		if(file.exists())
		{
			FileInputStream fip = new FileInputStream(file);
			return fip;
		}
		else
		{
			AppTool.ConsoleOut("目标文件不存在");
			String data = "出错了";
			ByteArrayInputStream dataStream = new ByteArrayInputStream(data.getBytes());
			return dataStream; 
		}
	}
}
