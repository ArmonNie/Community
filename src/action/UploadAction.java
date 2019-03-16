package action;

public class UploadAction {
	
	private String filenumber;//File表file编号
	private String filename;//File表file名字
	private String filepath;//File表file路径
	private int filesize;//File表file大小
	private int goodnumber;//File表file点赞数
	private String filedescription;//文件描述
	private String filetype;//文件类型（movie，cg，tv）
	private String filetag;//文件标签（综艺，娱乐，戏剧，玄幻）
	
	
	/*
	 * Getter与Setter
	 */
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
	public String getFiledescription() {
		return filedescription;
	}
	public void setFiledescription(String filedescription) {
		this.filedescription = filedescription;
	}
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	public String getFiletag() {
		return filetag;
	}
	public void setFiletag(String filetag) {
		this.filetag = filetag;
	}
	
	
	public String execute()
	{
		/*
		 * 上传逻辑代码，上传完成转到用户中心
		 */
		return "usercenter";
	}
	

}
