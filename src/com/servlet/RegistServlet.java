package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.datebase.DateBase;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String name = request.getParameter("name");
		  String pwd = request.getParameter("pwd");
		  String email = request.getParameter("email"); 
		   
		  String sql = "INSERT INTO user(Name,Pwd,Email)VALUES(?,?,?)";
		  
		  int result = 0;
			 try{
				 PreparedStatement preparedStatement = DateBase.excutePreparedStatement(sql);
				 preparedStatement.setString(1, name);
				 preparedStatement.setString(2, pwd);
				 preparedStatement.setString(3, email);
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
