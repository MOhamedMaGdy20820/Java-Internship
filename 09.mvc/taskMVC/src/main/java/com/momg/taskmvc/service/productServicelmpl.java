package com.momg.taskmvc.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.momg.taskmvc.dao.ProductRepository;
import com.momg.taskmvc.entity.product;

import jakarta.transaction.Transactional;

@Service
public class productServicelmpl implements productService {

	
	@Autowired
	private ProductRepository productRepository;
	
	
	public List<product> getProducts() {
		return productRepository.findAll();
	}

	@Override
    @Transactional
	public void saveProduct(product theCustomer) {
		productRepository.save(theCustomer);
	}


	@Override
	public product getProduct(long theId) {
		return productRepository.findById(theId).orElse(null);
	}

	@Override
    @Transactional
	public void deleteProduct(long theId) {
		productRepository.deleteById(theId);
	}

	
	
	

}
