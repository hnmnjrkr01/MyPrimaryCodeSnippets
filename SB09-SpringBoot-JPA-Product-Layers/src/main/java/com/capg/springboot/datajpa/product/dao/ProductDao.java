package com.capg.springboot.datajpa.product.dao;

 

import com.capg.springboot.datajpa.product.entity.ProductBean;

public interface ProductDao {
	
	public ProductBean findById(int id);
	public ProductBean update(ProductBean bean);

}
