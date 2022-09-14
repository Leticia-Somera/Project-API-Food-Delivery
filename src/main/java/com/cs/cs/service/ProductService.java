package com.cs.cs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cs.cs.model.Product;
import com.cs.cs.repository.ProductRepository;

@Service
public class ProductService implements IProductService{

	@Autowired
	private ProductRepository productRepository;
	/*
	@Override
	public Product create(Product product) {
		return productRepository.save(product);
	}*/

	@Override
	public Product findById(Long id) {
		Optional<Product> productOptional = productRepository.findById(id);
		return productOptional.orElse(null);
	}

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

}
