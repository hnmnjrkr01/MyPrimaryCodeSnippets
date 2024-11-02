package com.ram.springboot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contacts")
public class Contacts {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String email;
	private long mobileNumber;
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public long getMobileNumber() {
		return mobileNumber;
	}



	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}



	@Override
	public String toString() {
		return "Contacts [ID=" + id + ", Name=" + name + ", email=" + email + ", mobileNumber=" + mobileNumber + "]";
	}
	
	

}
