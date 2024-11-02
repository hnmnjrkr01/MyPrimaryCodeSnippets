package com.capg.spring;

public class ProductsClient {

	public static void main(String[] args) {
		 ProductServiceImpl p1=new ProductServiceImpl();
		 
		 ProductServiceImpl productService1=new ProductServiceImpl("MacAirM121");
		 productService1.allProducts();
		
		 ProductServiceImpl p3=new ProductServiceImpl();
		 p3.setProducts("MacProM121");
		 
		  p3.allProducts();
		 
		 
		 
		

	}

}
