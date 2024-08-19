package com.momg.taskmvc.service;

import java.util.List;

import com.momg.taskmvc.entity.product;

public interface productService  {
	
	public List<product> getProducts ();

	public void saveProduct(product theproduct);

	public product getProduct(long theId);

	public void deleteProduct(long theId);
}
