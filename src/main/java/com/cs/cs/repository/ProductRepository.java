package com.cs.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cs.cs.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
