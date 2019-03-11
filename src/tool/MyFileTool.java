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
		this.setDirPath(AppTool.getBasePath());
	}
	
	public MyFileTool(String path)
	{
		this.setDirPath(AppTool.getBasePath() + "/");
	}
	
	/*
	 * 获取目的目录的所有文件
	 */
	public List<File> getFileList()
	{
		
		List<File> fl = new ArrayList<File>();
		
		File f = new File(this.dirPath);
		File[] fArray = f.listFiles();
		for(int i = 0;i < fArray.length;i++)
		{
			if(fArray[i].isFile())
			{
				fl.add(fArray[i]);
			}
		}
		
		return fl;
	}
	
	/*
	 * 获取文件具体信息
	 */
	public void getFileMsg(File file)
	{
		System.out.println("文件名：" + file.getName());
		System.out.println("文件路径：" + file.getAbsolutePath());
		System.out.println("文件父路径" + file.getParent());
	}
}
