package com.capg.springboot.datajpa.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.springboot.datajpa.product.entity.ProductBean;
import com.capg.springboot.datajpa.product.exception.ProductException;
import com.capg.springboot.datajpa.product.service.ProductService;


@RestController
public class ProductController {
	@Autowired
	ProductService productservice;
	
	@GetMapping("/find/{id}")
	public ProductBean findById(@PathVariable int id) throws ProductException{
		ProductBean bean = productservice.findById(id);
		if(bean==null)
			throw new ProductException("Id Not Found, Wrong Id:"+id);
		
		return  bean;
	}
	// Postman :PUT :   body  ram 
	/*{
	    "pid": 10,
	    "pname": "HP",
	    "price": 50000.0,
	    "mno": "i5ram"
	}*/
	//http://localhost:9092/update        
	@PutMapping("/update")
	public ProductBean update(@RequestBody ProductBean bean) {
		return productservice.update(bean);
	}

}
