package com.ayurvedic.web.store.sprint1.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayurvedic.web.store.sprint1.entities.Category;
import com.ayurvedic.web.store.sprint1.repository.ICategoryRepository;

@Service
@Transactional
public class CategoryServiceImpl implements ICategoryService{
	
	@Autowired
	ICategoryRepository categoryRepository;

	@Override
	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> showAllCategory() {
		return categoryRepository.findAll();
	}
	
	

}
