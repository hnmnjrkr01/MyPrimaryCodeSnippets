package com.kani.java8.lambda;


interface Person3{
	
	public void eat(String food1, String food2);
}



public class LambdaProg3 {

	public static void main(String[] args) {
				
		Person3 p3 = (food1,food2)-> {
		  {
				System.out.println("Rich food "+food1+food2);
			}
		};
			
		
		p3.eat("Mango ","banana");
	}

}
