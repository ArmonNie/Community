package tool;
/*
 * 对于文件以及文件夹的操作工具类
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
		this.setDirPath(AppTool.getBasePath() + "\\1\\");
	}
	
	/*
	 * 获取目的目录的所有文件
	 */
	public List<File> getFileList()
	{
		
		List<File> fl = new ArrayList<File>();
		
		//File f = new File(this.dirPath);
		File f = new File("D:\\ServerVideo\\video\\");
		if(f.isDirectory())
		{
			File[] fArray = f.listFiles();
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
		return fl;
	}
	
	/*
	 * 获取文件具体信息
	 */
	public static void getFileMsg(File file)
	{
		System.out.println("文件名：" + file.getName());
		System.out.println("文件路径：" + file.getAbsolutePath());
		System.out.println("文件大小" + file.length()/(1024*1024) + "MB");
	}
	public static void getFileMsg(bean.File file)
	{
		System.out.println("文件名：" + file.getFilename());
		System.out.println("文件路径：" + file.getFilepath());
		System.out.println("文件大小" + file.getFilesize());
	}
	
	/*
	 * 文件复制
	 */
	public static void copyFile(java.io.File oldFile, File newFile) throws IOException
	{
		int bytesum = 0;  
        int byteread = 0;  
		if(oldFile.exists())
		{
			try {
				FileInputStream fip = new FileInputStream(oldFile);
				FileOutputStream fop = new FileOutputStream(newFile);
				byte[] buffer = new byte[1444];
				while((byteread = fip.read(buffer)) != -1) {
					bytesum += byteread; //字节数 文件大小  
					//System.out.println(bytesum);  
                    fop.write(buffer, 0, byteread);
				}
				fip.close();
				fop.close();
			} catch (FileNotFoundException e) {
				System.out.println("文件操作内部错误");
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}
}
