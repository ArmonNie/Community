package ajaxaction;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import bean.Comment;
import bean.CommentAndUser;
import bean.File;
import bean.History;
import bean.User;
import tool.AppTool;
import tool.ORMTool;

public class GetCommentAction {

	private String usernumber;
	private List<Comment> commentList;//评论列表
	private List<User> userList;//用户列表
	
	private List<CommentAndUser> culist = new ArrayList<CommentAndUser>();//待返回的文件列表
	
	
	//该getter对应于返回的最终数据
	@JSON(name="jsonresult")
	public List<CommentAndUser> getHistoryjsonarray() {
		return culist;
	}

	
	/*
	 * 前台给后台，调用的是setter，后台给前台，调用的是getter
	 * 注意：若依然存在getter，会被Struts以json形式一起传给前台
	 * 造成解析困难
	 */
	/*public String getUsernumber() {
		return usernumber;
	}*/
	public void setUsernumber(String usernumber) {
		this.usernumber = usernumber;
	}

	/*
	 * 信息逻辑处理
	 */
	public String execute()
	{
		AppTool.ConsoleOut("前台传入的标签：" + this.usernumber);
		
		/*
		 * 首先获取comment列表
		 */
		ORMTool ormtool = new ORMTool("comment");
		String hql = "select c from Comment as c where c.usernumber = ?";
		this.commentList = ormtool.getQuery(hql, usernumber);

		for(Comment c : this.commentList)
		{
			ORMTool ormtool1 = new ORMTool("user");
			hql = "select u from User as u where u.usernumber = ?";
			/*
			 * 此处出现过nullpointer错误原因：filelist未实例化时调用addAll等实例
			 * 方法就会出想Nullpointer错误
			 */
			this.userList = ormtool1.getQuery(hql,c.getUsernumber());
			CommentAndUser cau = new CommentAndUser(this.userList.get(0).getUsername(),c.getComment());
			this.culist.add(cau);
		}
		
		AppTool.ConsoleOut("传给前台的列表长度：" + this.culist.size());
		
		//返回结果要与Struts.xml对应
		return "GetCommentSuccess";
	
	}
	
}

//ajax返回的数据
/*
 * 不可以使用内部类，Struts无法访问该类，无法将之转化为json
 */
/*class CommentAndUser
{
	
	private String username;
	private String usercomment;
	
	public CommentAndUser(String username,String usercomment)
	{
		this.usercomment = usercomment;
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsercomment() {
		return usercomment;
	}
	public void setUsercomment(String usercomment) {
		this.usercomment = usercomment;
	}

	
}*/

