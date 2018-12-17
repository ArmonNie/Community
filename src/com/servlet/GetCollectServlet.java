package com.servlet;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.UserBean;
import com.datebase.DateBase;

/**
 * Servlet implementation class GetCollectServlet
 */
@WebServlet("/GetCollectServlet")
public class GetCollectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String sql = "";
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sql = "SELECT * FORM collection WHERE User_name= ? ";
		String username =((UserBean)request.getSession().getAttribute("userBean")).getName();
	    try{
			 PreparedStatement preparedStatement = DateBase.excutePreparedStatement(sql);
			 preparedStatement.setString(1,username);
			 ResultSet rs = preparedStatement.executeQuery();
			 System.out.println(rs.first());
				if(rs.first())
				{
					response.setCharacterEncoding("utf-8");
					String Collection = rs.getString("Collection");
					response.getWriter().println(Collection + "hj");
					System.out.println(Collection);			
				}
				else
				{
					System.out.println("查询失败");
				}
			 preparedStatement.close();
			 	 }catch (SQLException e) {
					e.printStackTrace();
				}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
