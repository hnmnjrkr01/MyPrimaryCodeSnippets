package com.ayurvedic.web.store.sprint1.service;

import java.util.List;

import com.ayurvedic.web.store.sprint1.entities.Category;

public interface ICategoryService {

	public Category addCategory(Category category);
	public List<Category> showAllCategory();
	
}
