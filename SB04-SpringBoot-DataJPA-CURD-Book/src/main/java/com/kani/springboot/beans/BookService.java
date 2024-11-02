package com.kani.springboot.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class BookService {
	@Autowired
	BookRepository booksRepository;
	
	
	public void addBook(Book book) {
		  
		booksRepository.save(book);
		
	}

}
