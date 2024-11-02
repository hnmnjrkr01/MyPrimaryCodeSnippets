package com.kani.java8.streamapi;

import java.util.Arrays;
import java.util.List;

public class StreamAPIProg6 {

	public static void main(String[] args) {
		 
		List<String> mylist=Arrays.asList("JAVA","Hibernate","JPA","Spring");
		
			
	
	mylist.stream().map(str->str.length()).forEach(System.out::println);
	

}}
