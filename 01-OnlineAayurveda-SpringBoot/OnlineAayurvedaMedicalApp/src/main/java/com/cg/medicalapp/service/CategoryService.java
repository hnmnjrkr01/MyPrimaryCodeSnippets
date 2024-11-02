package com.cg.medicalapp.service;

import java.util.List;

import com.cg.medicalapp.entity.Category;
import com.cg.medicalapp.exception.NoSuchCategoryException;

public interface CategoryService {
		public Category addCategory(Category category);
		public Category updateCategory(Category category , int id) throws NoSuchCategoryException;
		public Category deleteCategory(int id) throws NoSuchCategoryException;
		public List<Category> showAllCategory();
}
