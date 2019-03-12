package ajaxaction;

/*
 * @author Armon
 * @description 根据前台传过来的不同tag，查询数据库或者遍历相应文件夹
 * 获取视频文件的列表（名字，路径，大小，格式）,之后将List转化为json传送给前台进行显示
 */
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import tool.AppTool;
import tool.MyFileTool;

public class LoadJsonAction{
	
	private String tag;
	private List<File> filelist = new ArrayList<File>();//待返回的列表
	
	private List<bean.File> filelistresult = new ArrayList<bean.File>();//实际返回的列表
	
	
	//该getter对应于返回的最终数据
	@JSON(name="jsonresult")
	public List<bean.File> getFilejsonarray() {
		return filelistresult;
	}

	
	/*
	 * 前台给后台，调用的是setter，后台给前台，调用的是getter
	 * 注意：若依然存在getter，会被Struts以json形式一起传给前台
	 * 造成解析困难
	 */
	/*public String getTag() {
		return tag;
	}*/
	public void setTag(String tag) {
		this.tag = tag;
	}

	/*
	 * 信息逻辑处理
	 */
	public String execute()
	{
		AppTool.ConsoleOut("前台传入的标签：" + this.tag);
		
		//TODO 注意此处的文件夹(MyFileTool类里面)写死了，要改正
		MyFileTool mft = new MyFileTool();
		//获取文件列表(对应的是系统的File类)
		this.filelist = mft.getFileList();
		/*
		 * 应该以我定义的file形式返回
		 * （需要将系统File的对应信息取出放在个人建立的bean.Filel的List里面）
		 * 若以系统的File进行返回，存在解析问题(系统File转化为json所含有的数据太多，解析复杂，只需要部分提取出来即可)
		 */
		for(File file : filelist)
		{
			MyFileTool.getFileMsg(file);
			bean.File mfile = new bean.File();
			mfile.setFilename(file.getName().replaceAll(" ", ""));//同时去掉空格
			mfile.setFilepath(file.getAbsolutePath());
			mfile.setFilesize((int)file.length()/(1024*1024));
			filelistresult.add(mfile);
		}

		AppTool.ConsoleOut("传给前台的列表长度：" + filelistresult.size());
		//返回结果要与Struts.xml对应
		return "LoadAjax";
	
	}

}
