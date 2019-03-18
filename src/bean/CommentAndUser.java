package bean;

public class CommentAndUser {

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

	
}
