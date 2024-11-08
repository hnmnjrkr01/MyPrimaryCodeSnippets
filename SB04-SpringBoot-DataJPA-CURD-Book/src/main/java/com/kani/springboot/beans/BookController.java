package com.kani.springboot.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	@Autowired
	BookService bookService;
	
	@PostMapping("/addBook")
	public int addBook(@RequestBody Book book) {
		
		bookService.addBook(book);
		
		return book.getBookId();
	}
	
}
