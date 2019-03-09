package bean;

public class Comment {
	
	private int conmmentid;//Conmment表主键
	private String usernumber;//Conmment表User编号
	private String filenumber;//Conmment表File编号
	private String comment;//Conmment表commment内容
	
	
	
	/*
	 * Getter and Setter
	 */
	public int getConmmentid() {
		return conmmentid;
	}
	public void setConmmentid(int conmmentid) {
		this.conmmentid = conmmentid;
	}
	public String getUsernumber() {
		return usernumber;
	}
	public void setUsernumber(String usernumber) {
		this.usernumber = usernumber;
	}
	public String getFilenumber() {
		return filenumber;
	}
	public void setFilenumber(String filenumber) {
		this.filenumber = filenumber;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 重写了Comment对象的toString，用于返回Comment信息
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "usernumber" + this.usernumber + "\nfilenumber" + this.filenumber 
				+ "\ncomment" + this.comment;
	}
}
