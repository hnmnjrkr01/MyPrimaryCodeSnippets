package com.kani.java8.lambda;
  @FunctionalInterface
  interface Person3{
	   public void eat(String foodName1,String foodName2);
  }

public class LambdaProg3 {

	public static void main(String[] args) {
		
		
		
		Person3 p3=(foodName1,foodName2) -> { 
			
			  {
				 System.out.println("Eat .. and Drink "+foodName1+foodName2);
			 }
		} ; 
				
		
		p3.eat("Milk","Sugar");		
				
	}

}
