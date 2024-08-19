package com.momg.taskmvc.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.momg.taskmvc.entity.product;


public interface ProductRepository extends JpaRepository<product, Long>{


}
