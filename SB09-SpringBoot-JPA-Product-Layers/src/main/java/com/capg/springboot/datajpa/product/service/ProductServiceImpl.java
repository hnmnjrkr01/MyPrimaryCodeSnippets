package com.capg.springboot.datajpa.product.service;

 import com.capg.springboot.datajpa.product.entity.ProductBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.springboot.datajpa.product.dao.ProductDao;
import com.capg.springboot.datajpa.product.entity.ProductBean;

@Service
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	ProductDao productDao;
	
	@Override
	public ProductBean findById(int id) {
		
		return productDao.findById(id);
	}

	@Override
	public ProductBean update(ProductBean bean) {
		
		return productDao.update(bean);
	}

}
