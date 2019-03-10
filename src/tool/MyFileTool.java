package tool;
/*
 * 对于文件以及文件夹的操作工具类
 */
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MyFileTool {

	private String dirPath;
	
	
	public String getDirPath() {
		return dirPath;
	}
	public void setDirPath(String dirPath) {
		this.dirPath = dirPath;
	}


	public MyFileTool()
	{
		this.setDirPath(AppTool.getBasePath() + "/");
	}
	
	/*
	 * 获取目的目录的所有文件
	 */
	public List<String> getFileList()
	{
		List<String> fl = new ArrayList<String>();
		
		
		return fl;
	}
	
	/*
	 * 获取文件具体信息
	 */
	public void getFileMsg(File file)
	{
		
	}
}
