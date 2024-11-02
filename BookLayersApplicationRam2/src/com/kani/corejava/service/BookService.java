package com.kani.corejava.service;

import com.kani.corejava.beans.BookBean;
import com.kani.corejava.dao.BookDAO;

public class BookService {
	String grade;
                              //    100         java          250
	 public int addBookService(int bookId,String title,double price) throws ClassNotFoundException {
		 System.out.println("Book Serivce Layer - 2");
		   System.out.println(bookId+title+price);
		 
		   if(price<=300)		   {
			      grade="C";
		   }
		  else if(price<=600) {
				   grade="B";
			   }
		  else {
				   grade="A";
		   }
		   // Adding data to BookBean
		   BookBean bookBean = new BookBean();
		       bookBean.setBookId(bookId);  //100
		       bookBean.setTitle(title);  //java
		       bookBean.setPrice(price);  //250
		       bookBean.setGrade(grade);  //c
		   
		    //Sending data to BookDAO
		       
		       BookDAO bookDAO=new BookDAO();
		    int k=   bookDAO.addBook(bookBean);
		       
		   return k;

	 }
	
}
