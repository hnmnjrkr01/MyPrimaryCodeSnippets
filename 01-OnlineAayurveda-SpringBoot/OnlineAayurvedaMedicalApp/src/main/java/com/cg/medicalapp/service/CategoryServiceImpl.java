package com.cg.medicalapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.medicalapp.entity.Category;
import com.cg.medicalapp.exception.NoSuchCategoryException;
import com.cg.medicalapp.exception.RecordNotFoundException;
import com.cg.medicalapp.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

		@Autowired
		CategoryRepository categoryRepository;
		
		@Override
		public Category addCategory(Category category) {
			return categoryRepository.save(category);
		}

		@Override
		public Category updateCategory(Category category , int id) throws NoSuchCategoryException {
			Optional<Category> opt=categoryRepository.findById(id);
			if (opt.isEmpty()) {
				throw new RecordNotFoundException("Given category is not found");
			}
			category = categoryRepository.save(category);
			return category;
			
		}

		@Override
		public Category deleteCategory(int id) throws NoSuchCategoryException {
			Optional<Category> opt=categoryRepository.findById(id);
			if(opt.isPresent()){
				Category deletedCategory=opt.get();
				categoryRepository.deleteById(id);
				return deletedCategory;
			}
			else {
				throw new NoSuchCategoryException("No category with id "+id);
			}
		}

		@Override
		public List<Category> showAllCategory() throws RecordNotFoundException {
			List<Category> categoryList = categoryRepository.findAll();
			if(categoryList.isEmpty())
			{
				throw new RecordNotFoundException("No Category found");
			}
			return categoryList;
		}
		
	}
