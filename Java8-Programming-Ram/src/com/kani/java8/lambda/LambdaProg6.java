package com.kani.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaProg6 {

	public static void main(String[] args) {
		 
	List<Integer> mylist=Arrays.asList(1,2,3,4,5,6,7);
	
	System.out.println("Display with ForEach Adv Loop");
	for(Integer i:mylist)
		System.out.println(i);
	
	System.out.println("Display with Lambda");
	
	mylist.forEach(n->System.out.println(n));
	
	
	System.out.println("Display with Method reference");
		
	mylist.forEach(System.out::println);
	}
}