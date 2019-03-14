package action;

/*
 * 列表中的部分非ajax超链接请求处理
 */
public class LinkAction {
	
	private String index;
	
	
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}


	public String execute()
	{
		return index;
	}

}
