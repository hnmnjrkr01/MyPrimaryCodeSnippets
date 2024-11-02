package com.kani.springboot.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Book {
	
	@Id
	private int bookId;
	@Column
	private String bookTittle;
	@Column
	
	private String author;
	@Column
	private int price;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookTittle() {
		return bookTittle;
	}
	public void setBookTittle(String bookTittle) {
		this.bookTittle = bookTittle;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
