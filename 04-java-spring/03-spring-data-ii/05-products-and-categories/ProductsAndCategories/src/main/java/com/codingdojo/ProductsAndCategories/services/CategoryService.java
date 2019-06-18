package com.codingdojo.ProductsAndCategories.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.ProductsAndCategories.models.Category;
import com.codingdojo.ProductsAndCategories.models.CategoryProduct;
import com.codingdojo.ProductsAndCategories.models.Product;
import com.codingdojo.ProductsAndCategories.repositories.CategoryProductRepository;
import com.codingdojo.ProductsAndCategories.repositories.CategoryRepository;
import com.codingdojo.ProductsAndCategories.repositories.ProductRepository;

@Service
public class CategoryService {
	private final CategoryRepository categoryRepository;
	private final ProductRepository productRepository;
	private final CategoryProductRepository categoryProductRepository; 	//added during 6/18/19 leture demonstrating form:option and form:prodcut
	
	public CategoryService(CategoryRepository categoryRepository, ProductRepository productRepository, CategoryProductRepository categoryProductRepository) {
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
		this.categoryProductRepository = categoryProductRepository;
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
	
	//Add product to category using the two ids
	public void addProductToCategory(Long category_id, Long product_id) {
		Category category = findOne(category_id);
		Product product = productRepository.findById(product_id).orElse(null);
		category.addProduct(product);
		
	}
	
	//added during 6/18/19 leture demonstrating form:option and form:prodcut
	public void addProduct(CategoryProduct categoryProduct) {
		categoryProductRepository.save(categoryProduct);
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
