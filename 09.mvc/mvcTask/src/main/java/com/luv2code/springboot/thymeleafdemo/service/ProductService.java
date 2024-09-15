package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;

import com.luv2code.springboot.thymeleafdemo.entity.Product;

public interface ProductService {

	public List<Product>findAll();
	
	public Product findById(int theId);
	
	public void save(Product theEmployee);
	
	public void deleteById(int theId);
	
}
