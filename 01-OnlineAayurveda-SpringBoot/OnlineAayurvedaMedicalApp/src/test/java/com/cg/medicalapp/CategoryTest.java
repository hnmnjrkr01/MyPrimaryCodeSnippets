package com.cg.medicalapp;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.cg.medicalapp.entity.Category;
import com.cg.medicalapp.exception.NoSuchCategoryException;
import com.cg.medicalapp.exception.RecordExistsException;
import com.cg.medicalapp.repository.CategoryRepository;
import com.cg.medicalapp.service.CategoryServiceImpl;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class CategoryTest {

	@Mock
	private CategoryRepository repo;
	
	@InjectMocks
	private CategoryServiceImpl categoryService;
	
	private Category c1;
	
	@BeforeEach
	void setUp() {
		c1=new Category(1,"hair");
		
	}
	
	@Test
	void testAddCategory() throws RecordExistsException {
		when(repo.save(c1)).thenReturn(c1);
		Category savedCategory=categoryService.addCategory(c1);
		assertNotNull(savedCategory);
	}
	@Test
	void testRemoveCategory() throws NoSuchCategoryException {
		try {
			Category removeCategory=categoryService.deleteCategory(12);
			assertNotNull(removeCategory);
		} catch (NoSuchCategoryException e) {
		}
	}
}