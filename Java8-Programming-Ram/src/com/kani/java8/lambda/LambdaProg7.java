package com.kani.java8.lambda;
  @FunctionalInterface
  interface Addition{
	   public int  myadd(int a,int b);
  }

public class LambdaProg7 {

	public static void main(String[] args) {
		
		
		
		Addition add=(a,b) -> { 
			
			  {
				int sum=a+b;
				return sum;
			 }
		} ; 
				
		
		 int s=add.myadd(2,2);
		 System.out.println("Addition :"+s);
				
	}

}
