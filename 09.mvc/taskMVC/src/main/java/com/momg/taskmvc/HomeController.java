package com.momg.taskmvc;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.momg.taskmvc.entity.product;
import com.momg.taskmvc.service.productService;

@Controller("product")
public class HomeController {
	
	@Autowired
	private productService productService;
	
	@RequestMapping("/")
	public String home() {
		System.out.println("home controller");
		return "index";
	}
	
	@RequestMapping("/list")
	public String listProducts(Model theModel) {
		
		List <product> theProducts = productService.getProducts();
		
		for(product p : theProducts) {
		
		System.out.println(p.getName());
		}
		theModel.addAttribute("products",theProducts);

		return "list-Products";
	}
	
	@RequestMapping("/mo")
	public void listProducts() {
		
		product theProduct = productService.getProduct(1);
		
		System.out.println(theProduct.toString());
	}
	
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		product theproduct = new product();
		theModel.addAttribute("product",theproduct);
		return "product-form";
	}
	
	@PostMapping("/saveproduct")
	public String saveProduct(@ModelAttribute ("product") product theProduct ,Model theModel) {
	
		productService.saveProduct(theProduct);

		return "redirect:/list";
	}
	
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("productId") int theId , Model theModel) {
		
		// get the product from the service
		product theProduct = productService.getProduct(theId);
		// set product as a model attribute to pre-populate the form
			theModel.addAttribute("product" ,theProduct );
		// send over to our form
		return"product-form";
	}
	
	
	@GetMapping("/delete")
	public String deleteproduct(@RequestParam("productId") int theId ) {
		
		// delete the product 
		productService.deleteProduct(theId);
		
		return "redirect:/product/list";
	}
	
	

}
