package com.kani.java8.lambda;

import java.util.ArrayList;
import java.util.List;

public class LambdaProg4 {

	public static void main(String[] args) {

		List<String> myGames = new ArrayList<String>();
		
		myGames.add("Cricket");
		myGames.add("Chess");
		myGames.add("Ludo");
		myGames.add("kabbadi");
		
		for(String name : myGames)
			System.out.println(name);
		
		System.out.println("-------------Lambda----------------");
		myGames.forEach(names->System.out.println(names));
		
		System.out.println("-------------Method Reference----------------");
		myGames.forEach(System.out::println);

	}

}
