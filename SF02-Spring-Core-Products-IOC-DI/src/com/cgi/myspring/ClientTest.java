package com.cgi.myspring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class ClientTest {

	public static void main(String[] args) { //1.
		                                                 //2
	ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		                            //3
	ProductService gs1=(ProductService)factory.getBean("productService1");
		   //9
		gs1.allProducts();
		
		//11
		ProductService gs2=(ProductService)factory.getBean("productService2");
		
		//17
		gs2.allProducts();
		
				
	}  //19
} //20
