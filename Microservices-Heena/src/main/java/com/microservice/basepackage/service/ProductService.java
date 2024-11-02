package com.microservice.basepackage.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservice.basepackage.dto.ProductRequest;
import com.microservice.basepackage.dto.ProductResponse;
import com.microservice.basepackage.model.Product;
import com.microservice.basepackage.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
	
	private ProductRepository productRepository;


	public void createProduct(ProductRequest productRequest) {
		Product product = new Product(productRequest.getId(),
									productRequest.getName(),
									productRequest.getDescription(), 
									productRequest.getPrice());
									
		productRepository.save(product);
		
		//log.info("Product {} is saved", product.getId());
	}
	
	public List<ProductResponse> getAllProducts(){
		List<Product> productList = productRepository.findAll();
	
		return productList.stream().map(product->mapToProductResponse(product)).toList();
		
	
	}

	
	private ProductResponse mapToProductResponse(Product product) {
		ProductResponse productResponse = new ProductResponse(product.getId(),
															product.getName(),
															product.getDescription(),
															product.getPrice());
		return productResponse;
	}
}
