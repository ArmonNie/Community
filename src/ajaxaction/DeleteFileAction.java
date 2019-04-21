package ajaxaction;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import bean.File;
import bean.User;
import tool.ORMTool;
/*
 * 改进：删除实际文件
 */
public class DeleteFileAction {

	private int deleteid;
	
	/*
	 * 处理注册结果，与Struts视图对应
	 */
	private Map<String,String> result;

	/*public int getDeleteid() {
		return deleteid;
	}*/
	public void setDeleteid(int deleteid) {
		this.deleteid = deleteid;
	}
	
	/*
	 * ajax注册以json形式返回注册结果
	 */
	@JSON(name="deleteresult")
	public Map<String,String> getResult()
	{
		return this.result;
	}
	
	public String execute()
	{
		try {
		//AppTool.ConsoleOut("前台数据：" + this.username + this.useremail + this.userpassword);
		//true即是User对象创建成功（参数不为空）
		//AppTool.ConsoleOut("插入数据库前");
		ORMTool ormtool = new ORMTool("file");
		File file = new File();
		ormtool.delete(file,this.deleteid);
		//AppTool.ConsoleOut("插入数据库后");
		/*
		 * 注意插入是否成功
		*/
			
		/*
		 * 给前台返回的json数据
		*/
		result = new HashMap<String,String>();
		result.put("result", "1");
		result.put("msg", "0");
		}
		catch(Exception e)
		{
			result = new HashMap<String,String>();
			result.put("result", "0");
			result.put("msg", "0");
		}
		return "DeleteFileSuccess";
	}
	
}
