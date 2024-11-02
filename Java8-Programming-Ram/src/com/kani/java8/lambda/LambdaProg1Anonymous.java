package com.kani.java8.lambda;

  interface Person1{
	   public void eat();
  }

public class LambdaProg1Anonymous {

	public static void main(String[] args) {
		
		
		
		Person1 p1=new Person1() { 
			
			 public void eat() {
				 System.out.println("Rich Food");
			 }
		} ; 
				
		
		p1.eat();		
				
	}

}
