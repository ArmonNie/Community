package ajaxaction;

import bean.Comment;
import tool.ORMTool;

public class CommentAction {
	
	private String usernumber;
	private String filenumber;
	private String comment;
	
	
	/*
	 * Getter and Setter
	 */
	/*public String getUsernumber() {
		return usernumber;
	}*/
	public void setUsernumber(String usernumber) {
		this.usernumber = usernumber;
	}
	/*public String getFilenumber() {
		return filenumber;
	}*/
	public void setFilenumber(String filenumber) {
		this.filenumber = filenumber;
	}
	/*public String getComment() {
		return comment;
	}*/
	public void setComment(String comment) {
		this.comment = comment;
	}


	public String execute()
	{
		ORMTool ormtool = new ORMTool("comment");
		Comment comment = new Comment();
		comment.setComment(this.comment);//局部变量与全局变量重名
		comment.setFilenumber(filenumber);
		comment.setUsernumber(usernumber);
		ormtool.insert(comment);
		return "CommentSuccess";
	}

}
