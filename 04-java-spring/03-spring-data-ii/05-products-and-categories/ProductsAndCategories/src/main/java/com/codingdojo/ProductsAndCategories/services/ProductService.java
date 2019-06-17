package com.codingdojo.ProductsAndCategories.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.ProductsAndCategories.models.Product;
import com.codingdojo.ProductsAndCategories.repositories.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
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
	
	
	
	
	
	
	
	
	
	
	
	
} // end ProductService class
 