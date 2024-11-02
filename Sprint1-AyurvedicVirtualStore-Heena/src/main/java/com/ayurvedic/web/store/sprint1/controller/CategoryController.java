package com.ayurvedic.web.store.sprint1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayurvedic.web.store.sprint1.entities.Category;
import com.ayurvedic.web.store.sprint1.service.ICategoryService;

@RestController
@RequestMapping("/ayurvedaStore")
public class CategoryController {
	
	private static final HttpStatus HttpStatus = null;

	@Autowired
	ICategoryService categoryService;
	
	@PostMapping(path="/addCategory")
	public ResponseEntity<Category> addCategory(@RequestBody Category category){
		if(category.getCategoryId()==0)
			return new ResponseEntity("Invalid",HttpStatus.NOT_FOUND);
		
		Category categoryAdded = categoryService.addCategory(category);
		return new ResponseEntity(categoryAdded,HttpStatus.OK);
	}

	@GetMapping(path="/showAllCategory")
	public ResponseEntity<List<Category>> showAllCategory(Category category){
		return new ResponseEntity<List<Category>>(categoryService.showAllCategory(),HttpStatus.OK);
	}

}
