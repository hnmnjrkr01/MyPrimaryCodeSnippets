package com.ram.springboot.springbootdatajpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BooksService {

	 @Autowired
	BooksRepository booksRepository;
	
	//Post  save - update //
	 /*{  
	    "bookid": "300",  
	    "bookname": "MySpring",  
	    "author": "UST-Students",  
	    "price": "550"  
	   }   */
	public void addBook(Books books) {
		booksRepository.save(books);
		
	}
	// get all books form database through  SpringDataJPA
	public List<Books> getAllBooks(){
		List<Books> books=new ArrayList<Books>();
		
		booksRepository.findAll().forEach(b1 -> books.add(b1));
		
		System.out.println(books);
		
		return books;
		
	}
	// Retrive  find by book
	public Books getBookById(int id) {
	  return 	booksRepository.findById(id).get();
	}
	
	
	//Update  a record
	public void update(Books books) { 		
		booksRepository.save(books); 	 
		
	}
	
	//Delete a record 
	
	public void delete(int id) {
		booksRepository.deleteById(id);
	} 	
}
