package ajaxaction;

import java.io.InputStream;

public class LoadAction {
	
	private String tag;
	private InputStream inputStream;
	
	public InputStream getResult()
	{
		return inputStream;
	}
	
	
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}


	public String execute()
	{
		//String path = LoadAction.class.getResource(name)
		return null;
	}

}
