package com.cgi.myspring;

public class ProductServiceImpl implements ProductService {
  String products; //8.  MacAir2021M1   16. MacPro2021M1 
	
    public ProductServiceImpl() {
	
    }                             //6. MacAir2021M1
   public ProductServiceImpl(String products)
   {
	   this.products=products;  //7 MacAir2021M1
   }                        
   
              //14
    public void setProducts(String products)
    {
    	this.products=products; //15 MacPro2021M1
    }
   
	   //10      //18
    public void allProducts() {
		System.out.println("Hello :"+products);
		
		
	}
	
	

}
