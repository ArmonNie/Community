package tool;
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
}
