package com.kani.java8.lambda;

@FunctionalInterface
interface Addition{
	
	public int myAdd(int a,int b);
}



public class LambdaProg6 {

	public static void main(String[] args) {
				
		Addition add = (a,b)-> {
		  
			int c=a+b;
			return c;
			
		};
			
		
		System.out.println(add.myAdd(5,8));
	}

}
