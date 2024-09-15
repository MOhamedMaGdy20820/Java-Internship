package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.thymeleafdemo.dao.ProductRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Product;


@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;
		
	@Autowired
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	@Transactional
	public List<Product> findAll() { 
		//return productRepository.findAll();
		return productRepository.findAllByOrderByNameAsc();
	}

	@Override
	public Product findById(int theId) {
		Optional<Product> result = productRepository.findById(theId);
		Product theproduct = null;
		
		if(result.isPresent()) {
			theproduct =result.get();
		}else {
			// we didn't find the product
			throw new RuntimeException("Did not find product id - " + theId);
		}
	
		return theproduct;
	}

	@Override
	public void save(Product theproduct) {
		productRepository.save(theproduct);
	}

	@Override
	public void deleteById(int theId) {
		productRepository.deleteById(theId);
	} 

}































