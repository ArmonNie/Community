package tool;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataTool {
	public static Statement statement;
	public static Connection con;
	public static String ConnectionMessage = "";
	
	public static void ConnectToDatabase()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("δ�ҵ����࣬��Ϣ��jdbc");
		}
	
		//���ݿ��url
		String url = "jdbc:mysql://localhost:3306/MyWebSystem?user=root&password=root";
		//String url = "jdbc:mysql://120.79.21.64:3306/myusersystem?user=Armon&password=Ilovelm417520";
		//String url = "jdbc:mysql://localhost:3306/myusersystem?user=Armon&password=Ilovelm417520";
		try {
			con = DriverManager.getConnection(url);
			statement = con.createStatement();
			DataTool.ConnectionMessage = "Success";
			System.out.println("�����������ݿ⣡");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("δ���������ݿ⣡");
			DataTool.ConnectionMessage = "Fail";
		}
	}
	
	public static ResultSet Query(String sql)
	{
		ResultSet rs = null;
		try {
			rs = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public static int Updata(String sql)
	{
		int rs = 0;
		try {
			rs = statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	
	//�ر����ݿ�����
	public static void Close()
	{
		if(statement != null)
		{
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(con != null)
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
