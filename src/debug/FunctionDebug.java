package debug;

import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;

import tool.AppTool;
import tool.ORMTool;
import webservice.*;

public class FunctionDebug {

	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		//AppTool.ConsoleOut(AppTool.getApplicationAbsolutePath());
		//AppTool.getDateStr();
		
		/*
		 * 慎重
		 */
		/*try {
			ORMTool.initFileTable();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/*
		 * Service测试
		 */
		CommunityServiceProxy proxy = new CommunityServiceProxy();
		CommunityService communityservice = proxy.getCommunityService();
		System.out.println(communityservice.say());
	}

}
