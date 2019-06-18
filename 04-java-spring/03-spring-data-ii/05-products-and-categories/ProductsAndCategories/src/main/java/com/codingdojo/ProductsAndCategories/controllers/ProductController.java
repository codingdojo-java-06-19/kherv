package com.codingdojo.ProductsAndCategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.ProductsAndCategories.models.Category;
import com.codingdojo.ProductsAndCategories.models.Product;
import com.codingdojo.ProductsAndCategories.services.ProductService;
import com.codingdojo.ProductsAndCategories.services.CategoryService;

@Controller
@RequestMapping("/products")
public class ProductController {
	private final ProductService productService;
	private final CategoryService categoryService;
	
	public ProductController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
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
			return "redirect:/products/new"; //>>>>>>>>>change this to redirect to the products/{id} page for this product
		}
	}
	
	// Display a product...list of categories it already has...and add allow adding of category to products
	
	// First render product page
	@RequestMapping("/{id}") // id is coming in is of a product..the one whose categories will be listed and to which another category can be added
	public String showProduct(@PathVariable("id") Long id, Model model) {
		Product product1 = productService.findOne(id);
		model.addAttribute("product1", product1);
		//List<Product> products = productService.findAll();  //this is unused, now...don't need any products list...probably
		//model.addAttribute("products", products);
		//List<Category> categoriesNot = categoryService.findAll();  //this needs to change to just categories that this product down NOT have
		List<Category> categoriesNot = categoryService.findCategoriesWithoutThisProduct(product1);  
		//List<Category> categoriesHave = categoryService.findAll();  //this needs to change to just get the categories that this product has
		List<Category> categoriesHave = categoryService.findCategoriesWithThisProduct(product1);  
		model.addAttribute("categoriesNotYetAdded", categoriesNot);
		
		model.addAttribute("categoriesHave", categoriesHave);
		return "showProduct.jsp";
		
	}

	@RequestMapping(value="/addCategory/{id}", method=RequestMethod.POST)
	public String addCategoryToProduct(@RequestParam("category") Long category_id, @PathVariable("id") Long product_id) {
		System.out.println("here");


		productService.addCategoryToProduct(product_id, category_id);
		
		return "redirect:/products/"+product_id;
		
	}
	
	
	
	
	
	

} // end ProductController class
