package com.capg.springboot.datajpa.product.service;

 

import com.capg.springboot.datajpa.product.entity.ProductBean;

public interface ProductService {
	
	public ProductBean findById(int id);
	public ProductBean update(ProductBean bean);

}
