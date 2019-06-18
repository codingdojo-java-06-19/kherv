package com.codingdojo.ProductsAndCategories.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.ProductsAndCategories.models.Category;
import com.codingdojo.ProductsAndCategories.models.Product;
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
	
	//Retrieve all Categories That Are Already Added To This Product
	public List<Category> findCategoriesWithThisProduct(Product product){
		return categoryRepository.findByProductsContains(product);
	}
	
	//Retrieve all Categories That Aren't Already Added To This Product
	public List<Category> findCategoriesWithoutThisProduct(Product product){
		return categoryRepository.findByProductsNotContains(product);
	}
	
	
} // end CategoryService class
