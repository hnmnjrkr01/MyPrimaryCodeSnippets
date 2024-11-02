package com.capg.ram.test.junit.JUNIT4withMaven;
	
import static org.junit.Assert.assertEquals;
import org.junit.Test;

	public class CalculationTest 
	
	  {		
		Calculation cal=new Calculation();
		@Test 
		public void testAdd() 
        	{  
		    try {
		   assertEquals(20, new Calculation().addition(10,10));
		   	   
		   
		   assertEquals(10,cal.subtraction(15,5));
		    assertEquals(4,new Calculation().multiplication(2,2));
		    
		   } catch (Exception e) {
			System.out.println(e);
		 } 
		
		  
	} 
	
		
	}
