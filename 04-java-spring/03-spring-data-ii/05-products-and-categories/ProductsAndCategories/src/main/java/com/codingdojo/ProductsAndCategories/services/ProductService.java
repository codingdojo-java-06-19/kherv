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
public class ProductService {
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	private final CategoryProductRepository categoryProductRepository; 	//added during 6/18/19 leture demonstrating form:option and form:prodcut
	
	public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository, CategoryProductRepository categoryProductRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
		this.categoryProductRepository = categoryProductRepository;
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
	//added during 6/18/19 leture demonstrating form:option and form:prodcut
	public void addCategory(CategoryProduct categoryProduct) {
		categoryProductRepository.save(categoryProduct);
	}
	
	
	
	
	
	//Retrieve all Products That Are already in this Category
	public List<Product> findProductsWithThisCategory(Category category) {
		return productRepository.findByCategoriesContains(category);
	}
	
	//Retrieve all Products that are not already in this Category
	public List<Product> findProductsWithoutThisCategory(Category category) {
		return productRepository.findByCategoriesNotContains(category);
	}
	
	
	
	
	
} // end ProductService class
 