package com.kani.corejava.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.kani.corejava.beans.BookBean;

import java.sql.PreparedStatement;


public class BookDAO {
	int i;
	            //          100 java  250 C
	public int addBook(BookBean bookBean) throws ClassNotFoundException {
		
		System.out.println("Book DAO Layer");
		System.out.println("BookID"+bookBean.getBookId());
		System.out.println("BookTitle :"+bookBean.getTitle());
		
		Connection connection = null;
	      String url = "jdbc:mysql://localhost:3306/";
	      String dbName = "mydb";
	      String driverName = "com.mysql.jdbc.Driver";
	      String userName = "root";
	      String password = "root";
	      try{
	        Class.forName(driverName); // Calculation cal=new Calculation();
	        connection = DriverManager.getConnection(url+dbName, userName, password);
	        
	        String query="insert into book values(?,?,?,?)";
	        
	       PreparedStatement pstmt=connection.prepareStatement(query);
	        pstmt.setInt(1, bookBean.getBookId());
	        pstmt.setString(2,bookBean.getTitle());
	        pstmt.setDouble(3,bookBean.getPrice());
	        pstmt.setString(4, bookBean.getGrade());
	        
	        i= pstmt.executeUpdate();
	        
	      }
	      catch(SQLException e) {
	    	  System.out.println(e);
	      }
		return i;
	}

}
