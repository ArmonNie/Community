package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.datebase.DateBase;;

/**
 * Servlet implementation class Collect
 */
@WebServlet("/SetCollectServlet")
public class SetCollectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String filename = "";
	private String username = "";
	private String oldusermsg = "";
	private String newusermsg = "";
	
	private String sql = "";
	private int IsUpdate = 0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetCollectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		username =((UserBean)request.getSession().getAttribute("userBean")).getName();
		filename = request.getParameter("filename");
		try {
			getMsg(request,response);
			this.newusermsg += ";" + filename;
			collect(request,response);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}
	
	public void collect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException
	{
		int result = 0;
		if(this.IsUpdate == 0) {		
			sql = "INSERT INTO collection(User_name,Collection) VALUES(?,?)";
		    result = 0;
			 try{
				 PreparedStatement preparedStatement = DateBase.excutePreparedStatement(sql);
				 preparedStatement.setString(1, username);
				 preparedStatement.setString(2,newusermsg);
				 result =preparedStatement.executeUpdate();
				 preparedStatement.close();
				 	 }catch (SQLException e) {
						e.printStackTrace();
					}
			 PrintWriter out = response.getWriter();
			 if(result>0){
				 out.println("succeed");
			 }else{
				 out.println("failed");
			 }
		}
		if(this.IsUpdate == 1)
		{
			sql = "UPDATE collection SET Collection= ? WHERE User_name = ?";
		    result = 0;
		    try{
				 PreparedStatement preparedStatement = DateBase.excutePreparedStatement(sql);
				 preparedStatement.setString(1, this.newusermsg);
				 preparedStatement.setString(2,this.username);
				 result =preparedStatement.executeUpdate();
				 preparedStatement.close();
				 	 }catch (SQLException e) {
						e.printStackTrace();
					}
			 PrintWriter out = response.getWriter();
			 if(result>0){
				 out.println("succeed");
			 }else{
				 out.println("failed");
			 }
		}	
	}

	public void getMsg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException
	{
		System.out.println("" + this.username);
		sql = "SELECT * FORM collection WHERE User_name= ? ";
	    try{
			 PreparedStatement preparedStatement = DateBase.excutePreparedStatement(sql);
			 preparedStatement.setString(1,username);
			 ResultSet rs = preparedStatement.executeQuery();
			 System.out.println(rs.first());
				if(rs.first())
				{
					this.IsUpdate = 1;
					String Collection = rs.getString("Collection");
					System.out.println(Collection);
					this.oldusermsg = Collection;
					this.newusermsg = this.oldusermsg;
				}
				else
				{
					this.IsUpdate = 0;
					System.out.println("查询失败");
				}
			 preparedStatement.close();
			 	 }catch (SQLException e) {
					e.printStackTrace();
				}
	}
}
