package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.datebase.DateBase;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		HttpSession session = request.getSession();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
	
        //out.println(name);
       // out.println(pwd);
		
		String sql = "SELECT * FROM user WHERE Name = '" + name+"'";
		ResultSet resultSet = null;
		resultSet = DateBase.executeQuery(sql);
		try {
			if (resultSet.next() ){
					if (pwd.equals(resultSet.getString("Pwd"))){
						
						String user_name = new String();
						user_name=resultSet.getString("Name");			 				
						session.setAttribute("user_name", user_name);		
						out.println("succeed");				

					    response.sendRedirect("Content.jsp");
						
					}	else {
						out.println("failed");
						out.println("密码错误！");
					}
			}else{
				out.println("failed");
				out.println("未被使用的用户名！");
				}
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

}
