package debug;

import java.io.UnsupportedEncodingException;

import tool.AppTool;
import tool.ORMTool;

public class FunctionDebug {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//AppTool.ConsoleOut(AppTool.getApplicationAbsolutePath());
		//AppTool.getDateStr();
		
		/*
		 * 慎重
		 */
		try {
			ORMTool.initFileTable();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
