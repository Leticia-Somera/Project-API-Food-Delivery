package com.cs.cs.service;

import java.util.List;

import com.cs.cs.model.Product;

public interface IProductService {
	
	Product create(Product product);
	
	Product findById(Long id);
	
	List<Product> findAll();

}
