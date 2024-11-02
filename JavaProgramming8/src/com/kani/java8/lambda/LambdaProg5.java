package com.kani.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaProg5 {

	public static void main(String[] args) {

		List<Integer> myList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		System.out.println("-------------For-Each Loop----------------");
		for(Integer i : myList)
			System.out.println(i);
		
		System.out.println("-------------Lambda----------------");
		myList.forEach(inte->System.out.println(inte));
		
		System.out.println("-------------Method Reference----------------");
		myList.forEach(System.out::println);

	}

}
