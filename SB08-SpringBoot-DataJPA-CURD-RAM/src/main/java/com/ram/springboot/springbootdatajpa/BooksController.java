package com.ram.springboot.springbootdatajpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {
	
	@Autowired
	BooksService booksService;
	
	/*{  
	    "bookid": "300",  
	    "bookname": "MySpring",  
	    "author": "UST-Students",  
	    "price": "550"  
	   }   */
	//Add Books 	
	@PostMapping("/addbook")
	public int addBook(@RequestBody Books books) {
		
		booksService.addBook(books);
		return books.getBookid();
		
	}
	// Retrive  All books 
    
	@GetMapping("/allbooks")
	  public List<Books>getAllBooks() {
		  
		  return   booksService.getAllBooks();
	  }
		
	// Book by ID
	@GetMapping("/bookid/{bookid}")
	public Books getBookById(@PathVariable("bookid") int bookid) {
		
		return booksService.getBookById(bookid);
		//int r=booksService.getBookById(bookid);
		//if(r==null) {
		//	throws new BookIdNotFoundExcetpion ();
		
	   //	return r;
		  //ResponseEntity 
	
	}
	
	
	
	// Update (PUT)
	@PutMapping("/updatebook")
	public Books update(@RequestBody Books books) {
		booksService.update(books);
		return books;
	}
	
	//Delete Record
	@DeleteMapping("/bookid/{bookid}")
	public  void deleteBook(@PathVariable("bookid")int bookid) {
		booksService.delete(bookid);
	} 	
}
