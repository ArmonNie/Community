package com.datebase;
import java.sql.*;
public class DateBase {
private static final String  URL = "jdbc:mysql://localhost:3306/community?user=root&password=&useUnicode=true&characterEncoding=utf-8";

protected static Statement statement = null ;
protected static ResultSet resultSet = null ;
protected static Connection connection = null ;

public static synchronized Connection getConnection(){
	try{
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(URL);
	}catch(Exception e){
		e.printStackTrace();
	}
	return connection;
}
public static int executeUpdate(String sql){
	int result = 0 ;
	try{
		statement = getConnection().createStatement();
		result = statement.executeUpdate(sql);
	}catch(Exception e){
		e.printStackTrace();
	}
	return result;
}
public static ResultSet executeQuery(String sql){
	try{
		statement = getConnection().createStatement();
		resultSet = statement.executeQuery(sql);
	}catch (Exception e) {
	e.printStackTrace();
	}
	return resultSet;
}
public static PreparedStatement excutePreparedStatement (String sql){
	PreparedStatement preparedStatement = null ;
	try{
		preparedStatement = getConnection().prepareStatement(sql);
	}catch (Exception e) {
		e.printStackTrace();
	}
	return preparedStatement;
}
public static void rollback() {
	try{
		getConnection().rollback();
	}catch(SQLException e){
		e.printStackTrace();
	}
}
public static void close() {
	try{
		if(resultSet!=null){
			resultSet.close();
		}
		if (statement!=null) {
			statement.close();
		}
		if (connection!=null) {
			connection.close();
		}
	}catch (SQLException e) {
	e.printStackTrace();
	}
}
}
