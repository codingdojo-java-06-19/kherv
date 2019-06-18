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
import com.codingdojo.ProductsAndCategories.models.CategoryProduct;
import com.codingdojo.ProductsAndCategories.models.Product;
import com.codingdojo.ProductsAndCategories.services.CategoryService;
import com.codingdojo.ProductsAndCategories.services.ProductService;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	private final CategoryService categoryService;
	private final ProductService productService;
	
	public CategoryController(CategoryService categoryService, ProductService productService) {
		this.categoryService = categoryService;
		this.productService = productService;
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
	// Display a category...list of products it already has...and add allow adding of products to this category
	
	// First render product page
	@RequestMapping("/{id}") // id coming in is of a category...the one whose products will be listed and to which more products can be added
	public String showCategory(@PathVariable ("id") Long id, @ModelAttribute("productCategory") CategoryProduct categoryProduct, Model model) {
		Category category1 = categoryService.findOne(id);
		model.addAttribute("category1",  category1);
		
		List<Product> productsHave = productService.findProductsWithThisCategory(category1);
		model.addAttribute("productsHave", productsHave);
		
		List<Product> productsNot = productService.findProductsWithoutThisCategory(category1);
		
		model.addAttribute("productsNotYetAdded", productsNot);
		
		return "showCategory.jsp";
	}
	
	@RequestMapping(value= "/addProduct/{id}", method=RequestMethod.POST)
	public String addProductToCategory(@ModelAttribute("productCategory") CategoryProduct categoryProduct) {
		System.out.println("in category controller add Product POST");
		categoryService.addProduct(categoryProduct);
		return "redirect:/categories/"+ categoryProduct.getCategory().getId();
	}
	
	
	
	
	
	
	
	
	

} // end CategoryController class
