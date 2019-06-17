package com.codingdojo.ProductsAndCategories.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.ProductsAndCategories.models.Product;
import com.codingdojo.ProductsAndCategories.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	// create new product
	@RequestMapping("new")
	public String addCategory(@ModelAttribute("product") Product product) {
		return "newProduct.jsp";
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String newCategory(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("Errors:  " + result);
			return "newProduct.jsp";
		}
		else {
			productService.create(product);
			return "redirect:/products/new";
		}
	}
	
	
	
	
	
	
	

} // end ProductController class
