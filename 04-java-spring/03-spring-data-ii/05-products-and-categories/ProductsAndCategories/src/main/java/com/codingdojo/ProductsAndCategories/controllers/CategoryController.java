package com.codingdojo.ProductsAndCategories.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.ProductsAndCategories.services.CategoryService;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	private final CategoryService categoryService;
	
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	//create new category
	
	//add product to existing category
	
	
	
	
	
	
	
	
	
	
	
	

} // end CategoryController class
