package com.luv2code.springboot.thymeleafdemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	// define fields
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="category")
	private String category;
	
	@Column(name="price")
	private long price;
	
	

	public Product() {
		super();
	}
	
	


	public Product(String name, String brand, String category, long price) {
		super();
		this.name = name;
		this.brand = brand;
		this.category = category;
		this.price = price;
	}




	public Product(int id, String name, String brand, String category, long price) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.category = category;
		this.price = price;
	}

	
	

	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public long getPrice() {
		return price;
	}


	public void setPrice(long price) {
		this.price = price;
	}




	@Override
	public String toString() {
		return "product [id=" + id + ", name=" + name + ", brand=" + brand + ", category=" + category + ", price="
				+ price + "]";
	}


	
	
	
	
}
