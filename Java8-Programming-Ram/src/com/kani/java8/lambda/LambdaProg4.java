package com.kani.java8.lambda;

import java.util.ArrayList;
import java.util.List;

public class LambdaProg4 {

	public static void main(String[] args) {
		 
		List<String> mygames=new ArrayList<String>();
		
		mygames.add("Chess");
		mygames.add("Hocky");
		mygames.add("Kabbadi");
		mygames.add("Cricket");
		
		//System.out.println(mygames);
		
		for(String names:mygames)
			System.out.println(names);
		
		System.out.println("Labmda ...");
		mygames.forEach(names->System.out.println(names));
	}

}
