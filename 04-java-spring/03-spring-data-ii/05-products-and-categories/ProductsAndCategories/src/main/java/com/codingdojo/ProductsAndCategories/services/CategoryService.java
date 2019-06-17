package com.codingdojo.ProductsAndCategories.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.ProductsAndCategories.models.Category;
import com.codingdojo.ProductsAndCategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	private final CategoryRepository categoryRepository;
	
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	//Return all Categories
	public List<Category> findAll(){
		return categoryRepository.findAll();
	}

	//Return one Category
	public Category findOne(Long id) {
		return categoryRepository.findById(id).orElse(null);
	}

	public Category create(Category category) {
		return categoryRepository.save(category);
		
	}
	
	
	
	
	
} // end CategoryService class
