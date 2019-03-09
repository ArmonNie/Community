package bean;

public class File {
	
	private int fileid;//File表file主键
	private String filenumber;//File表file编号
	private String filename;//File表file名字
	private String filepath;//File表file路径
	private int filesize;//File表file大小
	private int goodnumber;//File表file点赞数
	
	
	/*
	 * Getter and Setter
	 */
	public int getFileid() {
		return fileid;
	}
	public void setFileid(int fileid) {
		this.fileid = fileid;
	}
	public String getFilenumber() {
		return filenumber;
	}
	public void setFilenumber(String filenumber) {
		this.filenumber = filenumber;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public int getFilesize() {
		return filesize;
	}
	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}
	public int getGoodnumber() {
		return goodnumber;
	}
	public void setGoodnumber(int goodnumber) {
		this.goodnumber = goodnumber;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 重写了File对象的toString，用于返回File信息
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "filenumber" + this.filenumber + "\nfilename" + this.filename 
				+ "\nfilepath" + this.filepath + "\nfilesize" + this.filesize
				+ "\ngoodnumber" + this.goodnumber;
	}

}
