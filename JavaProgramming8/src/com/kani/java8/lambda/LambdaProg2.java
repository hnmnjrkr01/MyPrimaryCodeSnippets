package com.kani.java8.lambda;


interface Person2{
	
	public void eat();
}



public class LambdaProg2 {

	public static void main(String[] args) {
				
		Person2 p2 = ()-> {
		  {
				System.out.println("Rich food");
			}
		};
			
		
		p2.eat();
	}

}
