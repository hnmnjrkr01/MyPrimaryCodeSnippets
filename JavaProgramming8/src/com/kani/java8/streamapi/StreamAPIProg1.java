package com.kani.java8.streamapi;

import java.util.Arrays;
import java.util.List;

public class StreamAPIProg1 {

	public static void main(String[] args) {
		 
		List<Integer> mylist=Arrays.asList(1,2,3,4,5,6,7);
		
		for(int i=0;i<7;i++)
			System.out.println(mylist.get(i));

	
	
	mylist.stream().forEach(System.out::println);
	

}}
