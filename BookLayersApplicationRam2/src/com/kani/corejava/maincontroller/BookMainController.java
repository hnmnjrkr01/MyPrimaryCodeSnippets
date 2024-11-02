package com.kani.corejava.maincontroller;

import java.util.Scanner;

import com.kani.corejava.service.BookService;

public class BookMainController {
      
	public static void main(String[] args) {
		try {
		System.out.println(" BookMainController -1  ");
		int bookId=0;
		String title=null;
		double price;
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Book Id :");
		bookId=sc.nextInt();
		System.out.println("Enter Book Title :");
		title=sc.next();
		System.out.println("Enter Book Price :");
		price=sc.nextDouble();
		
		BookService bookService=new BookService();
		int t=bookService.addBookService(bookId, title, price);
		System.out.println("Main controller return value form DAO layer :"+t);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
