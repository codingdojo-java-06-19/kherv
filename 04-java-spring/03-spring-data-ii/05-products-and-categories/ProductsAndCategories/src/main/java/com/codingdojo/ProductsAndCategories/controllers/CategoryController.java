package com.codingdojo.ProductsAndCategories.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.ProductsAndCategories.models.Category;
import com.codingdojo.ProductsAndCategories.services.CategoryService;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	private final CategoryService categoryService;
	
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	//create new category
	@RequestMapping("new")
	public String addCategory(@ModelAttribute("category") Category category) {
		return "newCategory.jsp";
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String newCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("Errors: " + result);
			return "newCategory.jsp";
		}
		else {
			categoryService.create(category);
			return "redirect:/categories/new";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//add product to existing category
	
	
	
	
	
	
	
	
	
	
	
	

} // end CategoryController class
