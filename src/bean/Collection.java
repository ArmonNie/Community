package bean;

public class Collection {
	
	private int collectionid;//Collection表主键
	private String usernumber;//Collection表User编号
	private String filenumber;//Collection表File编号
	
	
	/*
	 * Getter and Setter
	 */
	public int getCollectionid() {
		return collectionid;
	}
	public void setCollectionid(int collectionid) {
		this.collectionid = collectionid;
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
	
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 重写了Comment对象的toString，用于返回Comment信息
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "usernumber" + this.usernumber + "\nfilenumber" + this.filenumber ;
	}

}
