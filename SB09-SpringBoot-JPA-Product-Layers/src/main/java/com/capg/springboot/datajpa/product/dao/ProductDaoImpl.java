package com.capg.springboot.datajpa.product.dao;

import com.capg.springboot.datajpa.product.entity.ProductBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

 
@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public ProductBean findById(int id) {
		
		return em.find(ProductBean.class, id);
	}

	@Override
	public ProductBean update(ProductBean bean) {
		return  em.merge(bean);
		
	}

}
