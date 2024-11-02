package com.kani.java8.streamapi;

import java.util.Arrays;
import java.util.List;

public class StreamAPIProg4 {

	public static void main(String[] args) {
		 
		List<Integer> mylist=Arrays.asList(11,22,33,44,11,44);
		
			
	
	mylist.stream().forEach(System.out::println);
	System.out.println("Stream API with distinct");
	// distinct 
	mylist.stream().skip(4).forEach(System.out::println);
	

}}
