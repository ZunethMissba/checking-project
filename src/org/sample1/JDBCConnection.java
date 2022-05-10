package org.sample1;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCConnection {
	
	public static void main(String args[]){  
		try{  
		//step1 load the driver class  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		  
		//step2 create  the connection object  
		Connection connection=DriverManager.getConnection(  
		"jdbc:oracle:thin:@localhost:1521:xe","hr","Missbazuneth@1");  
		  
		String query="Select *from Employees ";
		
		PreparedStatement prepareStatement = connection.prepareStatement(query); 

		ResultSet executeQuery = prepareStatement.executeQuery();

		while (executeQuery.next()) {
			String string = executeQuery.getString("first_name");
			System.out.println(string);
		}
		
		connection.close();}
		catch(Exception e){ System.out.println(e);}  
		  
		}  
		
	}
