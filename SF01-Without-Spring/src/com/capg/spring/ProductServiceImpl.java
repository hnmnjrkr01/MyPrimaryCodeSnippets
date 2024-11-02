package com.capg.spring;
public class ProductServiceImpl implements ProductService{
	String products; //attributes  null  MacAirM121   MacProM121
	public ProductServiceImpl() {  
	}
	
	//Constructor Injection        MacAirM121
	public ProductServiceImpl(String products) { 
		this.products=products; //MacAirM121
		 
	}
	       //Setter Injection   //MacProM121
	public void setProducts(String products) {
		this.products=products; //MacProM121
	}
		
	public void allProducts() { 	
		System.out.println("Hello :"+products); 	
		
	} 
}
