package com.cs.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs.cs.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
