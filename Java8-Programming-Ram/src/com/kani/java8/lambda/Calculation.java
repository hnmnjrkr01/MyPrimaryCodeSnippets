package com.kani.java8.lambda;

 interface Person9{
	 public void eat();
 }

public class Calculation {
	
	public void add() {
		System.out.println("Addition");
	}

	public static void main(String[] args) {
		
		Calculation cal1=new Calculation();
		cal1.add();
		
		Person9 p1=new Person9() { 
			public void eat() {
				System.out.println("Rich Food");
			}
		};
       p1.eat();
	}

}
