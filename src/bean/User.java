package bean;

public class User {
	
	private int userid;//User表主键
	private String usernumber;//User表用户编号
	private String username;//User表用户名
	private String useremail;//User表用户邮箱
	private String userpassword;//User表用户密码
	private int isvip;//User表用户是否为VIP
	
	/*
	 * Getter and Setter
	 */
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsernumber() {
		return usernumber;
	}
	public void setUsernumber(String usernumber) {
		this.usernumber = usernumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	
	public int getIsvip() {
		return isvip;
	}
	public void setIsvip(int isvip) {
		this.isvip = isvip;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 重写了User对象的toString，用于返回User信息
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "usernumber" + this.usernumber + "\nname" + this.username 
				+ "\nemail" + this.useremail + "\npassword" + this.userpassword
				+ "\nisvip" + this.isvip;
	}
	
	
	
}
