package com.microservice.basepackage;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.basepackage.dto.ProductRequest;
import com.microservice.basepackage.dto.ProductResponse;
import com.microservice.basepackage.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	private ProductService productService;
	
	@PostMapping("/createProduct")
	@ResponseStatus(HttpStatus.CREATED)
	public void createProduct(@RequestBody ProductRequest productRequest) {
		
		productService.createProduct(productRequest);
	}
	
	@GetMapping("/getAllProducts")
	@ResponseStatus(HttpStatus.OK)
	public List<ProductResponse> getAllProducts(){
		return productService.getAllProducts();
	}
	
	

}
