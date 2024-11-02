package com.kani.java8.lambda;


interface Person1{
	
	public void eat();
}



public class LambdaProg1Anonymous {

	public static void main(String[] args) {
		
		LambdaProg1Anonymous lp1 = new LambdaProg1Anonymous();
		
		Person1 p1 = new Person1() {
			public void eat() {
				System.out.println("Rich food");
			}
		};
			
		
		p1.eat();
	}

}
