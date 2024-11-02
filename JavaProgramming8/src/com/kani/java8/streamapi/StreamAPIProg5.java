package com.kani.java8.streamapi;

import java.util.Arrays;
import java.util.List;

public class StreamAPIProg5 {

	public static void main(String[] args) {
		 
		List<Integer> mylist=Arrays.asList(1,2,3,4,5);
		
			
	
	mylist.stream().map(i->i*i).forEach(System.out::println);
	

}}
