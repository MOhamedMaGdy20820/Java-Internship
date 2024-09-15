package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.thymeleafdemo.entity.Product;
import com.luv2code.springboot.thymeleafdemo.service.ProductService;

@Controller
@RequestMapping("/Products")
public class ProductController {
	
	private ProductService ProductService;
	
	public ProductController(ProductService ProductService) {
		this.ProductService = ProductService;
	}

	// add mapping for "/list"
	@GetMapping("/list")
	public String listProducts(Model theModel) {
		
		// get Products from db
		List<Product>theProducts = ProductService.findAll();
		
		// add to the spring model
	    theModel.addAttribute("Products",theProducts);
			    	    
		return "Products/list-Products" ;
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Product theProduct = new Product();
		
		theModel.addAttribute("Product",theProduct);
		
		return "Products/Product-form";
	}
	
	@PostMapping("/save")
	public String saveProduct (@ModelAttribute("Product") Product theProduct) {
	
		// save the Product
		ProductService.save(theProduct);
		// use a redirect to prevent duplicate submissions 
		return "redirect:/Products/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("productId") int theId,Model theModel) {
				
		// get the Product from the service
		Product theProduct = ProductService.findById(theId);
		
		// set Product as a model attribute to per-populate the form
		theModel.addAttribute("Product",theProduct);
				
		// send over to our form
		return "Products/Product-form";
		
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("productId") int theId) {
			
		// delete the Product
		ProductService.deleteById(theId);
		
		// redirect to /Products/list
		return "redirect:/Products/list" ;
		
	}
	

	
	
	
	
}
