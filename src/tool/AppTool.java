package tool;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;

import bean.Collection;
import bean.Comment;
import bean.User;


/*
 * 系统工具
 */
public class AppTool {
	
	private static String basePath = "d:/ServerVideo";//系统操作的文件夹
	
	/*
	 * 常规系统输出
	 */
	public static void ConsoleOut(String msg)
	{
		System.out.println(msg);
	}
	
	/*
	 * Debug输出
	 */
	public static void DebugOut(Object object,String objectType,String other)
	{
		AppTool.ConsoleOut("Other Debug Message" + other);
		switch(objectType)
		{
			case "user":
				User user = (User)object;
				AppTool.ConsoleOut(user.toString());
				break;
			case "file":
				bean.File file = (bean.File)object;
				AppTool.ConsoleOut(file.toString());
				break;
			case "collection":
				Collection collection = (Collection)object;
				AppTool.ConsoleOut(collection.toString());
				break;
			case "comment":
				Comment comment = (Comment)object;
				AppTool.ConsoleOut(comment.toString());
				break;
			default:
				AppTool.ConsoleOut("无测试信息/无此类对象");
				break;
		}
	}

	/*
	 * 获取当前年月日字符串
	 * 用于生成usernumber
	 */
	public static String getDateStr()
	{
		 Date d = new Date(); 
	     SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); 
	     String dateNowStr = sdf.format(d); 
	     AppTool.ConsoleOut("格式化后的日期：" + dateNowStr);
	     return dateNowStr;
	}
	
	/*
	 * 字符串编码Base64
	 * 用于filenumber生成
	 */
	public static String getBase64FromStr(String desStr) throws UnsupportedEncodingException
	{
		final Base64.Encoder encoder = Base64.getEncoder();
		final String text = desStr;
		final byte[] textByte = text.getBytes("UTF-8");
		//编码
		final String encodedText = encoder.encodeToString(textByte);
		System.out.println(encodedText);
		return encodedText;
	}
	
	/*
	 * 解码Base64
	 */
	public static String getStrFromBase64(String desStr) throws UnsupportedEncodingException
	{
		final Base64.Decoder decoder = Base64.getDecoder();
		final String text = desStr;
		final byte[] textByte = text.getBytes("UTF-8");
		//解码
		System.out.println(new String(decoder.decode(text), "UTF-8"));
		return new String(decoder.decode(text), "UTF-8");
	}
	
	
	public static String getBasePath()
	{
		return basePath;
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
	
	public static JSONArray FileList2Json(List<File> list){
        JSONArray json = new JSONArray();
        for(File f : list){
        	AppTool.ConsoleOut("Json" + f.getName());
            JSONObject jo = new JSONObject();
            jo.put("name", f.getName());
            jo.put("size", f.length()/1024);
             
            json.put(jo);
        }
        return json;
   }
}
