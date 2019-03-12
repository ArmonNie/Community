package ajaxaction;

public class LoadStreamAction {

	//private InputStream inputStream;
	/*public InputStream getResult()
	{
		return inputStream;
	}*/
	
	/*
	 * 尝试一
	 */
	//String path = LoadAction.class.getResource(name)
	//String data = "OK";
	//ByteArrayInputStream dataStream = new ByteArrayInputStream(data.getBytes());
	//inputStream = dataStream;
	
	/*
	 * 尝试二
	 */
	/*try {
		inputStream = AppTool.getAppFileInputStream(servletContext.getRealPath("/"), "filePart.html");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		String data = "出错了";
		ByteArrayInputStream dataStream = new ByteArrayInputStream(data.getBytes());
		inputStream = dataStream; 
		e.printStackTrace();
	}
	return "LoadSuccess";*/
	
}
