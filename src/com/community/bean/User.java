package com.community.bean;

public class User {
	
	private String userid;
	private String username;
	private String useremail;
	private String userpassword;
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id" + this.userid + "\nname" + this.username 
				+ "\nemail" + this.useremail;
	}
	
	
	
}
