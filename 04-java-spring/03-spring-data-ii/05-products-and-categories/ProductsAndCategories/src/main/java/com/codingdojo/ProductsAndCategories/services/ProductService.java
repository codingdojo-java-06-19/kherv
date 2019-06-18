package com.codingdojo.ProductsAndCategories.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.ProductsAndCategories.models.Category;
import com.codingdojo.ProductsAndCategories.models.Product;
import com.codingdojo.ProductsAndCategories.repositories.CategoryRepository;
import com.codingdojo.ProductsAndCategories.repositories.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	
	public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}

	//Return all products
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	
	//Return one product
	public Product findOne(Long id) {
		return productRepository.findById(id).orElse(null);
	}
	
	//Create one product
	public Product create(Product product) {
		return productRepository.save(product);
	}
	
	//Add category to Product using the two ids
	public void addCategoryToProduct(Long product_id, Long category_id) {
		Product product = findOne(product_id);
		Category category = categoryRepository.findById(category_id).orElse(null);
		product.addCategory(category);
		productRepository.save(product);
	}
	
	
	
	
	
	
	
	
	
	
} // end ProductService class
 