package com.kani.springboot.springbootdatajpa.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
   
@RestController
public class BooksController {
	
	@Autowired
	BooksService  booksService;
	
	//Add Books
	@PostMapping("/addbook")
	public int addBook(@RequestBody  Books books) {
		
		booksService.addBook(books);
		return books.getBookid();
		
	}

}
