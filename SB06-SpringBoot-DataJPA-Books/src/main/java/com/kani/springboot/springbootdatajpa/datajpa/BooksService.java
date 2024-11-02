package com.kani.springboot.springbootdatajpa.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BooksService {
	
	@Autowired
	BooksRepository booksRepository;
	
	
	public void addBook(Books books) {
		  
		booksRepository.save(books);
		
	}

}
